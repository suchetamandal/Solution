import java.util.TreeSet;

class NextTimePermutation {
	public String nextTime(String time) {
		StringBuffer res = new StringBuffer();
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < 5; i++) {
			if (i == 2)
				continue;
			set.add(time.charAt(i) - 48);
		}
		int point = 0;
		if (set.higher(time.charAt(4) - 48) == null)
			point = 1;
		if (point == 1)
			res.append(set.first());
		else
			res.append(set.higher(time.charAt(4) - 48));
		if (point == 0)
			res.append(time.charAt(3));
		else {
			if (set.higher(time.charAt(3) - 48) == null || set.higher(time.charAt(3) - 48) > 5)
				res.append(set.first());
			else {
				res.append(set.higher(time.charAt(3) - 48));
				point = 0;
			}
		}
		res.append(':');
		if (point == 0)
			res.append(time.charAt(1));
		else {
			if (time.charAt(0) == 2) {
				if (set.higher(time.charAt(1) - 48) == null || set.higher(time.charAt(1) - 48) > 3)
					res.append(set.first());
				else {
					res.append(set.higher(time.charAt(1) - 48));
					point = 0;
				}
			} else {
				if (set.higher(time.charAt(1) - 48) == null)
					res.append(set.first());
				else {
					res.append(set.higher(time.charAt(1) - 48));
					point = 0;
				}
			}
		}
		if (point == 0)
			res.append(time.charAt(0));
		else {
			if (set.higher(time.charAt(0) - 48) == null || set.higher(time.charAt(0) - 48) > 2)
				res.append(set.first());
			else
				res.append(set.higher(time.charAt(0) - 48));
		}
		res.reverse();
		return res.toString();
	}
}
