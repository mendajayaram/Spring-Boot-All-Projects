package com.nt.jai.runner;

 class A {
	void show() {
		System.out.println("x");
	}
}
 class B extends A{
	 void show() {
			System.out.println("y");
		} 
	 public static void main(String[] args) {
		A a=new B();
		a.show();
	}
 }
