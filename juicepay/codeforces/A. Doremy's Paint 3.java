import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int  t = sc.nextInt();
    while(t--!=0){
    	int n = sc.nextInt();
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < n; i++) {
        int x = sc.nextInt();
        map.put(x, map.getOrDefault(x, 0) + 1);
      }
      
      if(map.size()>2){
      	System.out.println("no");
      }
      else if(map.size()==1){
      	System.out.println("yes");
      }	
      	else {
		boolean flag = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          if (entry.getValue() < n / 2) {
            flag = false;
            break;
          }
        }
        if(flag==true){
        	System.out.println("yes");
        }else{
        	System.out.println("no");
        }
      }
    	
    }
  }
}
