package com.practice.linkedlist;

public class ReverseLL {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node reverse(Node head) {

		Node currentNode = head;
		Node previousNode = null;
		
		Node nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		return previousNode;
	}

	public static Node reverse(Node head, int k) {

		Node currentNode = head;
		Node previousNode = null;
		Node nextNode = null;

		int count = 0;

		while (count < k && currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
			count++;
		}

		if (nextNode != null) {
			head.next = reverse(nextNode, k);
		}

		return previousNode;
	}

	
    // Reverse k nodes alternatively i.e. if k = 3 , reverse 3 nodes, then keep next 3 as it is, then reverse next 3 and so on			
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode current = head;
        ListNode previous= null;
        ListNode next = null;
        int count =0;
        
        while(current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;            
            count++;
        }
                
        count= 0;
        if(head!=null) {
            head.next = current;
        }
        while(current != null && count < k) {
            current = current.next;
            count++;
        }
        
        
        if(current != null) {
            current.next = reverseKGroup(current.next, k);
        }
        
        return previous;
    }
	
   // Reverse linked list nodes in the group of k only if remaining nodes>k
   // If nodes are less than K, just keep them as it is	
   public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) {
            return head;
        }
         
        return reverse(head, k);
        

    }
    
    public ListNode reverse(ListNode head, int k) {
        
	// Using temo node check if there are k nodes in the list   
        ListNode temp = head;
        int count =0;
        while(temp!=null && count<k) {
            count++;
            temp = temp.next;
        }
        // If remaining number of nodes are not equal k the we don't want to reverse
        if(count!=k) {
            return head;
        }
        
        
        ListNode current = head;
        ListNode previous= null;
        ListNode next = null;
        count = 0;
        while(current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;            
            count++;
        }
                       
        if(current != null) {
            head.next = reverseKGroup(current, k);
        }
        
        return previous;
 
    }


	
	public static void printList(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	public static void main(String[] args) {

		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		//printList(head);
		printList(reverse(head,3));

	}

}
