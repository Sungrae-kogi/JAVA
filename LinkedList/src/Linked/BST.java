package Linked;

public class BST <T extends KeyValue>{
	class TreeNode <U extends KeyValue>{
		U data;
		TreeNode<U> leftChild;
		TreeNode<U> rightChild;
		
		//constructor
		TreeNode(){
			leftChild = rightChild = null;
		}
		
		TreeNode(U d){
			data = d;
			leftChild = rightChild = null;
		}
	};
	
	TreeNode<T> root;
	BST(){
		root = null;
	}
	
	void Show() {
		System.out.print("Pre Order : ");
		PreOrder(root);
		System.out.println();
		System.out.print("In Order : ");
		InOrder(root);
		System.out.println();
		System.out.print("Post Order : ");
		PostOrder(root);
		System.out.println();
	}
	
	//내부 TreeNode에 item이라는 값을 갖는 newNode를 추가한다, 
	boolean Insert(T item) {
		//first search the key
		TreeNode<T> newNode = new TreeNode<T>(item);
		if(root==null) {
			root = newNode;
			return true;
		}
		
		TreeNode<T> ptr, parent;
		ptr = root;	//탐색 노드
		parent = null;	//탐색노드 ptr의 부모노드
		while(true) {
			parent = ptr;
			if(item.GetKey() < ptr.data.GetKey()) {		//현재있는곳의값보다 newNode의값이 작으면 왼쪽으로 보낸다
				ptr = ptr.leftChild;		//왼쪽으로 왔다
				if(ptr==null) {				//null이란건, 그곳이 빈자리라는뜻, 들어갈수 있다
					parent.leftChild = newNode;
					return true;
				}
			}else if(item.GetKey() > ptr.data.GetKey()) {//현재 있는곳보다 newNode값이 더 크면 오른쪽으로 간다
				ptr = ptr.rightChild;
				if(ptr==null) {
					parent.rightChild = newNode;
					return true;
				}
			}else {					//key가 같다면 이미 중복값이므로 insert 필요가없어서 false 리턴
				return false;
			}
		}
	}
	
	T Get(T item) {
		TreeNode<T> ptr;
		ptr = root;
		
		//root부터 시작해서 바닥까지 쭈욱 탐색, 바닥이란 ptr== null이 되는지점
		while(ptr != null) {
			if(ptr.data.GetKey() == item.GetKey())
				return ptr.data;
			else if(ptr.data.GetKey() > item.GetKey())
				ptr = ptr.leftChild;
			else
				ptr = ptr.rightChild;
		}
		return null;
	}
	
	boolean Delete(T item) {
		if(root ==null) {
			return false;
		}
		
		TreeNode<T> parent = root;
		TreeNode<T> current = root;
		boolean isLeftChild = false;	//current가 누군가의 왼쪽 자식노드인가?
		while(current.data.GetKey() != item.GetKey()) {
			parent = current;
			if(current.data.GetKey() > item.GetKey()) {
				isLeftChild = true;
				current = current.leftChild;
			}else {
				isLeftChild = false;
				current = current.rightChild;
			}
			
			if(current==null)
				return false;
		}
		
		//case 1 : 자식노드가 없다
		if(current.leftChild == null && current.rightChild==null) {
			if(current==root) {
				root=null;
			}
			if(isLeftChild == true) 
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		
		//case 2 : 하나의 자식노드를 갖는 경우
		else if(current.rightChild == null) {	//leftChild를 갖는 경우
			if(current == root) {
				root = current.leftChild;
			}else if(isLeftChild) {
				parent.leftChild = current.leftChild;
			}else {
				parent.rightChild = current.leftChild;
			}
		}else if(current.leftChild ==null) {
			if(current == root) {
				root = current.rightChild;
			}else if(isLeftChild) {
				parent.leftChild = current.rightChild;
			}else {
				parent.rightChild = current.rightChild;
			}
		}
		
		//case 3 : 두 개의 자식을 갖는 경우
		else if(current.leftChild != null && current.rightChild != null) {
			TreeNode<T> leftBig = getleftBig(current);
			if(current == root) {
				root = leftBig;
			}else if(isLeftChild) {
				parent.leftChild = leftBig;
			}else {
				parent.rightChild = leftBig;
			}
			leftBig.rightChild = current.rightChild;
		}
		
		return true;
	}
	
	TreeNode<T> getleftBig(TreeNode<T> deleteNode){
		TreeNode<T> leftBig = null;
		TreeNode<T> leftBigParent = null;
		TreeNode<T> current = deleteNode.leftChild;
		while(current != null) {
			leftBigParent = leftBig;
			leftBig = current;
			current = current.rightChild;	//시작때 삭제노드의 왼쪽으로보냈으니까 앞으로 rightChild로 이동해서 찾는다
		}
		if(leftBig != deleteNode.leftChild) {
			leftBigParent.rightChild = leftBig.leftChild;
			leftBig.leftChild = deleteNode.leftChild;	//시작지점으로 올렸을때, leftBig의 left와 시작지점의 left를 연결
		}
		
		return leftBig;
	}
	
	
	void PreOrder(TreeNode<T> t) {
		if(t==null)
			return ;
		System.out.print(t.data.GetValue()+" ");
		PreOrder(t.leftChild);
		PreOrder(t.rightChild);
	}
	
	void InOrder(TreeNode<T> t) {
		if(t==null) {
			return ;
		}
		InOrder(t.leftChild);
		System.out.print(t.data.GetValue()+" ");
		InOrder(t.rightChild);
	}
	
	void PostOrder(TreeNode<T> t) {
		if(t==null)
			return ;
		
		PostOrder(t.leftChild);
		PostOrder(t.rightChild);
		System.out.print(t.data.GetValue()+" ");
	}
}
