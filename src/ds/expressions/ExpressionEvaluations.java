package ds.expressions;

import java.util.*;
public class ExpressionEvaluations {

	public static void main(String[] args) {
		ExpressionEvaluations es = new  ExpressionEvaluations();
		es.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");

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
	
	public void infixToPostfix(String infix){
		Stack<Character> stak = new Stack<>();
		String result="";
		int n = infix.length();
		for(int i=0;i<n;i++){
			char ch =infix.charAt(i);
			if(Character.isLetterOrDigit(ch)){
				result=result+ch;
			}
			else if(ch=='('){
				stak.push(ch);
			}else if(ch==')'){
				while(!stak.isEmpty() && stak.peek()!='('){
					result+=stak.pop();
				}
				if(!stak.isEmpty() && stak.peek()!='('){
					System.out.println("invalid expressions");
				}else{
					stak.pop();
				}
			}else{
				while(!stak.isEmpty() && precedence(ch)<=precedence(stak.peek())){
					result+=stak.pop();
				}
				stak.push(ch);
			}		
			
			
			
		}
		while(!stak.isEmpty()){
			result +=stak.pop();
		}
		System.out.println(result);
		
	}

}
