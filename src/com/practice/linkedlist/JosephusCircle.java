package com.practice.linkedlist;
 /*
 There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, 
 moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
 The rules of the game are as follows:
  Start at the 1st friend.
  Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
  The last friend you counted leaves the circle and loses the game.
  If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
  Else, the last friend in the circle wins the game.
  Given the number of friends, n, and an integer k, return the winner of the game.
 */

public class JosephusCircle {
  
  
  // Using Circular linked list
  static class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
      this.value = value;
    }
  }

  public int findTheWinner(int n, int k) {

    ListNode head = new ListNode(1);
    ListNode originHead = head;
    for(int i=2 ; i<=n; i++) {
      ListNode newNode = new ListNode(i);
      head.next = newNode;
      head = head.next;
    }
    head.next = originHead;


    for(int count = n; count > 1;--count) {
      for(int j =0; j < k-1; j++) {
        head = head.next;
      }
      head.next = head.next.next;
    }
    return head.value;
  }

 // Recursive Solution
   public int findTheWinnerRecursive(int n, int k) {

      List<Integer> friends = new ArrayList<>();
      for(int i =1;i<=n;i++) {
          friends.add(i);
      }
    
      //(k-1)th index element will be deleted
      int winner = getWinnerRec(k-1, 0, friends);
      
      return winner;
  
  }
    
  private int getWinnerRec(int k, int index, List<Integer> friends) {
      
      if(friends.size() ==1) {
          return friends.get(0);
      }
      // Calculate index which will be deleted
      index = ((index + k) % friends.size());
      friends.remove(index);
      
      return getWinnerRec(k, index, friends);
  }  
 

}
