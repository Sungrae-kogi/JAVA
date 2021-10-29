class BSTNode{
	int key;
	BSTNode left;
	BSTNode right;
	
}

class BinarySearchTree{
	
	private BSTNode root;
	
	public BinarySearchTree() {
		root=null;
	}
	
	public void inorderBST(BSTNode temp) {

		if (temp==null)
			return;
		else {
			inorderBST(temp.left);
			System.out.printf("%d ", temp.key);
			inorderBST(temp.right);
		}
		
	}
	public void printBST() {
		if(root != null)
			inorderBST(root);
		System.out.println();
	}
	
	public void insertBST(BinarySearchTree T, int newKey) {
		if(root==null) {
			BSTNode newNode = getNode(newKey);
			root=newNode;
		}
		
		BSTNode q = null;
		BSTNode p = root;
		while(p !=null) {
			if(newKey==p.key)
				return;
			q=p;
			if(newKey < p.key) {
				p=p.left;
			}else {
				p=p.right;
			}
		}//q�� �θ���, p�� ��ġ
		
		BSTNode newNode = getNode(newKey);
		
		if(newKey < q.key) {
			q.left=newNode;
		}else {
			q.right=newNode;
		}
		
	}
	
	public void delete(int data) {
		root = deleteBST(root,data);
	}
	public BSTNode deleteBST(BSTNode temp, int deleteKey) {
		//Ʈ���� ����°� �ƴҶ�
		if(temp != null) {
			BSTNode p;		
			
			if(temp.key > deleteKey) {	//�������� ����
				temp.left = deleteBST(temp.left, deleteKey);
			}else if(temp.key < deleteKey) {	//���������� ����
				temp.right = deleteBST(temp.right, deleteKey);
			}else if(temp.left == null && temp.right == null) {	//������ ����� ������ 0
				temp=null;
			}else if(temp.right==null) {	//������ ����� ������ 1 ���ʿ� ������
				p=temp;						
				temp = temp.left;			//Ž������ ��������
				p=null;
			}else if(temp.left==null) {		//������ ����� ������ 1 �����ʿ� ������
				p=temp;
				temp=temp.right;			//Ž����� ����������
				p=null;
			}else {
				String flag;	// LEFT �Ǵ� RIGHT �� ����
				
				if(height(temp.left)> height(temp.right)) {	//����Ʈ���� ���̰� �� ũ��
					p=maxNode(temp.left);			//������ max�� ã��
					flag = "LEFT";
				}else if(height(temp.left) < height(temp.right)) {	//������Ʈ�� ���̰� �� ũ��
					p=minNode(temp.right);			//�������� min�� ã��
					flag = "RIGHT";
				}else {		//�� ��Ʈ���� ���̰� ���ٸ�
					if(noNodes(temp.left) >= noNodes(temp.right)) {	//����� ������ �Ǵ�
						p=maxNode(temp.left);
						flag="LEFT";
					}
					else {
						p=minNode(temp.right);
						flag = "RIGHT";
					}
				}
				temp.key = p.key;
				
				if(flag == "LEFT") {
					temp.left = deleteBST(temp.left, p.key);
				}else {
					temp.right = deleteBST(temp.right, p.key);
				}
			}
		}
		return temp;
	}
	
	//n�� ��Ʈ�� �� Ʈ���� ��尹���� ����
	public int noNodes(BSTNode n) {
		int num;
		if(n==null) {
			num=0;
		}else {
			num = noNodes(n.left)+ noNodes(n.right)+1; 
		}
		
		return num;
	}
	
	//n�� ��Ʈ�� �� Ʈ���� ���̸� ����
	public int height(BSTNode n) {
		int hei, depl, depr;
		if(n==null) {
			hei=0;
		}else {
			depl = height(n.left);
			depr = height(n.right);
			if(depl >= depr) {	//�����̴����
				hei = depl+1;	//��Ʈ�� ����1�� ���ؾ��Ѵ�
			}else {
				hei = depr+1;
			}
		}
		return hei;
	}
	
	
	public BSTNode minNode(BSTNode n) {
		if(n==null) {
			return null;
		}
		
		if(n.left==null)
			return n;
		
		return minNode(n.left);
	}
	
	public BSTNode maxNode(BSTNode n) {
		if(n==null) {
			return null;
		}
		
		if(n.right==null)
			return n;
		
		return maxNode(n.right);
	}
	
	public boolean searchParentBST(BinarySearchTree T,int searchKey,BSTNode q,BSTNode p) {
		//q=null; �θ���
		//p=root; �����ҳ��
		while(p !=null) { //searchKey�� ������� Ž��
			if(searchKey==p.key) {
				System.out.println("Ž������ true��ȯ");
				return true;	//Ž������ true��ȯ
			}
			q=p;	//key�� �ƴϸ� Ž������� �θ��带 Ž����尡 �ִ� �ڸ��� ����Ű��
			if(searchKey < p.key) {
				p=p.left;
				System.out.println("p=p.left ��");
				System.out.println(p.key);
				System.out.println(q.key);
			}else {
				p=p.right;
			}
		}
		return false;		//Ž������ false��ȯ
	}
	
	
	private BSTNode getNode(int newKey) {	//���ο� ��� �����ؼ� ���� �ʱ�ȭ�ϰ� ������
		BSTNode nNode = new BSTNode();
		nNode.key = newKey;
		nNode.left = null;
		nNode.right = null;
		return nNode;
	}

}


