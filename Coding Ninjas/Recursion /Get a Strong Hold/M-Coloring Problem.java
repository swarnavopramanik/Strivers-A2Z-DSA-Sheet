https://www.codingninjas.com/studio/problems/m-coloring-problem_981273?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

/*
        Time Complexity - O(M ^ V)
        Space Complexity - O(V)

        where V is the number of vertices in the graph
        and M is the maximum number of colors allowed
*/
public class Solution {
    // Function to check if there are any adjacent nodes with the same color.
    private static boolean isCorrect(int[][] mat, int cur, int[] color, int col) {
        // Check if there are any adjacent nodes with the same color.
        for (int i = 0; i < mat.length; i++) {
            if (mat[cur][i] == 1 && color[i] == col) {
                return false;
            }
        }
        return true;
    }

    // Function to color the graph recursively.
    private static boolean graphCol(int[][] mat, int m, int cur, int[] color) {
        if (cur == mat.length) {
            return true;
        }

        // Try to color from 1 to 'm'.
        for (int j = 1; j <= m; j++) {
            if (isCorrect(mat, cur, color, j)) {
                // Color the current vertex with 'j' and try to color the rest of the graph.
                color[cur] = j;
                if (graphCol(mat, m, cur + 1, color)) {
                    return true;
                }

                // Reset the color of the vertex.
                color[cur] = 0;
            }
        }

        return false;
    }

    // Main function to color the graph.
    public static String graphColoring(int[][] mat, int m) {
        int v = mat.length;

        // An array to maintain the color of each vertex.
        int[] color = new int[v];

        // If the graph can be colored using at most 'm' colors, return "YES", else return "NO".
        if (graphCol(mat, m, 0, color)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
