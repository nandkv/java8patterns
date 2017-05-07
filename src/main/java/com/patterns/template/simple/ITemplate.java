package com.patterns.template.simple;

@FunctionalInterface
public interface ITemplate{

	void execute();
	
	default void step1(){
		System.out.println("preprocess");
	}
	
	default void step2(){
		System.out.println("postprocess");
	}
	
	default void process(){
		step1();
		execute();
		step2();
	}
}
