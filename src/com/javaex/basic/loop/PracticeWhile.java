package com.javaex.basic.loop;

public class PracticeWhile {

	public static void main(String[] args) {
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
	
}
