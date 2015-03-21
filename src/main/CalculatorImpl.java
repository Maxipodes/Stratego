package main;

import main.Calculator;

public class CalculatorImpl implements Calculator {
	
	public int div(int a,int b){
		return a/b;
	}
	
	public int mult(int a, int b){
		return a*b;
	}
	
	public int add(int a, int b){
		return a+b;
	}
	
	public int sub(int a, int b){
		return a-b;
	}
}
