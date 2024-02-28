package app.numericalMethods;

import java.util.ArrayList;

public class MathTokenizer {
	private String expression;
	private  int position;
	private char previous ='?';
	public MathTokenizer(String expression){
		this.expression=expression.toLowerCase().replaceAll(" ","");
		position=0;
	}
	public String[] tokenizedExpression() {
		ArrayList<String> fullList=new ArrayList<String>();
		while (hasNext())fullList.add(next());
		
		return (String[]) fullList.toArray();
	}
	public boolean hasNext() {
		return position<expression.length();
	}
	public String next() {
		
		String token="";
		boolean reachedEndOfToken=false;
		while (position<expression.length()&&!reachedEndOfToken) {
			char current=expression.charAt(position++);
			switch (current) {
				
				case '-':switch (previous) {

					case '-':
					case '+':case '*':
					case '/':case '%':
					case '^':case '(':
					case ')':
						token="negative";
						System.out.println("previous one: "+previous);
						break;
	
					default:
						token="-";
						break;
					}
				reachedEndOfToken=true;
				break;
				case '+':case '*':
				case '/':case '%':
				case '^':case '(':
				case ')':
					token=current+"";
					reachedEndOfToken=true;
					break;
				case '?':	
					throw new IllegalArgumentException("? not  allowed as a char value");
				default: 
					token+=current;
					previous=current;
					while (position<expression.length()&&!reachedEndOfToken) {
						current=expression.charAt(position++);
						
						switch (current) {
						
						case '-':
						case '+':
						case '*':
						case '/':
						case '%':
						case '^':
						case '(':
						case ')':
							reachedEndOfToken=true;
							position--;
							current=previous;
							break;
						default:
							token+=current;
						}
						
						
					}
			}
			
			previous=current;
		}
		
		return token;
	}
	public static void tokenize(String expression){
		
	}
}
