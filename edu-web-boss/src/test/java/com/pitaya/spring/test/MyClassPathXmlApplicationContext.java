package com.pitaya.spring.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
/**
 * 本类模拟spring ClassPathXmlApplicationContext类，对xml文件的进行解析，获取其中包含的实体类配置信息，
 * 通过反射，实现山寨版的spring依赖注入及bean实例化
 *
 */
public class MyClassPathXmlApplicationContext {
    private List<MyBeanDefinition> beanDefinitions = new ArrayList<MyBeanDefinition>();
    // 用于保存解析xml中的bean实例，key为对应id value为class
    private Map<String, Object> sigletons = new HashMap<String, Object>();

    public MyClassPathXmlApplicationContext(String xmlName) {
        this.readXml(xmlName); // 解析xml
    }

    private void readXml(String xmlName) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        URL xmlPath = this.getClass().getClassLoader().getSystemResource(xmlName);
        try {
            document = saxReader.read(xmlPath);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Map<String, String> nsMap = new HashMap<String, String>();    //用于缓存命名空间map集
        nsMap.put("ns", "http://www.springframework.org/schema/beans");// 命名空间
        XPath xsub = document.createXPath("//ns:bean"); // 创建beans/bean查询路径
        xsub.setNamespaceURIs(nsMap);    //设置命名空间uri
        List<Element> beansElements = xsub.selectNodes(document);    //获取对应空间下节点集

        for (Element element : beansElements) {
            String id = element.attributeValue("id");
            String clazz = element.attributeValue("class");    //<bean>标签的id属性值及class属性值
            MyBeanDefinition beanDefinition = new MyBeanDefinition(id, clazz);
            beanDefinitions.add(beanDefinition);

            List<Object> propNames = new ArrayList<Object>();    //bean子标签<property>的name属性对应的值，也即实体对象如HellowWorld的属性名
            List<Object> propValues = new ArrayList<Object>();//bean子标签<property>的value属性对应的值，也即实体对象如HellowWorld的属性值
            //采用迭代方法获取<bean>标签中子标签
            for (Iterator<Element> iterator = element.elementIterator(); iterator
                    .hasNext();) {
                Element elementSon = (Element) iterator.next();
                for (Iterator ia = elementSon.attributeIterator(); ia.hasNext();) {
                    ia.next();//获取子标签的name对应的属性值及value属性对应的值
                    propNames.add(elementSon.attributeValue("name"));
                    propValues.add(elementSon.attributeValue("value"));
                }
            }
            try {
                //将<bean>标签class属性值转换为Class实例
                Class clazzClass = Class.forName(clazz);
                Object object = clazzClass.newInstance();//通过反射，将class转换为实体对象实例
                Field[] fields = clazzClass.getDeclaredFields();    //获取实体对象所有属性
                for (Field f : fields) {
                    for (int i = 0; i < propNames.size(); i++) {
                        String propername = f.getName();
                        if (propNames.get(i).equals(propername)) {
                            StringBuilder sb = new StringBuilder();
                            String methodName = sb        //根据属性名拼接setXxx方法
                                    .append("set")
                                    .append(propername.substring(0, 1)
                                            .toUpperCase())
                                    .append(propername.substring(1)).toString();
                            Method method = clazzClass.getMethod(methodName,
                                    String.class);
                            method.invoke(object, propValues.get(i));        //执行set方法，为属性赋值，模拟spring的依赖注入
                        }
                    }
                }
                sigletons.put(id, object);
            } catch (Exception e) {
                e.printStackTrace();
            }
            propNames.clear();
            propValues.clear();
        }
    }

    public Object getBean(String beanName) {
        return this.sigletons.get(beanName);
    }
}