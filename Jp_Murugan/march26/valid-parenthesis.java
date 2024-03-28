import java.util.*;
//use stack inverted operations
class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = s.trim();
		
		Stack<Character> st =new Stack<Character>();
		
		for(char c: s.toCharArray()){
			if(c=='('){
				st.push(')');
			}
			else if(c=='{'){
				st.push('}');
			}
			else if(c=='['){
				st.push(']');
			}
			// is empty is used to determine if only end brackets there, the pop is done to ensure proper parenthesis format
			else if(st.isEmpty() || st.pop()!=c){
				
			} 
		}
		System.out.println(st.isEmpty());
	}
}