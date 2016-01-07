package com.pitaya.test;

import java.util.Map;

import org.junit.Test;

/**
 * java算法实现类
 * http://www.cnblogs.com/liuling/p/2013-7-24-01.html
 * @author a
 *
 */
public class Algorithm {

	/**
	 * 交换排序
	 * 冒泡排序
	 * 思想：递归思想
	 * 复杂度：(n-1)n/2  O(n~2)
	 */
	@Test
	public void  maopaoTest(){
		
		int[] maopaoColeation = {1,9,3,8,7,4,6,5,2,10};
		
		for(int i=0;i<maopaoColeation.length-1;i++){
			for(int n = i+1;n<=maopaoColeation.length-1;n++){
				if(maopaoColeation[i] < maopaoColeation[n]){
					int temp=maopaoColeation[i];
					maopaoColeation[i]=maopaoColeation[n];
					maopaoColeation[n]=temp;
				}
			}
		}
		
		for(int a:maopaoColeation){  
			System.out.print(a+"-");
		}
	}
	
	//快速排序
	//归并排序
	//基数排序
	//选择排序： 简单选择排序   堆排序
	
	/**
	 * 插入排序
	 * 直接插入排序
	 * 思想：递归的思想
	 * keyPoint:利用排序号的序列
	 * 时间复杂度：最优O(n) 最差O(n~2)  平均O(n2)
	 */
	@Test
	public void charuTest(){
		int[] maopaoColeation = {1,9,3,8,7,4,6,5,2,10};
		
		for(int i = 1;i<maopaoColeation.length;i++){
			int temp = maopaoColeation[i];//带排序的元素
			for(int j=i-1;j>0;j--){
				if(maopaoColeation[j]>temp){
					maopaoColeation[j+1]=maopaoColeation[j];
				}else{
					break;
				}
				maopaoColeation[j]=temp;
			}
		}
		
		for(int a:maopaoColeation){
			System.out.print(a+"-");
		}
	}
	
	/**
	 * 插入排序
	 * 二分插入
	 * 思想：优化直接插入的找位置的过程（二分）
	 * 算法复杂度：最坏O(n2/2) 最好O(n)  平均O(n2)
	 */
	@Test
	public void erfencharuTest(){
		int[] maopaoColeation = {1,9,3,8,7,4,6,5,2,10};
		for(int i=0;i<maopaoColeation.length;i++){
			int temp = maopaoColeation[i];
			int left = 0;
			int right = i-1;
			int mid = 0;
			while(left<=right){
				mid = (left + right)/2;
				if(temp<maopaoColeation[mid]){
					right = right-1;
				}else{
					left = left+1;
				}
			}
			for(int j=i-1;j>=left;j--){
				maopaoColeation[j+1] = maopaoColeation[j]; 
			}
			if(left != i){
				maopaoColeation[left] = temp;
			}
		}
		for(int a:maopaoColeation){
			System.out.print(a+"-");
		}
	}
	
	/**
	 * 插入排序
	 * 希尔排序
	 * 思想：分组插入排序
	 * 算法复杂度 ： 相对于直接插入排序，希尔插入的数据要快，原因是每次分组排序后已经是有序的
	 */
	@Test
	public void xierTest(){
		int[] maopaoColeation = {1,9,3,8,7,4,6,5,2,10};
		int d = maopaoColeation.length/2;
		while(true){
			d = d /2;
			for(int x = 0;x<d;x++){
				for(int i = x+d;i<maopaoColeation.length;i=i+d){
					int temp  =maopaoColeation[i]; 
					int j;
					for(j = i-d;j>=0 && maopaoColeation[j]>temp;j=j-d){
						maopaoColeation[j+d] = maopaoColeation[j];
					}
					maopaoColeation[j+d] = temp;
				}
			}
			if(d ==1 ){
				break;
			}
		}
		for(int a:maopaoColeation){
			System.out.print(a+"-");
		}
	}
	
	
	
}
