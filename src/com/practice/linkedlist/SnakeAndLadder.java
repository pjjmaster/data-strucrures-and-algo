package com.practice.linkedlist;
import java.util.ArrayList;
import java.util.HashMap;

public class SnakeAndLadder {

	

	Node root; 

	public static HashMap<Integer,Integer> ladderMap = new HashMap<Integer, Integer>();

	public static HashMap<Integer,Integer> snakeMap = new HashMap<Integer, Integer>();

	

	// Constructors 

	SnakeAndLadder(int key) 

    { 

        root = new Node(key); 

    } 

  

	SnakeAndLadder() 

    { 

        root = null; 

    }



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		

		SnakeAndLadder snl = new SnakeAndLadder();

		

		int ladders[][] = {{2,14}, {8,22}, {9,31}, {20,38}, {28,84}, {40,59}, {51,67}, {63,81}, {71,86}, {79,100}};

		int snakes[][] = {{17,7}, {54,34}, {62,19}, {64,60}, {85,24}, {90,78}, {99,70}};

		//HashMap<Integer,Integer> ladderMap = new HashMap<Integer, Integer>();

		//HashMap<Integer,Integer> snakeMap = new HashMap<Integer, Integer>();

		HashMap<Integer,Integer> laddersonMyWay = new HashMap<Integer, Integer>();

		

		System.out.println(ladders[1][1]);

		int max = ladders.length>snakes.length?ladders.length:snakes.length;

		int min = ladders.length<snakes.length?ladders.length:snakes.length;

		

		for(int i = 0;i<max;++i) {

			for(int j = 0;j<1;++j) {

				ladderMap.put(ladders[i][j], ladders[i][j+1]);

				if(i<min)

					snakeMap.put(snakes[i][j], snakes[i][j+1]);

			}

		}

		System.out.println(ladderMap);

		System.out.println(snakeMap);

		

		int i =0;

		//int maxLengthofBoard = 100;

		

		//Problem 1 

		int maxDiceVal = 6;

		int possibleMove = 0;

		int count = 0;

		while(i<100) {

			

			for(int j=i;j<=i+maxDiceVal;++j) {

				if(ladderMap.containsKey(j)) {

					laddersonMyWay.put(j, ladderMap.get(j));

				}

				else if(!snakeMap.containsKey(j)){

					possibleMove = j;

				}

			}

			//Will try to find out of multiple ladders in one dice roll, which is the longest ladder

			if(laddersonMyWay.size() >0) {

				int value = 0;

				for(Integer key: laddersonMyWay.keySet()) {

					if(value < laddersonMyWay.get(key)) {

						value = laddersonMyWay.get(key);

					}

				}

				if(value > i && value > possibleMove)

					i = value;

			}else {

				i = possibleMove;

			}

			count++;

			System.out.println("Next stop: "+ i);

			laddersonMyWay.clear();

		} 

		System.out.println("Total Stops: "+ count);

		

		//Problem 2 the tougher one

		// need to implement through 

		

		SnakeAndLadder tree = new SnakeAndLadder();

		int k = 0;

		tree.root = new Node(k); 

		snl.recursiveMethod(tree.root);

		

		

	}

	

	public void recursiveMethod(Node node) {

		ArrayList<Node> nodeList = new ArrayList<>();

		if(ladderMap.containsKey(node.key)) {

			System.out.println("Node value from Ladder: "+node.key);

			nodeList.add(new Node(ladderMap.get(node.key)));

		}else if(snakeMap.containsKey(node.key)) {

			//System.out.println("Node value from Snake: "+node.key);

			//nodeList.add(new Node(snakeMap.get(node.key)));

		}else if(node.key+6 <= 100) {

			nodeList.add(new Node(node.key+1));

			nodeList.add(new Node(node.key+2));

			nodeList.add(new Node(node.key+3));

			nodeList.add(new Node(node.key+4));

			nodeList.add(new Node(node.key+5));
			
			nodeList.add(new Node(node.key+6));

		}

		

		node.child= nodeList.toArray(new Node[nodeList.size()]);

		System.out.println("node.child.length: "+node.child.length);

		for(Node n1: node.child) {

			System.out.println("Node value: "+n1.key);

			if(n1.key<100){

				//Call recursive method

				recursiveMethod(n1);

			}

		}

		

		//return node.child;

		

	}



}



class Node 

{ 

    int key; 

    Node[] child; 

  

    public Node(int item) 

    { 

        key = item; 

        child = null; 

    } 

}

