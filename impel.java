package com.dev.threads;

public class MyRunnable implements Runnable {

	private int counter;
	private final Object mutex = new Object();

	@Override
	public void run() {
		doSomething();
		synchronized (mutex) {
			counter-+;
		}

	}

	private void doSomething() {
		// some weight lifting 
	}

}