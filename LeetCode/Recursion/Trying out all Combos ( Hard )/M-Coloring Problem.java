https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends

class solve {
    public boolean isSafe(boolean graph[],int fill,int[] color)
    {
        //get connected nodes of current nodes
        for(int i=0;i<graph.length;i++)
        {
            //if consist true means it's adjacent node of current node check it color if it same as 
            //we want to fill in current node return false
            if(graph[i]==true && color[i]==fill)
            return false;
        }
        
        return true;
    }
    public boolean fillColorNodes(int curr,boolean graph[][],int m,int n,int[] color)
    {
        //base condition when you reached n node
        if(curr==n)
        return true;
        
        //try to fill with color with all possibilities
        for(int i=1;i<=m;i++)
        {
            if(isSafe(graph[curr],i,color))
            {
                //fill ith color in curr node
                color[curr] = i;
                
                //move to fill next node if can fill no need to revert fill color back
                if(fillColorNodes(curr+1,graph,m,n,color))
                return true;
                
                //if return back remove prev color filled
                color[curr] = 0;
            }
        }
        
        //if not possible to fill current node with any color just return false
        return false;
    }
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        //given graph contain true or false if between nodes edge exist contain true else false
        
       //create a color array for n nodes
       int color[] = new int[n];
       Arrays.fill(color,0);
       
       //check possible to color n nodes with at most m color
       if(fillColorNodes(0,graph,m,n,color))
       return true;
       
       return false;
    }
}
