package com.huqiyun.linklist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TlinkedList<T> implements List<T>{
	private TNode<T> head;
	private TNode<T> foot;
	public static void main(String[] args) {
		TlinkedList<String> list=new TlinkedList<String>();
		list.add("aaa");
		list.add("bbb");
		System.out.println(list.size());
		
	}
	@Override
	public boolean add(T e) {
		TNode<T> node=new TNode<T>(e);
		if(head==null){
			head=node;
			foot=node;
			return true;
		}
		//直接添加到尾部
		TNode<T> current = foot;
		current.setRight(node);
		node.setLeft(current);
		this.foot = node;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}
	@Override
	public int size() {
		int i = 0;
		TNode<T> current = head;
		while (current != null) {
			++i;
			current = current.getRight();
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
