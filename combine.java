package com.dev.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CounterThread implements Runnable {

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		Random rand = new Random();
		try {
			Thread.sleep(rand.nextInt(900));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
	}

	public static void main(String[] args) throws InterruptedException {
		CounterThread ct = new CounterThread();

		List<Thread> threads = new ArrayList<>();
		for (int i = 1; i < 90; i++) {
			Thread t = new Thread(ct);
			threads.add(t);
			t.start();
		}
		// wait for every thread to finish
		for (Thread t : threads) {
			t.join();
		}

		System.out.println("Final Count = " + ct.getCount());
	}
}



