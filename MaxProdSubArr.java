//https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    //Tc: O(n) Sc: O(1)
    public int maxProduct(int[] nums) {
         int n = nums.length;
        if (n == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
             
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            result = Math.max(result, maxProduct);
        }

        return result;
        
    }
}
