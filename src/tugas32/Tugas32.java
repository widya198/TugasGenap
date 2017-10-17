
package tugas32;

/**
 *
 * @author Widya
 */
public class Tugas32
{
  public int[][] solution;

	
	public Tugas32(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public void solveMaze(int[][] maze, int N) {
		if (findPath(maze, 0, 0, N, "down")) {
			print(solution, N);
		}else{
			System.out.println("NO PATH FOUND");
		}
		
	}

	public boolean findPath(int[][] maze, int x, int y, int N, String direction) {
		
		if(x==N-1 && y==N-1){
			solution[x][y] = 1;
			return true;
		}
		if (isSafeToGo(maze, x, y, N)) {
			
			solution[x][y] = 1;			
			
			if(direction!="up" && findPath(maze, x+1, y, N, "down")){ //bawah
				return true;
			}
			//selain kebawah
			if(direction!="left" && findPath(maze, x, y+1, N,"right")){ //kanan
				return true;
			}
			if(direction!="down" && findPath(maze, x-1, y, N, "up")){ //atas
				return true;
			}
			if(direction!="right" &&  findPath(maze, x, y-1, N, "left")){ //kiri
				return true;
			}
                        if(direction!="North West" &&  findPath(maze, x-1, y+1, N, "North West")){ //kiri
				return true;
			}
                        if(direction!="North East" &&  findPath(maze, x+1, y+1, N, "North East  ")){ //kiri
				return true;
			}
                        if(direction!="South West" &&  findPath(maze, x-1, y-1, N, "South West")){ //kiri
				return true;
			}
                        if(direction!="South East" &&  findPath(maze, x+1, y-1, N, "South East")){ //kiri
			}
                         
			//jika tdk ada piliham work out BACKTRACK undo the move
			solution[x][y] = 0;
			return false;
		}
		return false;
	}

	
	public boolean isSafeToGo(int[][] maze, int x, int y, int N) {
		
		if (x >= 0 && y >= 0 && x < N  && y < N && maze[x][y] != 0) {
			return true;
		}
		return false;
	}
	public void print(int [][] solution, int N){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int N = 10;
		int[][] maze = { 
                    { 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
                    { 1, 1, 1, 1, 1, 0, 1, 0, 1, 1 }, 
                    { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 },
		    { 1, 0, 1, 0, 1, 0, 1, 0, 0, 1 },
                    { 1, 0, 1, 0, 1, 0, 1, 0, 1, 1 },
                    { 1, 0, 0, 0, 1, 0, 1, 0, 1, 0 },
                    { 1, 0, 1, 1, 1, 0, 1, 0, 1, 0 },
                    { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1 },
                    { 0, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                    { 1, 1, 1, 1, 0, 0, 0, 0, 1, 1 }
                };
		Tugas32 r = new Tugas32(N);
		r.solveMaze(maze, N);
	}

}
