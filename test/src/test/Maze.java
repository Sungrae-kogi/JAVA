package test;
import java.util.*;


public class Maze {
	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking
	public int [][] stack;
	
	//이동지점 S, SW, W ,NW, N, NE, E, SE순서  = 남쪽부터 시계방향
	public static int [][] move = {{1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}};
	public static int top=-1;
	
	public int i, j;				//미로에서 현재 위치
	public int next_i, next_j;		//미로에서 이동할 위치
	public int dir;					//미로에서 이동할 방향

	
	
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
				next_i = i + move[dir][0];		//다음으로 이동할 경로(행)
				next_j = j + move[dir][1];		//다음으로 이동할 경로(열)
				
				if(next_i == m && next_j == p)		//출구를 찾았을 경우
				{
					mark[next_i][next_j] = 1;		//이동할 경로를 저장


					push(i,j,dir);					//스택에 이전 위치와 이동한 방향 저장
					
					
					System.out.println();
					System.out.println();

					//스택에서 미로의 최단거리 경로를 추출(좌표)
					for(int a=0; a<=top; a++)
					{ 
						System.out.print("("+stack[a][0] + ","+stack[a][1]+")"); 
						System.out.println();
						
					} 
					
					System.out.println("(" + m + "," + p + ")"); 
					
					//루프 하나가 끝났기때문에 top을 -1로 초기화시켜줌
					top=-1;
					
					return;
				}
				
				if(maze[next_i][next_j]==0 && mark[next_i][next_j] == 0)	//다음으로 이동할 경로에 길이 있고 가지 않았을 경우
				{
					mark[next_i][next_j] = 1;		//이동할 경로를 저장

					push(i,j,dir);					//스택에 이전위치와 이동한 방향 저장
					dir=0;							//이동할 방향 초기화(while문을 계속 실행)
					i=next_i;						//경로이동(행)
					j=next_j;						//경로이동(열)
				}
				
				else
					dir++;	//위의 2가지 경우에 해당하지 않으면 다른 방향의 길을 찾음.
			}
		}
		System.out.println("No path in the maze.");
	}
	
	
	
	//스택에 이동경로 저장
	void push(int i, int j, int dir)
	{
		++top;					//스택의 top증가
		stack[top][0] = i;		//스택에 행 좌표 저장
		stack[top][1] = j;		//스택에 열 좌표 저장
		stack[top][2] = dir;	//스택에 방향 저장
	}//end push
	
	//스택에서 이동경로 불러오기
	void pop()
	{
		i = stack[top][0];		//스택에서 행 좌표 추출
		j = stack[top][1];		//스택에서 열 좌표 추출
		dir = stack[top][2];	//스택에서 방향 추출
		--top;					//스택의 top감소
	}//end pop
	
	//스택이 비었는지 검사
	boolean isEmpty()
	{
		if(top>=0)
			return false;
		else
			return true;
	}//end isEmpty
	
}
