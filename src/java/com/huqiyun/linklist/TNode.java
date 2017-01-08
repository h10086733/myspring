package com.huqiyun.linklist;

public class TNode<T>{
	private TNode<T> left;
	private T nodeValue;
	private TNode<T> right;
	public TNode() {
	}
	public TNode(T node) {
		this.nodeValue=node;
	}
	public TNode<T> getLeft() {
		return left;
	}
	public void setLeft(TNode<T> left) {
		this.left = left;
	}
	public T getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(T nodeValue) {
		this.nodeValue = nodeValue;
	}
	public TNode<T> getRight() {
		return right;
	}
	public void setRight(TNode<T> right) {
		this.right = right;
	}
}
