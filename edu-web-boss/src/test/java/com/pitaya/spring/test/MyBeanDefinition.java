package com.pitaya.spring.test;

/**
 * 模拟spring中的BeanDefinition 此处该类是一个简单的bean类，用于模拟id和classname对应关系
 * 
 */
public class MyBeanDefinition {
	private String id; // 对应xml<bean>标签id属性值
	private String classname; // 对应class 属性值

	public MyBeanDefinition(String id, String classname) {
		this.id = id;
		this.classname = classname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
}
