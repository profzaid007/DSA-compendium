
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks;


public class Main{
	
	static class Node{
		int id;
		String str;
		boolean isLocked;
		ArrayList<Node> chid= new ArrayList<>();
		Node parent;
		int des_locked;
		ReentrantLock lock = new ReentrantLock();
		ArrayList<Node> dsc_lockList = new ArrayList<>();
		
		Node (String str){
			this.str = str;
		}
		
		static boolean lock(Node node, int id){
			if(node.isLocked || node.des_locked>0){
				return false;
			}
			
			Deque<Node> pathToRoot = new ArrayDeque<>();
			
			Node current = node;
			while(current!=null){
				if(!current.lock.tryLock()){
					while(!pathToRoot.isEmpty()){
						Node cur = pathToRoot.removeLast();
						cur.lock.unlock();
					}
					return false;
				}
				pathToRoot.push(current);
				current = current.parent;
			}
			try{
				node.isLocked = true;
				node.id = id;
				pathToRoot.removeLast();
				
				while(!pathToRoot.isEmpty()){
					Node cur = pathToRoot.pop();
					cur.des_locked +=1;
					cur.dsc_lockList.add(Node);
					cur.lock.unlock();
				}
			} finally{
				node.lock.unlock();
			}
			
			return true;	
		}

		static boolean unlock(Node node, int id){
			if(!node.isLocked || node.id !=id){
				return false;
			}
			
			Deque<Node> pathToRoot = new ArrayDeque<>();
			Node current = node;
			
			while(current != null){
				if(!current.lock.tryLock{
					
				}
			}
		}
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t--!=0){
			
		}
		System.out.println();
	}
}