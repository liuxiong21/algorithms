package org.algorithms.tree;

import java.util.List;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree<String> tree = new BinaryTree<String>();
		tree.add("4");
		tree.add("7");
		//TreeMap<String, String> tm = null;
		tree.add("2");
		tree.add("3");
		tree.add("1");
		tree.add("9");
		tree.add("8");
		List<String> list = tree.inOrderTraverse();
		for(String s:list){
			System.out.println(s);
		}
	}

}
