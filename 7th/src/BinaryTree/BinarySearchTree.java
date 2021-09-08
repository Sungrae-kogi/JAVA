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
			return "현재 노드의 키 값은 :" + this.key;
		}
	}
	
	//BinarySearchTree의 현재 root를 반환
	public Node getRoot() {
		return this.root;
	}
	
	public void addNode(int key) {
		//추가하고자 하는 key가 findNode 해서 BST 내에 존재한다면 , return 시킴
		if(findNode(key)!=null)
			return;
		
		//찾지 못했다면, 즉 BST에 add하고자 하는 key가 존재하지 않는다면
		Node newNode = new Node(key);
		
		//트리가 만일 아무것도 없는 빈 상태라면 
		if(root == null) {
			root=newNode;	//추가하는 newNode를 루트노드로 지정
		}else {
			//빈 트리가 아니라면
			Node focusNode = root; // 탐색용 노드
			Node parent; //탐색용 노드의 부모노드
			
			while(true) {
				
				parent = focusNode;
				
				if(key < parent.key) {
					focusNode=focusNode.leftChild;	//찾고자 하는 key값이 더 작으니까 왼쪽을 탐색해야 한다.
					
					if(focusNode == null) {		//찾고자 해서 왼쪽으로 갔는데 그곳이 null즉, 빈 곳이라면 거기가 newNode가 들어갈 자리
						parent.leftChild = newNode;
						return;
					}
					
				}else {			//찾고자 하는 key 값이 더 큰 경우 오른쪽을 탐색해야 한다.
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
		
		//while문이 끝나면 focusNode는 삭제될 노드를 가리키고, parent는 삭제될 노드의 부모노드를, 그리고 삭제될 노드가  부모노드의 left인지 right인지에 대한 정보를 가짐
		while(focusNode.key != key) { // key값을 찾을때까지
			parent = focusNode;
			
			if(key < focusNode.key) {		//왼쪽으로 이동해야 
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
		//replacementNode는 노드를 삭제한 그 빈 자리에 들어올 대체 노드를 의미함.
		Node replacementNode;
		
		//----------위에 while로 인해 focusNode는 탐색이 완료된 상태
		
		//지우려는 노드의 자식 노드가 없는 경우
		if(focusNode.leftChild == null && focusNode.rightChild==null) {
			if(focusNode == root)
				root = null;
			else if(isLeftChild)		//true면 왼쪽에 있었다, false면 오른쪽에 있다
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
	
		//지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
		else if(focusNode.rightChild == null) {
			replacementNode = focusNode.leftChild;
			
			if(focusNode==root)
				root = replacementNode;	//루트였다면 , 위에 코드에서 replacementNode엔 null이 들어가 있을것
			else if(isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		//지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있을 때)
		else if(focusNode.leftChild == null) {
			replacementNode = focusNode.rightChild;
			
			if(focusNode==root)
				root = replacementNode;
			else if(isLeftChild)	//parent를 기준으로 왼쪽이었느냐 오른쪽이었느냐.
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		//지우려는 노드의 양쪽 자식노드가 모두 있는 경우
		//오른쪽 자식 노드의 sub tree에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치
		else {
			Node rightSubTree = focusNode.rightChild;
			replacementNode = getRightMinNode(focusNode.rightChild);
			
			if(focusNode == root)
				root = replacementNode;
			else if(isLeftChild)		//맨 위에 while문에서 key값을 찾은 focusNode의 parent노드의 왼쪽인지 오른쪽인지를 구분하는거임
				parent.leftChild = replacementNode;	//그래서 왼쪽이라면 찾아낸 rightminNode를 parent의 왼쪽에다 붙임
			else
				parent.rightChild = replacementNode;
			
			replacementNode.rightChild = rightSubTree;	//오른쪽트리의 가장작은 값이 올라오게했으니까 그것의 right에 우측트리와 연결
			
			if(replacementNode == rightSubTree)	//지우려는 노드의 오른쪽 sub Tree에 노드가 하나밖에 없는 경우
				//getRightMinNode의 결과 와 rightSubTree의 주소가 같다는 말은 하나밖에 없다는 뜻.
				replacementNode.rightChild = null;	//null로 연결하는 이유는  아무것도 없어서, 위에코드는 있ㅇ늬까 rightSubTree로 연결함
			
			replacementNode.leftChild = focusNode.leftChild;
		}
		
		return true;
	}
	//--------------------------이진트리의 삭제부분 코드는 이해가 필요함 ------------------------------
	
	//오른쪽 노드에서 가장 값이 작은 노드를 찾아 반환한다.
	private Node getRightMinNode(Node rightChildRoot) {
		Node parent = rightChildRoot;
		Node focusNode = rightChildRoot;
		
		while(focusNode.leftChild !=null) {
			parent = focusNode;
			focusNode = focusNode.leftChild;
		}
		//rightChildRoot에서 가장 작은 값을 가진 Node가 탐색됨 focusNode로 들어가 있다.
		parent.leftChild = null;
		//찾은 focusNode의 부모노드 parent.leftChild 를 null로 하여 연결을 끊어버린다.
		
		return focusNode;	//반환되는 focusNode는 Min값을 가진 Node
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
		//트리가 빈 트리라면
		if(root ==null)
			return null;
		Node focusNode = root;	//탐색변수노드 focusNode를 root로 지정 거기서 부터 탐색 시작.
		
		while(focusNode.key != key) {	//찾고자 하는 key 값이 일치 할때 까지 반복 ,, ()안은 키 값이 같지않은 한 이란 뜻
			if(key<focusNode.key) {
				focusNode = focusNode.leftChild;
			}else {
				focusNode = focusNode.rightChild;
			}
			
			//그렇게 탐색을 반복하다가, 못찾는 경우 >> focusNode==null이 되는 경우
			if(focusNode==null)
				return null;
		}
		return focusNode;
	}
	
	public void BFS() {	//출력으로 사용할 임의 Queue인 q 를 선언하고 root를 offer(Queue에 보관)
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node n = q.poll();				//poll() -> Queue에서 내용물을 하나 참조함과 동시에 Queue에서 삭제 
			System.out.print(n.key+" ");	//poll()로 꺼낸 내용물은 Node이며 .key를 통한 값 참조 후 " " 공백 출력
			if(n.leftChild !=null)			//꺼낸 Node의 왼쪽 주소란이 존재 한다면  그 부분을 q에 offer 함 
				q.offer(n.leftChild);		//그것을 q.isEmpty()가 false가 나올때까지 반복
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
		
		//bTree.findNode(25)	찾은 Node를 리턴한 결과가 found 에 들어간다. 
		
		System.out.println(found == null ? "Not exists" : found);		//Node인 found를 출력
		System.out.println("\n");
		
		
		//Deleting
		System.out.println("Delete Node TEst--------------");
		bTree.deleteNode(15);
		bTree.BFS();
		System.out.println();
	}
}
