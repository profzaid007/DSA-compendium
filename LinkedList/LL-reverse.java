class Node{
	public int data;
	public Node next = null;
	
	public Node(int data){
		this.data = data;
	}
}

class LinkedList{
	private Node head;
	private Node tail;
	public LinkedList(){
		head = null;
	}
//Reverse LinkedList
	public void reverse(){
		
		if(head == null || head.next == null) return;
		Node prev = null;
		Node  curr = head;
		Node next = head.next;
		
		while(next!=null){
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr =prev;
		head = curr;
	}
//Empty CHeck	
	public boolean isEmpty(){
		return head == null && tail == null;
	}
//Insert at End
	public void insert(int value){
		Node node = new Node(value);
		
		if(isEmpty()){ //Empty case
			head= tail= node;
		}else{
			tail.next = node;
			tail = node;
		}
	}
//to string @override
	public String toString(){
		Node curr = head;
		StringBuilder res = new StringBuilder();
		while(curr!=null){
			res.append(curr.data);
			if(curr.next!=null){
				res.append("-->");
			}
			curr= curr.next;
		}
		return res.toString();
	}
}

class Main{
	public static void main(String [] args){
		LinkedList list = new LinkedList();
		for(int i =0;i<4;i++){
			list.insert(i);
		}
		

		
		System.out.print(list);//explicit to string is invoked
		list.reverse();
		System.out.println("\nreversed:"+list);		
	}
}