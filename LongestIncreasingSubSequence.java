import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
     int[] nums ={10, 9, 2, 5, 3, 7, 101, 18};
     System.out.println(longestLIS(nums));

	}
    public static int longestLIS(int[] nums){
    	int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
