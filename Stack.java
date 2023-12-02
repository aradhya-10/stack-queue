class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

	LinkedList(int data){
		Node list = new Node(data);
		head = list;
	}

	LinkedList(int []data) {
		if (data.length > 0) {
            head = new Node(data[0]);
            Node current = head;

            for (int i = 1; i < data.length; i++) {
                current.next = new Node(data[i]);
                current = current.next;
            }
        }
	}

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

	public void insertBefore(Node nextNode, int data) {
        if (nextNode == null) {
            System.out.println("Next node cannot be null");
            return;
        }		
		Node headd = head;
		while(headd.next != nextNode)
			headd = headd.next;
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

	public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

	public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

	public void insertAfter(int prevData, int data) {
		Node headd = head;
		if(headd == null)
			this.append(data);
		while(headd.next != null && prevData!=headd.data)
			headd = headd.next;
        Node newNode = new Node(data);
        newNode.next = headd.next;
    	headd.next = newNode;
    }

	public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

	public void popLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

	public Node search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

	public void delete(int data){
		Node headd = head;
		while(headd.next.next != null && data!=headd.next.data)
			headd = headd.next;
		head.next = head.next.next;
	}

	public void add(int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

	public void display() {
		int i = 0;
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
			i++;
        }
        System.out.println("null");
        System.out.println("Size of list: "+i);
    }
}

public class Stack {
	private LinkedList linkedList;

    public Stack(int data) {
		LinkedList list = new LinkedList(data);
        this.linkedList = list;
    }

    public Stack(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public void push(int data) {
		System.out.println("Pushing into stack: " + data);
        Node newNode = new Node(data);
        newNode.next = linkedList.head;
        linkedList.head = newNode;
    }

	public void pop() {
        if (linkedList.head != null) {
			System.out.println("Popped: "+linkedList.head.data);
            linkedList.head = linkedList.head.next;
		}else{
			System.out.println("Stack Underflow");
		}
    }

	public int peek() {
		System.out.println("Peek: "+linkedList.head.data);
		return linkedList.head.data;
	}

	public void display() {
        Node current = linkedList.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

	public static void main(String[] args) {
		// int[] values = {56, 30, 70};
        // LinkedList linkedList = new LinkedList(values);
		
        Stack stack = new Stack(30);
        stack.display();
        stack.push(50);
        stack.push(70);
        stack.push(40);
        stack.display();
		stack.peek();
		stack.pop();
        stack.display();
		stack.peek();
	}
}
