package org.algorithms.stack;

public class Stack<T> {

	
	private Object[] array;
	
	private static final int INIT_STACK_SIZE = 5;
	
	private static final int STACK_INCREASE_SIZE = 20;
	
	private int size;
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("top 1");
		stack.push("top 2");
		stack.push("top 3");
		stack.push("top 4");
		stack.push("top 5");
		stack.push("top 6");
		stack.push("top 7");
		System.out.println(stack);
		System.out.println("call peek");
		System.out.println(stack.peek());
		System.out.println("call peek");
		System.out.println(stack);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("call pop");
		System.out.println(stack);
	}
	
	
	public Stack(){
		init();
	}
	
	private void init(){
		array = new Object[INIT_STACK_SIZE];
		size = 0;
	}
	
	private void increaseStack(){
		Object[] a = new Object[size+STACK_INCREASE_SIZE];
		for(int i=0;i<size;i++){
			a[i] = array[i];
		}
		array = a;
	}

	public void push(T e){
		if(isFull())
			increaseStack();
		array[size++] = e;
	}
	
	public T peek(){
		if(isEmpty())
			return null;
		return (T)array[size-1];
	}
	
	public T pop(){
		if(isEmpty())
			return null;
		return (T)array[--size];
	}
	
	private boolean isFull(){
		if(size==array.length)
			return true;
		return false;
	}
	
	public boolean isEmpty(){
		if(size==0)
			return true;
		return false;
	}
	
	public int size(){
		return size;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=size-1;i>=0;i--){
			sb.append(array[i]+"\n");
		}
		return sb.toString();
	}
}
