package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements  ICollection{
	
	
	private Vector<GameObject> theCollection;
	
	
	public GameObjectCollection(){
		theCollection= new Vector<GameObject>();
	}

	
	public void add(GameObject obj) {
		theCollection.addElement(obj);
	}

	
	public void remove(GameObject obj) {
		theCollection.removeElement(obj);
	}

	
	
	/* The iterator should exist as a private inner class 
	 * inside game object collection class and should implement
	 * an interface called IIterator
	 * */
	private class SpaceVectorIterator implements IIterator{
		
		
		private int currIndex;
		
		
		public SpaceVectorIterator() {
			currIndex= -1;
		}
		
		
		//checking whether there are more elements to be processed in the collection
		public boolean hasNext() {
			if(theCollection.size()<=0)
				return false;
			if(currIndex == theCollection.size() -1)
				return false;
			return true;
		}

		
		//returning the next element to be processed from the collection
		public GameObject getNext() {
			currIndex ++;
			return(theCollection.elementAt(currIndex));
		} 
		
	}


	public IIterator getIterator() {
		return new SpaceVectorIterator();
	}
	
} 
