package ds.expressions;

//import java.text.ParseException;
import java.util.*;
public class ExpressionEvaluations {

	public static void main(String[] args) {
		ExpressionEvaluations es = new  ExpressionEvaluations();
//		System.out.println(es.infixToPostfix("c/b+a"));
//		System.out.println(es.infixToPrefix("A*B+C/D"));
		es.evaluateExpression("12+2");

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
	
	public String infixToPostfix(String infix){
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
		return result;
		
	}
	
	public String infixToPrefix(String infix){
		//reverse infix string
		//get postfix of reversed infix string
		//reverse result from postfix 
		return reverseString(infixToPostfix(reverseString(infix)));
		
	}

	private String reverseString(String infix) {
		StringBuilder sb  = new StringBuilder(infix);
		return sb.reverse().toString();
	}
	public void evaluateExpression(String infix){
		char [] arr = infix.toCharArray();
		System.out.println(Arrays.toString(arr));
		Stack<String> value = new Stack<>();
		Stack<String> ops = new Stack<>();
		int n = infix.length();
		for(int i=0;i<n;){
			if(arr[i]==' '){
				
				i++;
				continue;
			}
			if(arr[i]=='('){
				ops.push("(");
				i++;
			}else if(arr[i]<='9' && arr[i]>='0'){
				StringBuffer sb = new StringBuffer();
				while(i<n && i>=0 && arr[i]<='9' && arr[i]>='0'){
					sb.append(arr[i]);
					i++;
				}
				value.push(sb.toString());
			}
			else if(arr[i]==')'){
				while(!ops.isEmpty() && ops.peek()!="("){
					String str1 = value.pop();
					String str2 = value.pop();
					String operator = ops.pop();
					Integer newVal = evaluate(str1,str2,operator);
					if(newVal==null){
					    System.out.println("Invalid operator+ "+operator);
					    return;
					}
					value.push(newVal.toString());
				}
				ops.pop();
				i++;
				
			}
			else if(opeartor(arr[i])){
				while(!ops.isEmpty() && precedence(new Character(arr[i]).toString())<=precedence(ops.peek())){
					
					String str1 = value.pop();
					String str2 = value.pop();
					String operator = ops.pop();
					Integer newVal = evaluate(str1,str2,operator);
					
				    value.push(newVal.toString());
					
				}

				ops.push(new Character(arr[i]).toString());
			}
		}
		while(!ops.isEmpty()){
			String str1 = value.pop();
			String str2 = value.pop();
			String operator = ops.pop();
			Integer newVal = evaluate(str1,str2,operator);
		
			value.push(newVal.toString());
		}
	
		System.out.println(value);
	}

	private boolean opeartor(char c) {
		if(c=='+' || c=='-' || c=='/' || c=='*'){
			return true;
		}
		return false;
	}

	private Integer evaluate(String str1, String str2, String operator) {
		switch(operator){
		case "+":
			return Integer.parseInt(str1)+Integer.parseInt(str2);
		case "-":
			return Integer.parseInt(str1)-Integer.parseInt(str2);
		case "/":
			return Integer.parseInt(str1)/Integer.parseInt(str2);
		case "*":
			return Integer.parseInt(str1)*Integer.parseInt(str2);
		}
		return null;
	}
	public int precedence(String ch){
		if("+".equals(ch) || "-".equals(ch)){
			return 1;
		}
		if("/".equals(ch) || "*".equals(ch)){
			return 2;
		}
		return 0;
	}

}
