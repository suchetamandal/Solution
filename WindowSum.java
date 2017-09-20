/*Give an array of [1, 2, 3, 4, 5] and 3 outputs [6, 9, 12] sliding window */

class WindowSum{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
			return new int[0];
		}
		int l = nums.length;
		int[] r = new int[l - k + 1];
		int a = 0;
		Deque<Integer> window = new ArrayDeque<>();
		for (int i = 0; i < l; i++) {
			while (!window.isEmpty() && window.peek() < (i - k + 1)) {
				window.poll();
			}
			while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
				window.pollLast();
			}
			window.offer(i);
			if (i >= k - 1) {
				r[a++] = nums[window.peek()];
			}
		}
		return r;
    }
}
