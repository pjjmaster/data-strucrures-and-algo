package com.practice.multithreading;

public class SharedPrinter {

	boolean evenflag = false;

	public void printEvenNumer(int num) {

		synchronized (this) {

			if (!evenflag) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(num);
			evenflag = false;
			notify();
		}
	}

	public void printOddNumer(int num) {

		synchronized (this) {

			if (evenflag) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(num);
			evenflag = true;
			notify();
		}
	}

}
