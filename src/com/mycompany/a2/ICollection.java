package com.mycompany.a2;

public interface ICollection {
	
	public void add(GameObject obj);
	public void remove(GameObject obj);
	public IIterator getIterator();

}
