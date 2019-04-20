package de.unistuttgart.vis.dsass2019.ex01.p3;

public interface IQueue<T> {
	
	/** Enqueues an element */
	public void enqueue(T t);
	/** Dequeues the first element */
	public T dequeue();
	/** Returns the first element */
	public T front();
	/** Checks if the queue is empty */
	public boolean isEmpty();
	
}
