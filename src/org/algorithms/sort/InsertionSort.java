package org.algorithms.sort;

import java.util.Random;

public class InsertionSort {

	
	public static void main(String[] args) {
		int[] array = new int[10000];
		Random rand = new Random(47);
		for(int i=0;i<10000;i++){
			array[i] = rand.nextInt(1000);
		}
		sortByAsc(array);
		for(int i=0;i<10000;i++){
			System.out.print(array[i]+",");
			if(i%1000==0)
				System.out.println();
		}
	}
	
	public static void sortByAsc(int[] array){
		if(array.length==1)
			return;
		for(int i=1;i<array.length;i++){
			int key = array[i];
			int j = i;
			while(j>0&&array[j-1]>key){
				array[j] = array[j-1];
				j = j-1;
			}
			array[j] = key;
		}
	}
	
	public static void sortByDesc(int[] array){
		if(array.length==1)
			return;
		for(int i=1;i<array.length;i++){
			int key = array[i];
			int j = i;
			while(j>0&&array[j-1]<key){
				array[j] = array[j-1];
				j = j-1;
			}
			array[j] = key;
		}
	}

}
