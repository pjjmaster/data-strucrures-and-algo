package com.practice.array;

public class TEst {

	public class A {
		public void printName() {
			System.out.println("Value-A");
		}
	}

	public class B extends A {
		public void printName() {
			System.out.println("Value-B");
		}
	}

	public class C extends A {
		public void printName() {
			System.out.println("Value-C");
		}
	}

	public static void main(String[] args) {
		B b = new B();
		
		if(b instanceof B) {
			System.out.println("TEst.main()");
		}
		
		A d = new B();
		C c = new C();
		d = c;

		//b = c;
		newPrint(b);
	}

	public static void newPrint(A a) {
		a.printName();
	}
}
