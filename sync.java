package com.dev.threads;

public class MyRunnable implements Runnable {

	private int positiveCounter;
	private int negativeCounter;

	private final Object positiveCounterMutex = new Object();
	private final Object negativeCounterMutex = new Object();

	@Override
	public void run() {
		increment(10);
		decrement(9);
	}

	private void increment(int i) {
		synchronized (positiveCounterMutex) {
			positiveCounter += i;
		}
	}

	private void decrement(int i) {
		synchronized (negativeCounterMutex) {
			negativeCounter -= i;
		}
	}
}