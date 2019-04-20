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
public class Node<T> {
	private T obj;
	private Node<T> next;

	public Node(final T o, final Node<T> n) {
		this.obj = o;
		this.next = n;
	}

	public Node() {
		this.obj = null;
		this.next = null;
	}

	// Methoden
	public void setElement(final T o) {
		this.obj = o;
	}

	public T getElement() {
		return this.obj;
	}

	public void setNext(final Node<T> n) {
		this.next = n;
	}

	public Node<T> getNext() {
		return this.next;
	}
}