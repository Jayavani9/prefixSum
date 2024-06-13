3070. Count Submatrices with Top-Left Element and Sum Less Than k


https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/





class Solution {
    public int countSubmatrices(int[][] grid, int k) {
         int m = grid.length;
        int n = grid[0].length;
        int[][] ps = new int[m][n];

        int cnt = 0;

        // Fill the first row ps
        ps[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            ps[0][j] = grid[0][j] + ps[0][j - 1];
        }

        // Fill the first column ps
        for (int i = 1; i < m; i++) {
            ps[i][0] = grid[i][0] + ps[i - 1][0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ps[i][j] = grid[i][j] + ps[i][j - 1] + ps[i - 1][j] - ps[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ps[i][j] <= k) {
                    cnt++;
                }
            }
        }

        return cnt;
        
    }
}





class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;


        int[][] prefixSum = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSum[i][j] = grid[i][j];
                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = prefixSum[i][j];
                if (sum <= k) {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}
