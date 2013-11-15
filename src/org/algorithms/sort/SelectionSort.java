package org.algorithms.sort;

import java.util.Random;


/**
 * ������A[i+1]��A[n]��ѡ����С��һ��Ԫ�غ�A[i]���н�����i=0,1,2....n-1
 * @author liuxiong21
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 200000;
		int[] array = new int[len];
		Random rand = new Random(47);
		for(int i=0;i<len;i++){
			array[i] = rand.nextInt(100000);
		}
		long start = System.currentTimeMillis();
		sort(array);
		System.out.println(System.currentTimeMillis()-start);
	}
	
	public static void sort(int[] array){
		for(int i=0;i<array.length-1;i++){
			int minVal=array[i];
			int index = i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<minVal){
					minVal = array[j];
					index = j;
				}
			}
			array[index] = array[i];
			array[i] = minVal;
		}
	}

}
