package com.patterns.template.simple;

public class App {

	public static void main(String[] args) {
		ITemplate template1 = () -> {
			System.out.println("executing template");
		};
		template1.process();
	}

}
