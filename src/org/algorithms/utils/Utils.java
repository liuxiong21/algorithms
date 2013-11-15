package org.algorithms.utils;

public class Utils {

	public static void printArray(int[] array,int len){
		if(len>array.length)
			len = array.length;
		for(int i=0;i<len;i++){
			System.out.print(array[i]+",");
			if(i!=0&&i%1000==0)
				System.out.println();
		}
	}
	
}
