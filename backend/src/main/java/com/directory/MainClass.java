package com.directory;

public class MainClass {
	public static void main(String[] args) {
		String t = """
					<p>Hi<p>
					<h1>something</p>
				""";
		System.out.println(t);
		
		howMany(67);
	
	}
	static void howMany(int k) {
	    switch (k) {
	        case 1  -> System.out.println("one");
	        case 2  -> System.out.println("two");
	        default -> System.out.println("many");
	    }
	}
}
