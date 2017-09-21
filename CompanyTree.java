import java.util.Map;
import java.util.TreeMap;

public class CompanyTree {
	static TreeMap<Node, Double> hash = new TreeMap<Node, Double>();

	public static void main(String[] args) {
		System.out.print("Hello, World!\n");
		Node root = new Node(5);
		Node p1 = new Node(1);
		root.add(p1);
		Node p2 = new Node(2);
		root.add(p2);
		Node p3 = new Node(10);
		root.add(p3);
		Node p4 = new Node(4);
		root.add(p4);
		Node p5 = new Node(5);
		root.add(p5);
		Node p6 = new Node(2);
		p5.add(p6);
		System.out.print(companytree(root));
		System.out.print("\n");
	}

	public static void dfs(Node root, TreeMap<Node, Double> hash) {
		if (root == null || root.list.isEmpty()) {
			return;
		}
		double sum = 0;
		for (int i = 0; i < root.list.size(); i++) {
			sum += root.list.get(i).val;
			dfs(root.list.get(i), hash);
		}
		hash.put(root, sum / (int) root.list.size());
	}

	public static double companytree(Node root) {
		if (root == null) {
			return 0;
		}
		dfs(root, hash);
		double maxavg = 0.0;
		if (hash.containsValue(root)) {
			maxavg = hash.get(root);
		}
		for (Map.Entry<Node, Double> entry : hash.entrySet()) {
			if (entry.getValue() > maxavg) {
				maxavg = entry.getValue();
			}
		}
		return maxavg;
	}

}
