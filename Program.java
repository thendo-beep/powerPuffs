import java.util.*;


public class Program {

	public static void main(String[] args) {
		
		Scanner c = new Scanner(System.in);
		int[][] grid= new int[9][9];
	
		 for(int i= 0; i<9; i++) {
			 for(int j=0; j<9; j++) {
				grid[i][j]= c.nextInt(); 	 
			 }
		 }
		 c.close();
		 
				
			 
		System.out.println(isValid(grid)); 
	
	}
	public static boolean rowIsValid(int [][] grid) {
		HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid.length;j++) {
				if(grid[i][j]== 0) {
					continue;
				}
				else if (row.get(i) !=null && row.get(i).contains(grid[i][j])) {
					return false;
				}
				else {
					if (row.get(i) == null){
	                    row.put (i, new HashSet<Integer>());
					
				}
					 row.get(i).add(grid[i][j]);
				}
			}
		}
		return true;
	}
	public static boolean colIsValid(int [][] grid) {
		HashMap<Integer, HashSet<Integer>> col = new HashMap<>();
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid.length;j++) {
				if(grid[i][j]== 0) {
					return true;
				}
				else if (col.get(j) !=null && col.get(j).contains(grid[i][j])) {
					return false;
				}
				else {
					if (col.get(j) == null){
	                    col.put (j, new HashSet<Integer>());
					
				}
					 col.get(j).add(grid[i][j]);
				}
			}
		}
		return true;
	}
	public static boolean subGridIsValid(int [][] grid) {
		HashMap<Integer, HashSet<Integer>> subGrid = new HashMap<>();
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid.length;j++) {
				if(grid[i][j]== 0) {
					continue;
				}
				else if (subGrid.get((i/3)*3 + j/3) != null && subGrid.get((i/3)*3 + j/3).contains(grid[i][j])) {
					return false;
				}
				else {
					if (subGrid.get((i/3)*3 + j/3) == null){
	                    subGrid.put ((i/3)*3 + j/3, new HashSet<Integer>());
	                }
					
				}
				subGrid.get((i/3)*3 + j/3).add(grid[i][j]);
				}
			
		}
		return true;
	}
	public static boolean isValid(int[][] grid) {
		
		if( rowIsValid(grid) ==true && colIsValid(grid) ==true && subGridIsValid(grid) == true){
			return true;
		}
		else {
			return false;
		}
	}
	public static void PrintSoduku(int[][] grid){
	
			 for(int i= 0; i<9; i++) {
			 		for(int j=0; j<9; j++) {
				System.out.print(grid[i][j] + " "); 	 
			 }
			 		System.out.println();
		 }
	}
	
	
	
	
}
