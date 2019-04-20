package de.unistuttgart.vis.dsass2019.ex01.p3;

/**
 * Lösungen für Übungsblatt 01 – Aufgabe 3
 * Robert Gall, 3408913, robert@gall.cc;
 * David Lieb, 3408382, st161483@stud.uni-stuttgart.de;
 * Chong Shen, 3111514, st143575@stud.uni-stuttgart.de;
 * Gruppe 19 bei Dominik Larche
 *
 * @author Robert Gall, David Lieb, Chong Shen;
 *
 */
public class Queue<T> implements IQueue<T> {

	private final Node<T> head;
	private Node<T> tail;

	Queue() {
		this.head = new Node<T>();
		this.tail = this.head;
	}

	/**
	 * puts the Object t of type T as the youngest Element into the Queue
	 *
	 */
	@Override
	public void enqueue(final T t) {
		final Node<T> newNode = new Node<T>(t, null);
		this.tail.setNext(newNode);
		this.tail = newNode;
	}

	/**
	 * deletes the oldest Element of the Queue and returns it
	 * It returns null, if there is no Element at all.
	 *
	 */
	@Override
	public T dequeue() {
		if (this.isEmpty()) {
			return null;
		}
		final T content = this.head.getNext().getElement();
		this.head.setNext(this.head.getNext().getNext());
		return content;
	}

	/**
	 * gives back the oldest Element of the Queue, without deleting it.
	 * It returns null, if there is no Element at all.
	 *
	 */
	@Override
	public T front() {
		if (this.isEmpty()) {
			return null;
		}
		return this.head.getNext().getElement();
	}

	/**
	 * checks if there is no Element in the Queue
	 *
	 */
	@Override
	public boolean isEmpty() {
		return this.head.getNext() == null;
	}
}