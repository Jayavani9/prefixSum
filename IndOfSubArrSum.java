
//https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&company=Amazon&sortBy=submissions

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        //Tc: O(n) Sc: O(1)
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        int sum = 0;
        
        for(int end = 0; end < n; end++)
        {
            sum += arr[end];
            
            while(sum > s && end > start)
            {
                sum -= arr[start];
                start++;
            }
            
            if(sum == s)
            {
                ans.add(start+1);
                ans.add(end+1);
                return ans;
            }
        }
        
        ans.add(-1);
        return ans;
    }
}



