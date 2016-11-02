package cecs327_assignment3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A class representing a Node.
 * A Node contain a string (String) and a removed maker (boolean) to identify
 * if this node is logically removed or not.
 */
public class Node {
	
	private String string;
	
	private boolean removed;
	
	private Lock lock = new ReentrantLock();
	
	/**
	 * Constructor
	 * @param value: to be store in this node
	 */
	public Node(String string) {
		this.string = string;
		removed = false;
	}
	
	/**
	 * This method logically removes this node
	 */
	public void logicalRemove() {
		removed = true;
	}
	
	/**
	 * This method show whether or this node is removed
	 * @return removed boolean
	 */
	public boolean isRemove() {
		return removed;
	}
	
	/**
	 * This method return the string data member of this node
	 * @return string value
	 */
	public String getString() {
		return string;
	}
	
	/**
	 * This method return a string showing the content of the node
	 */
	public String toString() {
		return "value: " + string + " removed: " + removed;
	}
	
	public void lock() {
		lock.lock();
	}
	
	public void unlock() {
		lock.unlock();
	}
}
