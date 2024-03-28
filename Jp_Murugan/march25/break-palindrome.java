import java.util.*;

class Main{
	
	public static String breakPal(String palindrome) {
        char[] s = palindrome.toCharArray();
        for(int i=0; i<s.length/2; i++){
            if(s[i] != 'a'){
                s[i] = 'a';
                return new String(s);
            }
        }

        s[s.length-1] = 'b';
        return s.length < 2 ? "" : new String(s); 
    }
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String str = sc.nextLine();
    	System.out.print(breakPal(str));
    }
}