package org.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

import org.algorithms.stack.Stack;

public class BinaryTree<T> {
	
	private Node root;
	
	private List<Node> nodes = new ArrayList<Node>();
	
	
	public List<T> preOrderTraverse(){
		List<T> results = new ArrayList<T>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node p;
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
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node p;
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
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node p,sibling = null;
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
		Node nd = root;
		if(nd==null){
			root = new Node();
			root.data = t;
			return;
		}
		Comparable<T> cptr = (Comparable<T>)t;
		Node p = null;
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
		nd = new Node();
		nd.data = t;
		nd.parent = p;
		if(cr>0)
			p.lChild = nd;
		else
			p.rChild = nd;
	}
	
	private Node getNode(T t){
		for(Node node:nodes){
			if(t.equals(node.data)){
				return node;
			}
		}
		return null;
	}
	
	public boolean remove(T t){
		Comparable<T> cptr = (Comparable<T>)t;
		Node nd = root;
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
		Node nd = root;
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
		for(Node node:nodes){
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
	
	class Node{
		
		public T data;
		
		public Node lChild;
		
		public Node rChild;
		
		public Node parent;
	}
}


