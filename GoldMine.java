import java.util.ArrayList;
import java.util.Arrays;

class GoldMine {
	 final static int N = 3;
	 final static int  M = 3;
	 
     static ArrayList<Integer> path(int matrix[][] ,int i ,int j) {
		 int[] p = new int[2];
		 ArrayList<Integer> path = new ArrayList<Integer>();
		 int rightup=0;
		 int right=0;
		 int rightdown=0;
		 
		 while(j-1 >=0 ) {
		 if(j-1 >= 0) {
			 right = matrix[i][j-1];
		 }
		 if(i+1<N && j-1>=0) {
			  rightdown = matrix[i+1][j-1];
		 }
		 if(i-1>=0 && j-1>=0) {
			  rightup = matrix[i-1][j-1];
		 }
		 if(right >= rightup) {
			 if(right >= rightdown) {
				 p[0]=i;
				 p[1]=j-1;
			 }else {
				 p[0]=i+1;
				 p[1]=j-1;
			 }
				 
		 }else {
			 p[0]=i-1;
			 p[1]=j-1;
		 }
		 
		 path.add(p[0]);
		 path.add(p[1]);
		 
		 
		 i=p[0];
		 j=p[1];
		 
		 
		 
		 }
			 
		
		 
		 return path;
     } 
	 
	 
	 static int[] location(int matrix[][], int key) {
		 int [] loc = new int[2];
		 
		 
		 
		 for(int i=0; i<matrix.length; i++) {
			 for(int j=0; j<matrix[i].length; j++) {
				 if(matrix[i][j]==key) {
					 loc[0]=i;
					 loc[1]=j;
				 }
			 }
		 }
		 
		 return loc;
	 }
	 
	 static int findMax(int mat[][])
	    {
	 
	        
	        int maxElement = Integer.MIN_VALUE;
	 
	        
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (mat[i][j] > maxElement) {
	                    maxElement = mat[i][j];
	                }
	            }
	        }
	        
	       
	        
	        return maxElement;
	    }
	
	
	 static int[][] goldmining (int maingold[][] , int n ,int m) {
		 int rightup;
		 int right;
		 int rightdown;
		 
		
		 int[][] totalgold = new int[n][m];
		 for(int i=0; i<n; i++) {
			 totalgold[i][0]=maingold[i][0];
		 }
		 for(int j=0; j<m-1; j++) {
			 for(int i=0; i<n; i++) {
				 //check right_up
				 if(i-1 >= 0) {
					 rightup = maingold[i][j+1] + totalgold[i-1][j];
				 }else 
					 rightup = 0;
				 
				 //right
				 right = maingold[i][j+1] + totalgold[i][j];
				 
				 //check right_down
				 if(i+1 < n) {
					 rightdown = maingold[i][j+1] + totalgold[i+1][j];
				 }else
					 rightdown=0;
				 
				 totalgold[i][j+1]= Math.max(rightup, Math.max(right, rightdown));
				 
			 }
		 }
		 
		 
		 
		 return totalgold;
	}

	public static void main(String[] args) {
		
		int n=3;
		int m=3;
		int x;
		int y;
		
		int[][] g = new int[n][m];
		
		
		int[][] maingold = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				maingold[i][j]=(int)(Math.random()*9 + 1);
				
			}
		}
		for(int i=0; i<maingold.length; i++) {
			for(int j=0; j<maingold[i].length; j++) {
				System.out.print(maingold[i][j]+ " ");
				
			}
			System.out.println();
		}
		g = goldmining (maingold , n ,m);
	     /* for(int i=0; i<g.length; i++) {
			for(int j=0; j<g[i].length; j++) {
				System.out.print(g[i][j]+ " ");
				
			}
			System.out.println();
		}*/
		int max = findMax(g);
		System.out.println(max);
		
		
		int[] finalloc = new int[2];
		finalloc = location(g , findMax(g));
		x=finalloc[0];
		y=finalloc[1];
		
		
		for(int h=path(g, x, y).size()-1; h>=0; h--) {
			System.out.print(path(g, x, y).get(h).toString()+ "  ");
		}
		
		System.out.println(Arrays.toString(location(g ,findMax(g))));

	}

}
