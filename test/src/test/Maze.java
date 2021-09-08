package test;
import java.util.*;


public class Maze {
	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking
	public int [][] stack;
	
	//�̵����� S, SW, W ,NW, N, NE, E, SE����  = ���ʺ��� �ð����
	public static int [][] move = {{1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}};
	public static int top=-1;
	
	public int i, j;				//�̷ο��� ���� ��ġ
	public int next_i, next_j;		//�̷ο��� �̵��� ��ġ
	public int dir;					//�̷ο��� �̵��� ����

	
	
	public Maze(int m, int p) {
		maze = new int[m + 2][p + 2];
		mark = new int[m + 2][p + 2];
		for(int i = 0; i < m + 2; i++)
			for(int j = 0; j < p + 2; j++) {
				maze[i][j] = 1;
				mark[i][j] = 0;
			}
		
		stack = new int[(m+2)*(p+2)][7];
	}

	// create the maze structure
	public void SetWall(int i, int j, int val) {
		maze[i][j] = val;
	}


	public void Path(int m, int p) {
		i=1; j=1; dir=0;
		mark[i][j]=1;
		
		push(i,j, dir);
		
		while(!isEmpty()) {
			
			pop();
			while(dir<=7) {
				next_i = i + move[dir][0];		//�������� �̵��� ���(��)
				next_j = j + move[dir][1];		//�������� �̵��� ���(��)
				
				if(next_i == m && next_j == p)		//�ⱸ�� ã���� ���
				{
					mark[next_i][next_j] = 1;		//�̵��� ��θ� ����


					push(i,j,dir);					//���ÿ� ���� ��ġ�� �̵��� ���� ����
					
					
					System.out.println();
					System.out.println();

					//���ÿ��� �̷��� �ִܰŸ� ��θ� ����(��ǥ)
					for(int a=0; a<=top; a++)
					{ 
						System.out.print("("+stack[a][0] + ","+stack[a][1]+")"); 
						System.out.println();
						
					} 
					
					System.out.println("(" + m + "," + p + ")"); 
					
					//���� �ϳ��� �����⶧���� top�� -1�� �ʱ�ȭ������
					top=-1;
					
					return;
				}
				
				if(maze[next_i][next_j]==0 && mark[next_i][next_j] == 0)	//�������� �̵��� ��ο� ���� �ְ� ���� �ʾ��� ���
				{
					mark[next_i][next_j] = 1;		//�̵��� ��θ� ����

					push(i,j,dir);					//���ÿ� ������ġ�� �̵��� ���� ����
					dir=0;							//�̵��� ���� �ʱ�ȭ(while���� ��� ����)
					i=next_i;						//����̵�(��)
					j=next_j;						//����̵�(��)
				}
				
				else
					dir++;	//���� 2���� ��쿡 �ش����� ������ �ٸ� ������ ���� ã��.
			}
		}
		System.out.println("No path in the maze.");
	}
	
	
	
	//���ÿ� �̵���� ����
	void push(int i, int j, int dir)
	{
		++top;					//������ top����
		stack[top][0] = i;		//���ÿ� �� ��ǥ ����
		stack[top][1] = j;		//���ÿ� �� ��ǥ ����
		stack[top][2] = dir;	//���ÿ� ���� ����
	}//end push
	
	//���ÿ��� �̵���� �ҷ�����
	void pop()
	{
		i = stack[top][0];		//���ÿ��� �� ��ǥ ����
		j = stack[top][1];		//���ÿ��� �� ��ǥ ����
		dir = stack[top][2];	//���ÿ��� ���� ����
		--top;					//������ top����
	}//end pop
	
	//������ ������� �˻�
	boolean isEmpty()
	{
		if(top>=0)
			return false;
		else
			return true;
	}//end isEmpty
	
}
