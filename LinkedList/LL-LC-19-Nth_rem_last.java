//Leetcode: 19 Remove Nth Node From Last

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

//Empty Check	
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
//Solution Leetcode
	public void removeNth(int n){
		if(isEmpty())return;
		if(head==null){
			return;
		}
		Node fast =head;
		Node curr = head;
		Node prev=null;
		while(n>1 && fast!=null){
			fast = fast.next;
			n--;
		}
		while(fast.next!=null){
			prev=curr;
			curr=curr.next;
			fast=fast.next;
		}
		if(prev==null){
			head = curr.next;
			curr.next = null;
			return;
		}
		
		prev.next = curr.next;
		curr.next=null;
		
		
	}
}

class Main{
	public static void main(String [] args){
		LinkedList list = new LinkedList();
		for(int i =1;i<3;i++){
			list.insert(i);
		}
		
		
		System.out.print(list);//explicit to string is invoked
		list.removeNth(2);
		System.out.print("\nDelete:"+list);		
	}
}