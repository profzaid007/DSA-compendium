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

//Delete Start

	public void deleteStart(){
		if(isEmpty()){
			return;
		}
		Node temp = head;
		head = head.next;
		temp.next = null;
	}
//Delete End
	
	public void deleteEnd(){
		if(head == tail){
			return;
		}
		Node temp = head;
		while(temp.next.next!=null){
			temp = temp.next;
		}
		tail =temp;
		System.out.println("\n"+tail.data);
		temp.next = null;
	}
//Delete Middle at index
	public void deleteAt(int index){
		if(isEmpty()){
			return;
		}
		if(index==0){
			deleteStart();
		}else{
			Node temp = head;
			Node prev = null;
			int t =1;
			while(t!=index){
				prev = temp;
				temp=temp.next;
				t++;
			}
			prev.next = temp.next;
			temp.next=null;			
		}
		
	}
		
}
	
class Main{
	public static void main(String [] args){
		LinkedList list = new LinkedList();
		for(int i =1;i<5;i++){
			list.insert(i);
		}
		
		System.out.print(list);//explicit to string is invoked
		list.deleteAt(3);
		System.out.println("\nDeleted: "+list);		
	}
}