
public class MusicList {
	public static void main(String[] args) {
		System.out.println(numOfPlaylist(5,2,8));
	}

	static int numOfPlaylist(int N, int K, int L) {
		if (K == 0 && N < L) {
			return 1;
		} else if (N < K || (N == K && L > N)) {
			return 0;
		} else if (N == K && N > L) {
			return factorial(N);
		} else if (N == L && K < L) {
			return factorial(L);
		} else if (N < L && K < L) {

			if (N == K + 1 && L > N) {
				return factorial(N);
			} else if (N == K + 1) {
				return N;
			} else if (L - N == 1) {
				return factorial(N) * (N);
			} else {
				 //return factorial(N) * recur(L - N, N); // N! * (N-K) ^ (L-N)
				return factorial(N) * getPower(N - K, L - N);
			}
		}

		return 0;

	}

	public static int getPower(int n, int k) {
		int sum = n;
		for (int i = 1; i <= k; i++) {
			sum = sum * n;
		}
		return sum;
	}

	static int recur(int input, int totalSongs) {

		if (input == 1) {
			return (totalSongs * 1);
		} else {
			return (recur(input - 1, totalSongs) * 2) + 1;
		}
	}

	static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}
}
