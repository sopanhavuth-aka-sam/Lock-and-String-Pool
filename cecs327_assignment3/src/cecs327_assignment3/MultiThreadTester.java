package cecs327_assignment3;

import java.util.Arrays;
import java.util.Random;

public class MultiThreadTester {
	
	private static Node[] stringArray; //contain our chosen 100 strings to be search or replace
	private static String[] stringPool; //contain the original 125 strings

	public static void main(String[] args) {
		Random rand = new Random();
		stringPool = new String[150];
		stringArray = new Node[150];
		
		//Generating stringPool
		for(int i = 0; i < stringPool.length; i++) {
			int stringLength = rand.nextInt(10) + 1;
			String newString = "";
			for(int j = 0; j < stringLength; j++) {
				int upperCase = rand.nextInt(2);// 1 == upperCase; 0 == lowerCase
				if(upperCase == 1) {
					char newChar = (char) (rand.nextInt(26) + 65);
					newString += newChar;
				}
				else {
					char newChar = (char) (rand.nextInt(26) + 97);
					newString += newChar;
				}
			}
			stringPool[i] = newString;
		}//END: Generating stringPool
		
		//Randomly selecting 100 strings from stringPool to populate stringArray
		for(int i = 0; i < stringArray.length; i++) {
			int randomIndex = rand.nextInt(stringPool.length);
			stringArray[i] = new Node(stringPool[randomIndex]);
		}
		
		///////////////Debugging output//////////////////////////
		System.out.println(Arrays.toString(stringPool));
		for(int i = 0; i < stringArray.length; i++) {
			System.out.print(i + ". ");
			System.out.println(stringArray[i].toString());
		}
		/////////////////////////////////////////////////////////
		
		//testing thread//
		Thread thread1 = new Thread(stringArray, stringPool);
		thread1.run();
	}

}
