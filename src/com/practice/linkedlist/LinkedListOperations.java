public class LinkedListOperations {

  private Node head;

  LinkedListOperations(int data) {
    head = new Node(data);
    head.next= null;
  }

  static class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  public Node insert(int data, int position) {
    int count = 1;
    Node newNode = new Node(data);
    if (position == 1) {
      newNode.next = head;
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null && count < position) {
        temp = temp.next;
        count++;
      }
      newNode.next = temp.next;
      temp.next = newNode;
    }
    return head;
  }

  public void printLL(){
    Node node = head;
    if (node != null) {
      System.out.print(node.data + "-->");
    }
    while (node.next!=null) {
      node = node.next;
      System.out.print(node.data+ "-->");
    }

  }

  public static void main(String[] args) {
    int head = 1;
    LinkedListOperations operations = new LinkedListOperations(head);
    operations.insert(2, 1);
    operations.insert(3, 3);
    operations.insert(5, 5);

    operations.printLL();

  }

}
