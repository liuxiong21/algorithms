package org.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		//int[] array = new int[]{7, 11, 37, 38, 53, 53, 53, 81, 84, 99};
		int[] array = new int[100];
		for(int i=0;i<array.length;i++){
			array[i] = rand.nextInt(100);
		}
		System.out.println(Arrays.toString(array));
		long cur = System.currentTimeMillis();
		sort(array,0,array.length-1);
		//Arrays.sort(array);
		System.out.println(System.currentTimeMillis()-cur);
		System.out.println(Arrays.toString(array));
	}
	
	public static void sort(int[] array,int left,int right ){
		if(left>=right)
			return;
		int i =left+1,j=right;
		int key = array[left];
		while(true){
			while(array[j]>key)j--;
			while(array[i]<key&i<j)i++;
			if(i>=j)
				break;
			swap(array,i,j);
			if(array[i]==key)
				j--;
		}
		swap(array,left,j);
		if(left<i-1){
			sort(array,left,i-1);
		}
		if(j+1<right){
			sort(array,j+1,right);
		}
		
	}
	
	public static void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
