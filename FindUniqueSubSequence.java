import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindAllUniqueSubstring {

	@Test
	public void testMethod() {
		FindAllUniqueSubstring tester = new FindAllUniqueSubstring();
		String temp = "caaab";
		assertEquals(null,tester.getUnique(temp, 2));
	}

	public List<String> getUnique(String s, int k) {
		TreeSet<String> allUnique = new TreeSet<String>();
		for (int i = 0; i+k <= s.length(); i++) {
			String temp = s.substring(i, i + k);
			allUnique.add(temp);
		}
		List<String> list = new ArrayList<String>(allUnique);
		return list;
	}

}
