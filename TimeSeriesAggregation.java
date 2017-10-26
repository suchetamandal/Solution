import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TimeSeriesDataAggregation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<String> data = new ArrayList<String>();

		while (input.hasNext()) {
			data.add(input.nextLine());
		}

		List<String> output = new ArrayList<String>();
		output = getAggregate(data);
		for (String op : output) {
			System.out.println(op);
		}
		input.close();
	}

	static List<String> getAggregate(List<String> data) {
		String[] dates = data.get(0).split(",");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");

		try {
			Date startDate = df.parse(dates[0]);
			Date endDate = df.parse(dates[1]);
			TreeMap<Date, TreeMap<String, Integer>> map = new TreeMap<Date, TreeMap<String, Integer>>(Collections.reverseOrder());

			for (int i = 2; i < data.size(); i++) {
				String[] line = data.get(i).split(",");
				Date d = df.parse(line[0]);
				String act = line[1].trim();
				String number = line[2].trim();
				if (d.compareTo(startDate)>=0 && d.before(endDate)) {
					if (map.containsKey(d)) {
						TreeMap<String, Integer> details = map.get(d);
						details.put(act, details.getOrDefault(act, 0) + Integer.parseInt(number));
						map.put(d, details);
					} else {
						TreeMap<String, Integer> details = new TreeMap<String, Integer>();
						details.put(act, Integer.parseInt(number));
						map.put(d, details);
					}
				}
			}
			ArrayList<String> output = new ArrayList<String>();
			for (Map.Entry<Date, TreeMap<String, Integer>> entry : map.entrySet()) {
				StringBuilder sb = new StringBuilder();
				sb.append(df.format(entry.getKey())).append(", ");
				for (Map.Entry<String, Integer> e : entry.getValue().entrySet()) {
					sb.append(e.getKey()).append(", ").append(e.getValue()).append(", ");
				}
				sb.setLength(sb.length()-2);
				output.add(sb.toString());
			}
			return output;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
  
}
