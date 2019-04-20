package de.unistuttgart.vis.dsass2019.ex01.p3;

/**
 * Lösungen für Übungsblatt 01 – Aufgabe 3
 * Robert Gall, 3408913, robert@gall.cc;
 * David Lieb, 3408382;
 * Chong Shen, 3111514;
 * Gruppe 19 bei Dominik Larche
 *
 * @author Robert Gall, David Lieb, Chong Shen;
 *
 */
public class Stack<T> implements IStack<T> {

	private final Node<T> head;

	Stack() {
		this.head = new Node<T>();
	}

	/**
	 * puts the Object t of type T as the top Element onto the Stack
	 *
	 */
	@Override
	public void push(final T t) {
		final Node<T> newNode = new Node<T>(t, this.head.getNext());
		this.head.setNext(newNode);
	}

	/**
	 * deletes the top Element of the Stack and returns it.
	 * It returns null, if there is no Element at all.
	 *
	 */
	@Override
	public T pop() {
		if (this.isEmpty()) {
			return null;
		}
		final T content = this.head.getNext().getElement();
		this.head.setNext(this.head.getNext().getNext());
		return content;
	}

	/**
	 * gives back the top Element of the Stack, without deleting it.
	 * It returns null, if there is no Element at all.
	 *
	 */
	@Override
	public T top() {
		if (this.isEmpty()) {
			return null;
		}
		return this.head.getNext().getElement();
	}

	/**
	 * checks if there is no Element on the Stack
	 *
	 */
	@Override
	public boolean isEmpty() {
		return this.head.getNext() == null;
	}
}
