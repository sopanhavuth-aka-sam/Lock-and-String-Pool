package cecs327_assignment3;

public class Thread implements Runnable{
	
	String[] stringArray; //contain our chosen 100 strings to be search or replace
	String[] stringPool; //contain the original 125 strings to 1. fill stringList
						// and 2. pick a string from stringPool to be searched in stringList
	
	//constructor: are we passing shared array here?
	public Thread(String[] stringArray, String[] stringPool) {
		this.stringArray = stringArray;
		this.stringPool = stringPool;
	}
	
	@Override
	public void run() {
		
		
	}
	
	//My Responsibility
	private boolean search(int target) {
		return false;
	}

}
