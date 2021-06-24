package com.nt.jai;

 class A {
	void show() {
		int i=10;
		System.out.println(i);
	}
}
 class B extends A{
	 void show() {
		 int i=20;
			System.out.println(i);
		} 
	 public static void main(String[] args) {
		A a=new B();
		a.show();
	}
 }
