//https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1?page=1&company=Amazon&sortBy=submissions


//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();

            // calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    // arr: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        //Tc: O(n)  Sc: O(1) 
        // Your code here
        
        long leftSum = 0;
        long rightSum = 0;
        
        
        for(long num:arr)
        {
            rightSum += num;
        }
        
        
        for(int i = 0; i < n; i++)
        {
            rightSum -= arr[i];
            
            if(leftSum == rightSum) return i+1;
            
            leftSum += arr[i];
        }
        
        return -1;
    }
}
