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

	public List<Integer> subset(int to) {
		if (to < 1) {
			return new ArrayList<Integer>();
		}
		computeAndStore(to);
		return subset(0, to - 1);
	}

	public List<Integer> subset(int from, int to) {
		if (from < 1 || to < 1 || from > to) {
			return new ArrayList<Integer>();
		}

		computeAndStore(to);
		return storage.subList(from - 1, to);
	}

	public int sum(int from, int to) {
		int sum = 0;
		List<Integer> subset = subset(from, to);
		for (Integer fib : subset) {
			sum += fib;
		}
		return sum;
	}

	public int sum(int to) {
		int sum = 0;
		List<Integer> subset = subset(to);
		for (Integer fib : subset) {
			sum += fib;
		}
		return sum;
	}

	public int fib(int n) {
		if (n <= 0) {
			return -1;
		}
		computeAndStore(n);
		return storage.get(n - 1);
	}
}
