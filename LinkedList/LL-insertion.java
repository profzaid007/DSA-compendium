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
//Insert First
	public void insertFirst(int value){
		Node node = new Node(value);
		if(isEmpty()){
			insert(value);
		}
		node.next = head;
		head = node;
		
	}
//insert at index
	public void insertAt(int index, int value){
		// if(isEmpty()) throw IllegalArgumentException;
		if(index==0){
			insertFirst(value);
		}else{
			Node node = new Node(value);
			Node curr = head;
			int t = 1;
			while(t!=index){
				curr = curr.next;
				t++;
			}
			node.next = curr.next;
			curr.next = node;
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
		list.insertAt(2,9);

		
		System.out.print(list);//explicit to string is invoked
	}
}