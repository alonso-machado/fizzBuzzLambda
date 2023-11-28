package org.alonso.lambda;

import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {

		System.out.println("Running in console for 20 Numbers");

		IntStream.rangeClosed(1, 20).forEach(i -> {
			StringBuilder sb = new StringBuilder();
			if (i % 3 == 0 && i % 5 == 0) {
				sb.append(i + " C\n");
			} else if (i % 3 == 0) {
				sb.append(i + " A\n");
			} else if (i % 5 == 0) {
				sb.append(i + " B\n");
			} else {
				sb.append(i+"\n");
			}
			System.out.println(sb.toString());
		});

	}
}