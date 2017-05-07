package com.patterns.template.generics;

@FunctionalInterface
public interface ITemplate <X, Y>{

	Y execute(X request);
	
	default void step1(){
		System.out.println("preprocess");
	}
	
	default void step2(){
		System.out.println("postprocess");
	}
	
	default Y process(X request){
		step1();
		Y response = execute(request);
		step2();
		return response;
	}
}
