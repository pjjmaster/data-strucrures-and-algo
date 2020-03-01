package com.practice.multithreading;

public class EvenThread implements Runnable {

	SharedPrinter printer;

	int index;

	public EvenThread(SharedPrinter printer, int index) {
		this.printer = printer;
		this.index = index;
	}

	@Override
	public void run() {

		for (int i = 2; i < this.index; i = i + 2) {
			printer.printEvenNumer(i);
		}

	}
}