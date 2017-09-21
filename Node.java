import java.util.ArrayList;

public class Node implements Comparable<Node>{
	public int val;
	public ArrayList<Node> list = new ArrayList<Node>();

	public Node(int val) {
		this.val = val;
	}

	public final void add(Node p) {
		this.list.add(p);
	}

	@Override
	public int compareTo(Node o) {
		return o.hashCode();
	}
}
