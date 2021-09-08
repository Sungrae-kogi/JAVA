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
	
	//���� TreeNode�� item�̶�� ���� ���� newNode�� �߰��Ѵ�, 
	boolean Insert(T item) {
		//first search the key
		TreeNode<T> newNode = new TreeNode<T>(item);
		if(root==null) {
			root = newNode;
			return true;
		}
		
		TreeNode<T> ptr, parent;
		ptr = root;	//Ž�� ���
		parent = null;	//Ž����� ptr�� �θ���
		while(true) {
			parent = ptr;
			if(item.GetKey() < ptr.data.GetKey()) {		//�����ִ°��ǰ����� newNode�ǰ��� ������ �������� ������
				ptr = ptr.leftChild;		//�������� �Դ�
				if(ptr==null) {				//null�̶���, �װ��� ���ڸ���¶�, ���� �ִ�
					parent.leftChild = newNode;
					return true;
				}
			}else if(item.GetKey() > ptr.data.GetKey()) {//���� �ִ°����� newNode���� �� ũ�� ���������� ����
				ptr = ptr.rightChild;
				if(ptr==null) {
					parent.rightChild = newNode;
					return true;
				}
			}else {					//key�� ���ٸ� �̹� �ߺ����̹Ƿ� insert �ʿ䰡��� false ����
				return false;
			}
		}
	}
	
	T Get(T item) {
		TreeNode<T> ptr;
		ptr = root;
		
		//root���� �����ؼ� �ٴڱ��� �޿� Ž��, �ٴ��̶� ptr== null�� �Ǵ�����
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
		boolean isLeftChild = false;	//current�� �������� ���� �ڽĳ���ΰ�?
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
		
		//case 1 : �ڽĳ�尡 ����
		if(current.leftChild == null && current.rightChild==null) {
			if(current==root) {
				root=null;
			}
			if(isLeftChild == true) 
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		
		//case 2 : �ϳ��� �ڽĳ�带 ���� ���
		else if(current.rightChild == null) {	//leftChild�� ���� ���
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
		
		//case 3 : �� ���� �ڽ��� ���� ���
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
			current = current.rightChild;	//���۶� ��������� �������κ������ϱ� ������ rightChild�� �̵��ؼ� ã�´�
		}
		if(leftBig != deleteNode.leftChild) {
			leftBigParent.rightChild = leftBig.leftChild;
			leftBig.leftChild = deleteNode.leftChild;	//������������ �÷�����, leftBig�� left�� ���������� left�� ����
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
