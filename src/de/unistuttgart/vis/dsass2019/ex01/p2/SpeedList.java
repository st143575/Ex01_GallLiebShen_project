package de.unistuttgart.vis.dsass2019.ex01.p2;

public class SpeedList<T> implements ISpeedList<T> {
	
	/**
	 * This class represents the Node of a List
	 * 
	 * @author TODO
	 *
	 * @param <T>
	 */
	class Node<S> {
		
		private Node<T> nextNode;
		private Node<T> next8thNode;
		private T data;
		
		Node (Node<T> nextNode, T data){
			this.nextNode = nextNode;
			this.data = data;
		}
		
		/**
		 * This Operation returns the next Node.
		 * @return nextNode
		 */
		Node<T> getNextNode(){
			return this.nextNode;
		}
		
		/**
		 * This Operation returns the Node after 8 Nodes.
		 * @return next8thNode
		 */
		Node<T> getNext8thNode(){
			return this.next8thNode;
		}
		
		/**
		 * This Operation returns the data behind the Node.
		 * @return
		 */
		T getData() {
			return data;
		}
		
		/**
		 * This Operation changes the Data behind the Node
		 * @param data
		 */
		void setData(T data){
			this.data = data;
		}
		
		void setNextNode(Node<T> nextNode){
			this.nextNode = nextNode;
		}
		
		void setNext8thNode(Node<T> next8thNode) {
			this.next8thNode = next8thNode;
		}

	}

	//Attribute
	private final Node<T> head;
	private int size = 0;
	
	SpeedList(){
		this. head = new Node<T>(null, null);
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void prepend(T t) {
		Node<T> newNode = new Node<T>(head.getNextNode(),t);
		head.setNextNode(newNode);
		size++;
		
		//Ab dem neuenten Knoten bekommt jeder neue Knoten einen Zeiger auf den achtnächsten Knoten.
		if (size >= 8) {
			Node<T> node = newNode;
			for (int i = 0; i < 8; i++) {
				node = node.getNextNode();
			}
			newNode.setNext8thNode(node);
		}
	}

	@Override
	public T getElementAt(int pos) throws Exception {
		if (pos >= this.size) {
			throw new Exception("The List has just " + this.size + " elements!. So the highest Value you can enter is " + size + "-1");
		}
		if (pos < 0) {
			throw new Exception("Nagative values are not allowed - it makes no sense. You entered " + pos + " :-)");
		}
		
		Node<T> node = head.getNextNode();
		
		//Es wird versucht möglichst oft die Operation getNext8thNode zu verwenden, damit es einen schnelleren Listenzugriff gibt.
		for (int i = 0; i < pos%8; i++) {
			node = node.getNextNode();
		}
		for (int i = 0; i < pos/8; i++) {
			node = node.getNext8thNode();
		}
		return node.getData();
	}

	@Override
	public T getNext8thElementOf(final int pos) throws Exception {
		if (pos >= this.size - 8) {
			throw new Exception("The List has just " + this.size + " elements!. "
					+ "\nSo the highest Value you can enter is " + (size-9) 
					+ " because you are searching for the the next 8th element."
					+ "\nE.g if you search for the 12th Element you must enter '4'.");
		}
		
		return this.getElementAt(pos + 8);
	}

	public static void main(String[]args) throws Exception {
		
		SpeedList<Integer> list = new SpeedList<>();
		
		for (int i = 1000; i >= 0; i--) {
			list.prepend(i);
		}
		System.out.println(list.size());
		
		for (int i = 0; i<list.size(); i++) {
			System.out.println(list.getElementAt(i));
		}
		for (int i = 0; i<list.size()-8; i++) {
			System.out.println(list.getNext8thElementOf(i));
		}
	}

}
