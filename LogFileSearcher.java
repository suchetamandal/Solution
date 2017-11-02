import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class LogFileSearcher {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		final String fileName = "op.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

		DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;

		LocalDateTime startTime = LocalDateTime.parse(in.nextLine(), format);
		LocalDateTime endTime = LocalDateTime.parse(in.nextLine(), format);
		int logLines = in.nextInt();

		Collection<String> logFiles = new ArrayList<>();
		while (logLines > 0) {
			logFiles.add(in.nextLine());
			logLines--;
		}
		in.close();

		Collection<String> result = search(logFiles, startTime, endTime);
		for (String logLine : result) {
			//bw.write(logLine);
			//bw.newLine();
			System.out.println(logLine);
		}
		//bw.close();
	}

	public static Collection<String> search(Collection<String> logFiles, LocalDateTime startDate,
			LocalDateTime endDate) {
		Collection<String> res = new ArrayList<String>();
		DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
		for (String log : logFiles) {
			String[] details = log.split("\\t");
			if (details[0].trim().length() > 0) {
				LocalDateTime date = LocalDateTime.parse(details[0], format);
				if (date.compareTo(startDate) >= 0 && date.isBefore(endDate)) {
					res.add(log);
				}
			}
		}
		return res;
	}

}