public class BSTwork {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		//����
		bst.insertBST(bst,25);		bst.printBST();
		bst.insertBST(bst, 500);	bst.printBST();
		bst.insertBST(bst, 33);		bst.printBST();
		bst.insertBST(bst, 49);		bst.printBST();
		bst.insertBST(bst, 17);		bst.printBST();
		bst.insertBST(bst, 403);	bst.printBST();
		bst.insertBST(bst, 29);		bst.printBST();
		bst.insertBST(bst, 105);	bst.printBST();
		bst.insertBST(bst, 39);		bst.printBST();
		bst.insertBST(bst, 66);		bst.printBST();
		bst.insertBST(bst, 305);	bst.printBST();
		bst.insertBST(bst, 44);		bst.printBST();
		bst.insertBST(bst, 19);		bst.printBST();
		bst.insertBST(bst, 441);	bst.printBST();
		bst.insertBST(bst, 390);	bst.printBST();
		bst.insertBST(bst, 12);		bst.printBST();
		bst.insertBST(bst, 81);		bst.printBST();
		bst.insertBST(bst, 50);		bst.printBST();
		bst.insertBST(bst, 100);	bst.printBST();
		bst.insertBST(bst, 999);	bst.printBST();
		
		//����1
		bst.delete(25);		bst.printBST();
		bst.delete(500);	bst.printBST();
		bst.delete(33);		bst.printBST();
		bst.delete(49); 	bst.printBST();
		bst.delete(17); 	bst.printBST();
		bst.delete(403); 	bst.printBST();
		bst.delete(29); 	bst.printBST();
		bst.delete(105); 	bst.printBST();
		bst.delete(39); 	bst.printBST();
		bst.delete(66); 	bst.printBST();
		bst.delete(305); 	bst.printBST();
		bst.delete(44); 	bst.printBST();
		bst.delete(19); 	bst.printBST();
		bst.delete(441); 	bst.printBST();
		bst.delete(390); 	bst.printBST();
		bst.delete(12); 	bst.printBST();
		bst.delete(81); 	bst.printBST();
		bst.delete(50); 	bst.printBST();
		bst.delete(100); 	bst.printBST();
		bst.delete(999); 	bst.printBST();
		
		//�����
		bst.insertBST(bst,25);		bst.printBST();
		bst.insertBST(bst, 500);	bst.printBST();
		bst.insertBST(bst, 33);		bst.printBST();
		bst.insertBST(bst, 49);		bst.printBST();
		bst.insertBST(bst, 17);		bst.printBST();
		bst.insertBST(bst, 403);	bst.printBST();
		bst.insertBST(bst, 29);		bst.printBST();
		bst.insertBST(bst, 105);	bst.printBST();
		bst.insertBST(bst, 39);		bst.printBST();
		bst.insertBST(bst, 66);		bst.printBST();
		bst.insertBST(bst, 305);	bst.printBST();
		bst.insertBST(bst, 44);		bst.printBST();
		bst.insertBST(bst, 19);		bst.printBST();
		bst.insertBST(bst, 441);	bst.printBST();
		bst.insertBST(bst, 390);	bst.printBST();
		bst.insertBST(bst, 12);		bst.printBST();
		bst.insertBST(bst, 81);		bst.printBST();
		bst.insertBST(bst, 50);		bst.printBST();
		bst.insertBST(bst, 100);	bst.printBST();
		bst.insertBST(bst, 999);	bst.printBST();
		
		//����2
		bst.delete(999); 	bst.printBST();
		bst.delete(100); 	bst.printBST();
		bst.delete(50); 	bst.printBST();
		bst.delete(81); 	bst.printBST();
		bst.delete(12); 	bst.printBST();
		bst.delete(390); 	bst.printBST();
		bst.delete(441); 	bst.printBST();
		bst.delete(19); 	bst.printBST();
		bst.delete(44); 	bst.printBST();
		bst.delete(305); 	bst.printBST();
		bst.delete(66); 	bst.printBST();
		bst.delete(39); 	bst.printBST();
		bst.delete(105); 	bst.printBST();
		bst.delete(29); 	bst.printBST();
		bst.delete(403); 	bst.printBST();
		bst.delete(17); 	bst.printBST();
		bst.delete(49); 	bst.printBST();
		bst.delete(33); 	bst.printBST();
		bst.delete(500); 	bst.printBST();
		bst.delete(25); 	bst.printBST();
	
	}
}
