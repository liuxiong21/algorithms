package org.algorithms.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.algorithms.stack.Stack;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	private List<Node<T>> nodes = new ArrayList<Node<T>>();
	
	
	public List<T> preOrderTraverse(){
		List<T> results = new ArrayList<T>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node<T> p;
			while((p=stack.peek())!=null){
				results.add(p.data);
				stack.push(p.lChild);
			}
			stack.pop();
			if(stack.isEmpty()){
				p = stack.pop();
				stack.push(p.rChild);
			}
		}
		return null;
	}
	
	public List<T> inOrderTraverse(){
		List<T> results = new ArrayList<T>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node<T> p;
			while((p=stack.peek())!=null)
				stack.push(p.lChild);
			stack.pop();
			if(stack.isEmpty())
				break;
			p = stack.pop();	
			results.add(p.data);
			stack.push(p.rChild);
		}
		return results;
	}
	
	public List<T> postOrderTraverse(){
		List<T> results = new ArrayList<T>();
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node<T> p,sibling = null;
			while((p=stack.peek())!=null){
				stack.push(p.lChild);
				if(p.rChild!=null)
					sibling = p.rChild;
			}
			stack.pop();
			if(stack.isEmpty())
				break;
			p = stack.pop();
			results.add(p.data);
			stack.push(sibling);	
		}
		return results;
	}
	
	public List<T> levelOrderTraverse(){
		return null;
	}
	
	public void add(T t){
		Node<T> nd = root;
		if(nd==null){
			root = new Node<T>();
			root.data = t;
			return;
		}
		Comparable<T> cptr = (Comparable<T>)t;
		Node<T> p = null;
		int cr = 0;
		while(nd!=null){
			p = nd;
			cr = cptr.compareTo(nd.data);
			if(cr>0)
				nd = nd.lChild;
			else if(cr<0)
				nd = nd.rChild;
			else
				return;
		}
		nd = new Node<T>();
		nd.data = t;
		nd.parent = p;
		if(cr>0)
			p.lChild = nd;
		else
			p.rChild = nd;
	}
	
	private Node<T> getNode(T t){
		for(Node<T> node:nodes){
			if(t.equals(node.data)){
				return node;
			}
		}
		return null;
	}
	
	public boolean remove(T t){
		Comparable<T> cptr = (Comparable<T>)t;
		Node<T> nd = root;
		while(nd!=null){
			int s = cptr.compareTo(nd.data);
			if(s==0){
				if(nd==root)
					root = null;
				else if(nd.parent.lChild==nd)
					nd.parent.lChild = null;
				else
					nd.parent.rChild = null;
				nd = null;
				return true;
			}else if(s>0)
				nd = nd.lChild;
			else
				nd = nd.rChild;
		}
 		return false;
	}
	
	public boolean contains(T t){
		Comparable<T> cptr = (Comparable<T>)t;
		Node<T> nd = root;
		while(nd!=null){
			int s = cptr.compareTo(nd.data);
			if(s==0)
				return true;
			else if(s>0)
				nd = nd.lChild;
			else
				nd = nd.rChild;
		}
 		return false;
	}
	
	public T getParent(T t){
		for(Node<T> node:nodes){
			if(t.equals(node.data)){
				return node.parent.data;
			}
		}
		return null;
	}
	
	public T getRoot(){
		if(root==null)return null;
		return root.data;
	}
	
	public int deep(){
		return 0;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
}

class Node<T>{
	
	public T data;
	
	public Node<T> lChild;
	
	public Node<T> rChild;
	
	public Node<T> parent;
}
