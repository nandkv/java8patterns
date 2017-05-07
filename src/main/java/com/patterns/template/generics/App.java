package com.patterns.template.generics;

public class App {

	public static void main(String[] args) {
		ITemplate<String, String> template1 = (request) -> {
			System.out.println("executing:" + request);
			return request.toUpperCase();
		};
		String response = template1.process("request");
		System.out.println(response);
	}

}
