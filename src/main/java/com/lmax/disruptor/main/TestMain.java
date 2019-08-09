package com.lmax.disruptor.main;

import java.util.concurrent.atomic.AtomicInteger;

public class TestMain {

	public static void main(String[] args) {
		long size = 500 * 1000 * 1000;
		AtomicInteger counter = new AtomicInteger(0);
		long cur = System.currentTimeMillis();
		for (int i = 0; i < size; i++) counter.incrementAndGet();
		System.out.println(System.currentTimeMillis() - cur);
	}
}
