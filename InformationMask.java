import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InformationMask {
	private static String emailMask(String email) {
		StringBuilder sb = new StringBuilder();
		sb.append("E:");
		sb.append(email.charAt(0));
		sb.append("*****");
		int start = email.lastIndexOf('@') - 1;
		sb.append(email.substring(start));
		return sb.toString();
	}

	private static String phoneMask(String phone) {
		StringBuilder sb = new StringBuilder();
		sb.append("P:");
		char[] arr = phone.toCharArray();
		int num = 0;
		for (char c : arr) {
			if (Character.isDigit(c)) {
				num++;
			}
		}
		int countryCode = num - 10;
		boolean extra = false;
		if (countryCode > 0) {
			sb.append('+');
			extra = true;
		}
		int cur = 0;
		while (cur < arr.length && countryCode > 0) {
			if (Character.isDigit(arr[cur])) {
				sb.append('*');
				// countryCode;
			}
			cur++;
		}
		if (extra) {
			sb.append('-');
		}
		int cnt = 0;
		while (cur < arr.length && cnt < 3) {
			if (Character.isDigit(arr[cur])) {
				sb.append('*');
				cnt++;
			}
			cur++;
		}
		sb.append('-');
		cnt = 0;
		while (cur < arr.length && cnt < 3) {
			if (Character.isDigit(arr[cur])) {
				sb.append('*');
				cnt++;
			}
			cur++;
		}
		sb.append('-');
		cnt = 0;
		while (cur < arr.length && cnt < 4) {
			if (Character.isDigit(arr[cur])) {
				sb.append(arr[cur]);
				cnt++;
			}
			cur++;
		}
		return sb.toString();
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			String[] inputs = input.trim().split(":");
			if (inputs[0].trim().equals("E")) {
				System.out.println(emailMask(inputs[1].trim()));
			} else if (inputs[0].trim().equals("P")) {
				System.out.println(phoneMask(inputs[1].trim()));
				br.close();

			}
		}
	}
}
