package com.huqiyun.linklist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class linkedList implements List {
	private Node head;
	private Node foot;

	public static void main(String[] args) {
		linkedList list = new linkedList();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("five");
		list.iterator();
		System.out.println(list.size());
		list.remove("two");
		list.iterator();
		System.out.println(list.size());
		list.remove("one");
		list.iterator();
		list.remove("five");
		list.iterator();
		System.out.println(list.size());
		list.add("six");
		list.add("seven");
		list.iterator();
	}

	@Override
	public int size() {
		int i = 0;
		Node current = head;
		while (current != null) {
			i++;
			current = current.getRight();
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator iterator() {
		Node current = head;
		while (current != null) {
			System.out.println(current.getNodeValue() + "---left:"
					+ current.getLeft() + "---right:" + current.getRight());
			current = current.getRight();
		}
		return null;
	}

	@Override
	public boolean add(Object e) {
		Node node = new Node(e);
		if (this.head == null) {
			this.head = node;
			this.foot = node;
			return true;
		}
//		Node current = head;
//		while (current != null) {
//			if (current.getRight() == null) {
//				break;
//			} else {
//				current = current.getRight();
//			}
//		}
		//直接添加到尾部
		Node current = foot;
		current.setRight(node);
		node.setLeft(current);
		this.foot = node;
		return true;
	}
	@Override
	public boolean remove(Object o) {
		Node node = new Node(o);
		Node current = head;
		while (current != null) {
			if (current.equals(node)) {
				System.out.println(node.getNodeValue());
				Node left = current.getLeft();
				Node right = current.getRight();
				if(left==null){
					head=right;
				}else{
					left.setRight(right);
				}
				if(right==null){
					foot=left;
				}else{
					right.setLeft(left);
				}
				break;
			} else {
				current = current.getRight();
			}
		}
		return true;
	}

	@Override
	public Object[] toArray() {

		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {

		return null;
	}

	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {
		head = null;
		foot = null;
	}

	@Override
	public Object get(int index) {

		return null;
	}

	@Override
	public Object set(int index, Object element) {
		return null;
	}

	@Override
	public void add(int index, Object element) {

	}

	@Override
	public Object remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		return null;
	}

}
