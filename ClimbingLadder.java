import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClimbingLadder {
	
	@Test
	public void testMethod() {
		ClimbingLadder tester = new ClimbingLadder();

		assertEquals(4,tester.getCount(5));
	}

	private Object getCount(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n;i++){
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		return dp[n];
	}

}
