package cecs327_assignment3;

import java.util.Random;

public class Thread implements Runnable{
	
	private Node[] stringArray; //contain our chosen 100 strings to be search or replace
	private String[] stringPool; //contain the original 125 strings
	
	/**
	 * constructor: are we passing shared array here?
	 * @param stringArray
	 * @param stringPool
	 */
	public Thread(Node[] stringArray, String[] stringPool) {
		this.stringArray = stringArray;
		this.stringPool = stringPool;
	}
	
	@Override
	public void run() {
		System.out.println("count: " + search());
		
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	private int search() {
		//Randomly pick a target from stringPool
		Random rand = new Random();
		String target = stringPool[rand.nextInt(stringPool.length)];
		System.out.println("target: " + target); //DEBUGGING
		//initialize count to 0
		int count = 0;
		//travsing the stringArray and count any target found
		for(int i = 0; i < stringArray.length; i++) {
			Node curr = stringArray[i];
			//check if (1) the string in curr is equal to target
			//and (2) curr is not logically removed
			if(curr.getString().equals(target) && !curr.isRemove()) {
				count++;
			}
		}
		return count;
	}
	
      private boolean SearchAndReplace () {
     	Random rn = new Random();
      	Node pred, curr;
	      
      	ring targetToRemove = stringPool[rn.nextInt(stringPool.length)]; //replace this string           
     	String targetToAdd = stringPool[rn.nextInt(stringPool.length)]; //with this string
      
      	for(int i = 0; i < stringArray.length; i++) {
         
            if(stringArray[i].equals(targetToRemove)) {
		pred = stringArray[i - 1] 
                curr = stringArray[i];
                break;
            }         
         }
      
      	 curr.lock(); pred.lock();
     	 try {
		 
            if(Validate(pred, curr)) { //validate
              if(!curr.equals(targetToRemove)) {
		 return false;     
	      }
            }
         
            else {
               curr.logicalRemove();
	       curr = targetToAdd;
	       
	    }
         }
      
         finally {
            curr.unlock();
         }    
	 
	 finally {
	    pred.unlock();	 
	 }
           
     }
	
     private boolean validate(Node pred, Node curr) {    
	return  !pred.marked && !curr.marked && pred.next == curr;   
     }

}
