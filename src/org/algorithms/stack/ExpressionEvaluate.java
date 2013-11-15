package org.algorithms.stack;

import java.util.HashMap;
import java.util.Map;

public class ExpressionEvaluate {
	
	private final static Map<String,Oper> operMap = new HashMap<String,Oper>();
	
	static{
		for(Oper oper:Oper.values()){
			operMap.put(oper.toString(), oper);
		}
	}
	
	public static void main(String[] args) {
		int result = caculate("10000+11*(3*5+1-80)*4/(10+3)*5");
		System.out.println(result);
	}
	
	public static int caculate(String source){
		//operand stack
		Stack<Integer> opndStack = new Stack<Integer>();
		//operator stack
		Stack<String> operStack = new Stack<String>();
		
		Stack<String> curOpndStack = new Stack<String>();
		for(int i=0;i<source.length();){
			String c = source.substring(i, i+1);
			if(isOper(c)){
				generateFrontOpnd(curOpndStack,opndStack);
				if(operStack.isEmpty()){
					operStack.push(c);
					i++;
					continue;
				}
				Oper oper2 = getOper(c);
				Oper oper1 = getOper(operStack.peek());
				switch(oper1.compare(oper2)){
					case 1:
						caculateStackTop(opndStack,operStack);
						break
						;
					case 0:
						operStack.pop();
						i++;
						break
						;
					case -1:
						operStack.push(c);
						i++;
						break
						;
					default:
						;
				}
				
			}else{
				i++;
				curOpndStack.push(c);
			}
		}
		generateFrontOpnd(curOpndStack,opndStack);
		calculateRemaindStackElement(opndStack,operStack);
		return opndStack.pop();
	}
	
	public static void calculateRemaindStackElement(Stack<Integer> opndStack,Stack<String> operStack){
		while(operStack.peek()!=null)
			caculateStackTop(opndStack,operStack);
	}
	
	public static void generateFrontOpnd(Stack<String> curOpndStack,Stack<Integer> opndStack){
		if(curOpndStack.isEmpty())
			return;
		StringBuilder sb = new StringBuilder();
		int size = curOpndStack.size();
		for(int i=0;i<size;i++){
			sb.insert(0, curOpndStack.pop());
		}
		opndStack.push(Integer.parseInt(sb.toString()));
	}
	
	public static Integer caculateStackTop(Stack<Integer> opndStack,Stack<String> operStack){
		int v1 = opndStack.pop();
		int v2 = opndStack.pop();
		Oper oper = getOper(operStack.pop());
		Integer result = oper.calculate(v2, v1);
		opndStack.push(result);
		return result;
	}
	
	public static Oper getOper(String c){
		Oper oper = operMap.get(c);
		if(oper==null)
			throw new RuntimeException("Incorrect algorithms expression");
		return oper;
	}
	
	public static boolean isOper(String c){
		return operMap.containsKey(c);
	}
}
