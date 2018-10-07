package ds.expressions;

import java.util.Stack;

public class EvaluateInfixExpression {

	public static void main(String[] args) {
		
		EvaluateInfixExpression es = new EvaluateInfixExpression();
		es.evaluateExpression("12*2+5");
	}
	public void evaluateExpression(String infix){
		char [] arr = infix.toCharArray();
		int n = infix.length();
		Stack<Integer> value = new Stack<Integer>();
		Stack<Character> ops = new Stack<>();
		
		for(int i=0;i<n;){
			if(arr[i]==' '){
				i++;
				continue;
			}
			if(arr[i]=='('){
				ops.push(arr[i]);
				i++;
			}else if(arr[i]=='+' || arr[i]=='-' || arr[i]=='/' ||  arr[i]=='*' ){
				while(!ops.isEmpty() && precedence(arr[i])<=precedence(ops.peek())){
					value.push(helper(value.pop(),value.pop(),arr[i]));
				}
				ops.push(arr[i]); 
				i++;
			}
			else if(arr[i]>='0' && arr[i]<='9'){
				StringBuilder sb = new StringBuilder();
				while(i<n && arr[i]>='0' && arr[i]<='9'){
					
					sb.append(arr[i++]);
				}
				value.push(Integer.parseInt(sb.toString()));
				
				
			}else if(arr[i]==')'){
				while(!ops.isEmpty() && ops.peek()!='('){
					value.push(helper(value.pop(),value.pop(),arr[i]));
				}
				ops.pop();
				i++;
			}
		}
		while(!ops.isEmpty()){
			value.push(helper(value.pop(),value.pop(),ops.pop()));
		}
		System.out.println(value.pop());
		
	}
	private Integer helper(Integer b, Integer a, char c) {
		switch(c){
		case '+':
		return a+b;
		case '-':
		return a-b;
		case '*':
		return a*b;
		case '/':
		return a/b;
		}
		return null;
	}
	public int precedence(char ch){
		switch(ch){
		
		case '+':
		case '-': 
			return 1;
			
		case '*':
		case '/':
			return 2;
			
		case '^':
			return 3;
		
		}
		return -1;
	}

}
