package org.algorithms.string;

public class Kmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String  p = "abcabcaba";
		String source = "fffffabcabcabcabcabdfffff";
		int index = kmp(source, p);
		System.out.println(index);
		if(index>-1)
			System.out.println(source.substring(index, index+p.length()));
		int[] next = getNext(p);
		for(int i=0;i<p.length();i++){
			System.out.printf(p.charAt(i)+"	");
		}
		System.out.println();
		for(int i:next){
			System.out.printf(i+"	");
		}
	}
	
	public static int kmp(String source,String p){
		int[] next = getNext(p);
		int i=0,j=0;
		while(i<source.length()&&j<p.length()){
			if(source.charAt(i)==p.charAt(j)){
				j++;
				i++;
			}else if(j==0){
				i++;
			}else{
				j = next[j-1];
			}
		}
		if(j>=p.length())
			return i-p.length();
		return -1;
	}
	
	public static int[] getNext(String p){
		int[] next = new int[p.length()];
		next[0] = 0;
		int i=1,j=0;
		while(i<p.length()){
			while(j>0&&p.charAt(i)!=p.charAt(j))
				j = next[j-1];
			if(p.charAt(i)==p.charAt(j))
				j++;
			next[i++] = j;
		}
		return next;
	}

}
