package practice.list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

public class ArrangeInGroups {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] l = br.readLine().trim().split("\\s+");
			CustomLinkedList<Integer> list = new CustomLinkedList<>();
			for (int i = 0; i < l.length; i++)
				list.insert(new Node<Integer>(Integer.parseInt(l[i])));
			list.rearrangeByPivot(list.head);
			list.print();
		}

	}

}

class CustomLinkedList<T extends Comparable<T>> {
	Node<T> head;
	Node<T> tail;
	int size;

	public CustomLinkedList() {
		this.head = this.tail = null;
	}

	public void rearrangeByPivot(Node<T> head) {

		Node<T> prev = tail, next = tail, temp = head;

		while (temp != tail) {
			if (temp.data.compareTo(tail.data) < 0) {
				Node<T> t = temp.next;
				temp.next = prev;
				prev = temp;
				temp = t;
			} else {
				next.next = temp;
				temp = temp.next;
				next = next.next;
			}
		}

		next.next = null;
		this.head = prev;

	}

	public Node<T> reverseInGroup(Node<T> head, int k) {

		Node<T> prev = null, curr = head, next = null;

		for (int j = 0; j < k && curr != null; j++) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}

		if (next != null)
			head.setNext(reverseInGroup(next, k));

		return prev;
	}

	public Node<T> rearrange(Node<T> head) {

		Node<T> temp = head, prev = head;

		Deque<Node<T>> deque = new LinkedList<>();
		while (temp != null) {
			deque.add(temp);
			temp = temp.getNext();
		}

		int i = 1;
		prev = head = deque.pollFirst();
		Node<T> t = null;
		while (!deque.isEmpty()) {
			if (i % 2 == 0) {
				t = deque.pollFirst();

			} else {
				t = deque.pollLast();
			}
			prev.setNext(t);
			prev = t;
			i++;
		}

		prev.setNext(null);
		return head;
	}

	public Node<T> insert(Node<T> el) {
		// List is empty
		if (this.head == null)
			head = tail = el;

		else {
			tail.setNext(el);
			tail = tail.getNext();
		}

		size++;

		return this.head;
	}

	public void print() {
		Node<T> temp = this.head;
		StringJoiner sj = new StringJoiner(" ");
		while (temp != null) {
			sj.add(temp.getData().toString());
			temp = temp.getNext();
		}
		System.out.println(sj);
	}

}

class Node<T extends Comparable<T>> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}