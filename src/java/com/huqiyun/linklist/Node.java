package com.huqiyun.linklist;

public class Node{
	private Node left;
	private Object NodeValue;
	private Node right;
	public Node() {
	}
	public Node(Object NodeValue) {
		this.NodeValue=NodeValue;
	}
	public Node(Node left,Node right,String NodeValue){
		this.left=left;
		this.right=right;
		this.NodeValue=NodeValue;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Object getNodeValue() {
		return NodeValue;
	}
	public void setNodeValue(String nodeValue) {
		NodeValue = nodeValue;
	}
	@Override
	public boolean equals(Object obj) {
		Node o=(Node)obj;
		return this.NodeValue.equals(o.getNodeValue());
	}
}
