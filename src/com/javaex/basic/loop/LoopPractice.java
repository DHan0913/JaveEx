package com.javaex.basic.loop;

import java.util.Scanner;

public class LoopPractice {

	public static void main(String[] args) {
//	forGugu();
//	whileGugu();
//	forStar();
//	whileStar();
		
	}
	
	public static void forGugu() {
		for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j)); 
                if (j == 9) { 
                    System.out.println("\t"); 
                }
            }
        
	}
	
	
	}
	public static void whileGugu() {
		int i = 2;
        while (i <= 9) { 
            int j = 1;
            while (j <= 9) { 
                System.out.println(i + " * " + j + " = " + (i * j));
                if (j == 9) { 
                    System.out.println("\t");
                }
                j++;
            }
            i++;
        }
		
	}
	public static void forStar() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }	
	public static void whileStar() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int n = scanner.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print("*");
                j++;
               
            }
            System.out.println();
            i++;
        }
        scanner.close();
		
	}
	
	
}
