package org.algorithms.sort;

import java.util.Random;

import org.algorithms.utils.Utils;

/**
 * 将数组A[n]分解成a[0-p]和b[q-r](q=p+1)两个子数组，然后依次对a数组和b数组进行递归
 * 划分，直到子数组长度为1,然后合并各子数组为有序数组
 * @author liuxiong21
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 1000;
		int[] array = new int[len];
		Random rand = new Random(47);
		for(int i=0;i<len;i++){
			array[i] = rand.nextInt(1000);
		}
		long start = System.currentTimeMillis();
		sort(array);
		System.out.println(System.currentTimeMillis()-start);
		Utils.printArray(array, 2000);
	}
	
	public static void sort(int[] array){
		if(array.length==1)
			return;
		int mid = array.length/2;
		int[] la = new int[mid];
		int[] ra = new int[array.length-mid];
		for(int i=0;i<mid;i++){
			la[i] = array[i];
		}
		for(int i=mid,j=0;i<array.length;i++,j++){
			ra[j] = array[i];
		}
		sort(la);
		sort(ra);
		int m=0,n=0,pointer=0;
		for(int i=0;i<array.length;i++){
			if(la[m]<ra[n])
				array[i] = la[m++];
			else
				array[i] = ra[n++];
			pointer = i+1;
			if(m>=la.length||n>=ra.length)
				break;
		}
		for(int i=m;i<la.length;i++){
			array[pointer++] = la[i];
		}
		for(int i=n;i<ra.length;i++){
			array[pointer++] = ra[i];
		}
		
	}

}
