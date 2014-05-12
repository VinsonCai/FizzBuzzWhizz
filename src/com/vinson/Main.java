package com.vinson;

public class Main {

	public static void main(String[] args) {
		FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz.FizzBuzzWhizzBuilder()
				.setStart(1)
				.setEnd(100)
				.setMagicNumber(3, 5, 7)
				.create();
		fizzBuzzWhizz.run();
	}

}
