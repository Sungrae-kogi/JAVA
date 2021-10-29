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
		}//q가 부모노드, p가 위치
		
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
		//트리가 빈상태가 아닐때
		if(temp != null) {
			BSTNode p;		
			
			if(temp.key > deleteKey) {	//왼쪽으로 보냄
				temp.left = deleteBST(temp.left, deleteKey);
			}else if(temp.key < deleteKey) {	//오른쪽으로 보냄
				temp.right = deleteBST(temp.right, deleteKey);
			}else if(temp.left == null && temp.right == null) {	//삭제할 노드의 차수가 0
				temp=null;
			}else if(temp.right==null) {	//삭제할 노드의 차수가 1 왼쪽에 있을때
				p=temp;						
				temp = temp.left;			//탐색노드는 왼쪽으로
				p=null;
			}else if(temp.left==null) {		//삭제할 노드의 차수가 1 오른쪽에 있을때
				p=temp;
				temp=temp.right;			//탐색노드 오른쪽으로
				p=null;
			}else {
				String flag;	// LEFT 또는 RIGHT 들어갈 변수
				
				if(height(temp.left)> height(temp.right)) {	//왼쪽트리의 높이가 더 크면
					p=maxNode(temp.left);			//왼쪽의 max를 찾음
					flag = "LEFT";
				}else if(height(temp.left) < height(temp.right)) {	//오른쪽트리 높이가 더 크면
					p=minNode(temp.right);			//오른쪽의 min을 찾음
					flag = "RIGHT";
				}else {		//좌 우트리의 높이가 같다면
					if(noNodes(temp.left) >= noNodes(temp.right)) {	//노드의 갯수를 판단
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
	
	//n을 루트로 한 트리의 노드갯수를 리턴
	public int noNodes(BSTNode n) {
		int num;
		if(n==null) {
			num=0;
		}else {
			num = noNodes(n.left)+ noNodes(n.right)+1; 
		}
		
		return num;
	}
	
	//n을 루트로 한 트리의 높이를 리턴
	public int height(BSTNode n) {
		int hei, depl, depr;
		if(n==null) {
			hei=0;
		}else {
			depl = height(n.left);
			depr = height(n.right);
			if(depl >= depr) {	//왼쪽이더길면
				hei = depl+1;	//루트의 높이1을 더해야한다
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
		//q=null; 부모노드
		//p=root; 삭제할노드
		while(p !=null) { //searchKey값 가진노드 탐색
			if(searchKey==p.key) {
				System.out.println("탐색성공 true반환");
				return true;	//탐색성공 true반환
			}
			q=p;	//key가 아니면 탐색노드의 부모노드를 탐색노드가 있던 자리를 가리키게
			if(searchKey < p.key) {
				p=p.left;
				System.out.println("p=p.left 함");
				System.out.println(p.key);
				System.out.println(q.key);
			}else {
				p=p.right;
			}
		}
		return false;		//탐색실패 false반환
	}
	
	
	private BSTNode getNode(int newKey) {	//새로운 노드 생성해서 값들 초기화하고 돌려줌
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
		//삽입
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
		
		//삭제1
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
		
		//재삽입
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
		
		//삭제2
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
