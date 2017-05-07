package com.patterns.template.generics;

public class App {

	public static void main(String[] args) {
		ITemplate<String, String> template1 = (x) -> {
			System.out.println("executing:" + x);
			return x.toUpperCase();
		};
		String response = template1.process("request");
		System.out.println(response);
	}

}
