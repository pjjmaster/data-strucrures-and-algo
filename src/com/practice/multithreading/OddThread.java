package com.practice.multithreading;

public class OddThread implements Runnable {

	SharedPrinter printer;

	int index;

	public OddThread(SharedPrinter printer, int index) {
		this.printer = printer;
		this.index = index;

	}

	@Override
	public void run() {

		for (int i = 1; i < this.index; i=i+2) {
			printer.printOddNumer(i);
		}

	}
}