package com.practice.multithreading;

public class EvenOdd {

	public static void main(String[] args) {

		SharedPrinter printer = new SharedPrinter();

		Thread t1 = new Thread(new EvenThread(printer, 10));

		Thread t2 = new Thread(new OddThread(printer, 10));

		t1.start();

		t2.start();
	}

}
