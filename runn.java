package com.dev.threads;

public class MyRunnable implements Runnable {

	private int counter;

	@Override
	public void run() {
		increment(10);
		decrement(9);
	}

	private synchronized void increment(int i) {
		counter += i;
	}

	private synchronized void decrement(int i) {
		counter -= i;
	}
}