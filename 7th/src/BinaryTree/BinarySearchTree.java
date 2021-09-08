package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private Node root;
	
	private class Node{
		int key;
		Node leftChild;
		Node rightChild;
		
		Node(int key){
			this.key=key;
		}
		
		public String toString() {
			return "���� ����� Ű ���� :" + this.key;
		}
	}
	
	//BinarySearchTree�� ���� root�� ��ȯ
	public Node getRoot() {
		return this.root;
	}
	
	public void addNode(int key) {
		//�߰��ϰ��� �ϴ� key�� findNode �ؼ� BST ���� �����Ѵٸ� , return ��Ŵ
		if(findNode(key)!=null)
			return;
		
		//ã�� ���ߴٸ�, �� BST�� add�ϰ��� �ϴ� key�� �������� �ʴ´ٸ�
		Node newNode = new Node(key);
		
		//Ʈ���� ���� �ƹ��͵� ���� �� ���¶�� 
		if(root == null) {
			root=newNode;	//�߰��ϴ� newNode�� ��Ʈ���� ����
		}else {
			//�� Ʈ���� �ƴ϶��
			Node focusNode = root; // Ž���� ���
			Node parent; //Ž���� ����� �θ���
			
			while(true) {
				
				parent = focusNode;
				
				if(key < parent.key) {
					focusNode=focusNode.leftChild;	//ã���� �ϴ� key���� �� �����ϱ� ������ Ž���ؾ� �Ѵ�.
					
					if(focusNode == null) {		//ã���� �ؼ� �������� ���µ� �װ��� null��, �� ���̶�� �űⰡ newNode�� �� �ڸ�
						parent.leftChild = newNode;
						return;
					}
					
				}else {			//ã���� �ϴ� key ���� �� ū ��� �������� Ž���ؾ� �Ѵ�.
					focusNode = parent.rightChild;
					
					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean deleteNode(int key) {
		Node focusNode = root;
		Node parent = root;
		
		boolean isLeftChild = true;
		
		//while���� ������ focusNode�� ������ ��带 ����Ű��, parent�� ������ ����� �θ��带, �׸��� ������ ��尡  �θ����� left���� right������ ���� ������ ����
		while(focusNode.key != key) { // key���� ã��������
			parent = focusNode;
			
			if(key < focusNode.key) {		//�������� �̵��ؾ� 
				isLeftChild = true;
				focusNode = parent.leftChild;
			}else {
				isLeftChild = false;
				focusNode= parent.rightChild;
			}
			
			if(focusNode==null) {
				return false;
			}
		}
		//replacementNode�� ��带 ������ �� �� �ڸ��� ���� ��ü ��带 �ǹ���.
		Node replacementNode;
		
		//----------���� while�� ���� focusNode�� Ž���� �Ϸ�� ����
		
		//������� ����� �ڽ� ��尡 ���� ���
		if(focusNode.leftChild == null && focusNode.rightChild==null) {
			if(focusNode == root)
				root = null;
			else if(isLeftChild)		//true�� ���ʿ� �־���, false�� �����ʿ� �ִ�
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
	
		//������� ����� ������ �ڽĳ�尡 ���� ��� (���� �ڽ� ��常 �ִ� ���)
		else if(focusNode.rightChild == null) {
			replacementNode = focusNode.leftChild;
			
			if(focusNode==root)
				root = replacementNode;	//��Ʈ���ٸ� , ���� �ڵ忡�� replacementNode�� null�� �� ������
			else if(isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		//������� ����� ���� �ڽĳ�尡 ���� ��� (������ �ڽ� ��常 ���� ��)
		else if(focusNode.leftChild == null) {
			replacementNode = focusNode.rightChild;
			
			if(focusNode==root)
				root = replacementNode;
			else if(isLeftChild)	//parent�� �������� �����̾����� �������̾�����.
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		//������� ����� ���� �ڽĳ�尡 ��� �ִ� ���
		//������ �ڽ� ����� sub tree���� ���� ���� ��带 ã�Ƽ� ������� ��尡 �ִ� �ڸ��� ��ġ
		else {
			Node rightSubTree = focusNode.rightChild;
			replacementNode = getRightMinNode(focusNode.rightChild);
			
			if(focusNode == root)
				root = replacementNode;
			else if(isLeftChild)		//�� ���� while������ key���� ã�� focusNode�� parent����� �������� ������������ �����ϴ°���
				parent.leftChild = replacementNode;	//�׷��� �����̶�� ã�Ƴ� rightminNode�� parent�� ���ʿ��� ����
			else
				parent.rightChild = replacementNode;
			
			replacementNode.rightChild = rightSubTree;	//������Ʈ���� �������� ���� �ö���������ϱ� �װ��� right�� ����Ʈ���� ����
			
			if(replacementNode == rightSubTree)	//������� ����� ������ sub Tree�� ��尡 �ϳ��ۿ� ���� ���
				//getRightMinNode�� ��� �� rightSubTree�� �ּҰ� ���ٴ� ���� �ϳ��ۿ� ���ٴ� ��.
				replacementNode.rightChild = null;	//null�� �����ϴ� ������  �ƹ��͵� ���, �����ڵ�� �֤��̱� rightSubTree�� ������
			
			replacementNode.leftChild = focusNode.leftChild;
		}
		
		return true;
	}
	//--------------------------����Ʈ���� �����κ� �ڵ�� ���ذ� �ʿ��� ------------------------------
	
	//������ ��忡�� ���� ���� ���� ��带 ã�� ��ȯ�Ѵ�.
	private Node getRightMinNode(Node rightChildRoot) {
		Node parent = rightChildRoot;
		Node focusNode = rightChildRoot;
		
		while(focusNode.leftChild !=null) {
			parent = focusNode;
			focusNode = focusNode.leftChild;
		}
		//rightChildRoot���� ���� ���� ���� ���� Node�� Ž���� focusNode�� �� �ִ�.
		parent.leftChild = null;
		//ã�� focusNode�� �θ��� parent.leftChild �� null�� �Ͽ� ������ ���������.
		
		return focusNode;	//��ȯ�Ǵ� focusNode�� Min���� ���� Node
	}
	
	public void inOrderTraverse(Node focusNode) {
		if(focusNode != null) {
			inOrderTraverse(focusNode.leftChild);
			System.out.printf(focusNode.key+" ");
			inOrderTraverse(focusNode.rightChild);
		}
	}
	
	public void preOrderTraverse(Node focusNode) {
		if(focusNode != null) {
			System.out.printf(focusNode.key+" ");
			preOrderTraverse(focusNode.leftChild);
			preOrderTraverse(focusNode.rightChild);
		}
	}
	
	public void postOrderTraverse(Node focusNode) {
		if(focusNode != null) {
			postOrderTraverse(focusNode.leftChild);
			postOrderTraverse(focusNode.rightChild);
			System.out.printf(focusNode.key+" ");
		}
	}
	
	public Node findNode(int key) {
		//Ʈ���� �� Ʈ�����
		if(root ==null)
			return null;
		Node focusNode = root;	//Ž��������� focusNode�� root�� ���� �ű⼭ ���� Ž�� ����.
		
		while(focusNode.key != key) {	//ã���� �ϴ� key ���� ��ġ �Ҷ� ���� �ݺ� ,, ()���� Ű ���� �������� �� �̶� ��
			if(key<focusNode.key) {
				focusNode = focusNode.leftChild;
			}else {
				focusNode = focusNode.rightChild;
			}
			
			//�׷��� Ž���� �ݺ��ϴٰ�, ��ã�� ��� >> focusNode==null�� �Ǵ� ���
			if(focusNode==null)
				return null;
		}
		return focusNode;
	}
	
	public void BFS() {	//������� ����� ���� Queue�� q �� �����ϰ� root�� offer(Queue�� ����)
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node n = q.poll();				//poll() -> Queue���� ���빰�� �ϳ� �����԰� ���ÿ� Queue���� ���� 
			System.out.print(n.key+" ");	//poll()�� ���� ���빰�� Node�̸� .key�� ���� �� ���� �� " " ���� ���
			if(n.leftChild !=null)			//���� Node�� ���� �ּҶ��� ���� �Ѵٸ�  �� �κ��� q�� offer �� 
				q.offer(n.leftChild);		//�װ��� q.isEmpty()�� false�� ���ö����� �ݺ�
			if(n.rightChild !=null)
				q.offer(n.rightChild);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bTree = new BinarySearchTree();
		
		bTree.addNode(50);
		bTree.addNode(25);
		bTree.addNode(75);
		bTree.addNode(15);
		bTree.addNode(30);
		bTree.addNode(70);
		bTree.addNode(85);
		bTree.addNode(2);
		bTree.addNode(18);
		bTree.addNode(26);
		bTree.addNode(32);
		bTree.addNode(32);
		bTree.addNode(32);
		bTree.addNode(32);
		
		bTree.BFS();
		System.out.println("\n");
		
		
		System.out.println("In Order Traversal-----------");
		bTree.inOrderTraverse(bTree.getRoot());
		System.out.println("\n");
		
		System.out.println("Pre Order Traversal-----------");
		bTree.preOrderTraverse(bTree.getRoot());
		System.out.println("\n");
		
		System.out.println("Post Order Traversal----------");
		bTree.postOrderTraverse(bTree.getRoot());
		System.out.println("\n");
		
		System.out.println("Find Node---------------------");
		Node found = bTree.findNode(25);
		
		//bTree.findNode(25)	ã�� Node�� ������ ����� found �� ����. 
		
		System.out.println(found == null ? "Not exists" : found);		//Node�� found�� ���
		System.out.println("\n");
		
		
		//Deleting
		System.out.println("Delete Node TEst--------------");
		bTree.deleteNode(15);
		bTree.BFS();
		System.out.println();
	}
}
