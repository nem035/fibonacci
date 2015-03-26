package com.numbers.fibonacci.nem;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	private List<Integer> storage = null;
	private int f1 = 1;
	private int f2 = 1;

	public Fibonacci() {
		storage = new ArrayList<Integer>();
		storage.add(f1);
		storage.add(f2);
	}

	// add all uncomputed fibs up to n
	private void computeAndStore(int n) {
		int fib1;
		int fib2;
		int nextFib;

		for (int i = storage.size(); i < n; i++) {
			fib1 = storage.get(i - 2);
			fib2 = storage.get(i - 1);
			nextFib = fib1 + fib2;
			storage.add(i, nextFib);
		}
	}

	public List<Integer> upTo(int to) {
		if (to < 1) {
			return new ArrayList<Integer>();
		}
		computeAndStore(to);
		return between(0, to - 1);
	}

	public List<Integer> between(int from, int to) {
		if (from < 1 || to < 1 || from > to) {
			return new ArrayList<Integer>();
		}

		computeAndStore(to);
		return storage.subList(from - 1, to);
	}

	public int fib(int n) {
		if (n <= 0) {
			return -1;
		}
		computeAndStore(n);
		return storage.get(n - 1);
	}
}
