package com.javaex.basic.loop;

public class MathRandom {

	public static void main(String[] args) {
		RandomWhile();
		RandomFor();
		//(int)(Math.random()*45)+1

	}
		public static void RandomWhile() {
			int i = 1;
			while(i < 7) {
				System.out.print(((int)(Math.random()*45)+1) + " ");
				i = i + 1;
			}
			System.out.println();
		}
		
		public static void RandomFor() {
			for	(int i = 1; i < 7; i++ ) {
				System.out.print(((int)(Math.random()*45)+1) + " ");
			}
			
		}
			
		
}


