package fr.kb.ex;

import java.util.Scanner;

public class SmallestNumber {

	
	public static void main (String[] args) {
		int[] numbers = new int[3];
		int i = 0;
		while( i < 3 ) {
			System.out.println("Enter a number");
			Scanner sc=new Scanner(System.in);
			numbers[i] = sc.nextInt();	
			i++;
		}
		int smallest = numbers[0];
		for (int j = 0; j < 3 ; j++) {
			if(numbers[j] < smallest) smallest = numbers[j];
		}
		System.out.println("Smallest : " + smallest);
		
	}
	
}
