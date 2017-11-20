import java.util.*;

public class Node {
	int x;
	int y;

	Integer g = null;
	Integer h = null;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Node(int x, int y, int g) {
		this.x = x;
		this.y = y;
		this.g = g;
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setG(int g) {
		this.g = g;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int calcH(Node terminal) {
		int xlen = Math.abs(terminal.x - this.x);
		int ylen = Math.abs(terminal.y - this.y);
		int dist = (xlen + ylen) * 1000;
		this.h = dist;
		return (this.h);
	}

	public int getF() {
		return (this.g + this.h);
	}

	public boolean equals(Object o) {
		if (o instanceof Node) {
			Node n = (Node)o;
			if (n.x != this.x) return false;
			if (n.y != this.y) return false;
		}
		else {
			return false;
		}
		return true;
	}

	public int hashCode() {
		int hash = 7;
		hash = (this.x + this.y) * hash + (this.g != null ? this.g.hashCode() : 0);
		return hash;
	}

	public static void main(String[] args) {
		Node n1 = new Node(4,5);
		Node n2 = new Node(2,3);
		Node n3 = new Node(4,5);
		// System.out.println(n1.equals(n2));
		// System.out.println(n1.equals(n3));
		// // n2.x = 4;
		// // n2.y = 5;
		// System.out.println(n2.equals(n3));
		// HashSet<Node> hsn = new HashSet<Node>();
		// hsn.add(n1);
		// hsn.add(n2);
		// System.out.println(hsn.contains(new Node(2,3)));

		//try pq
		// Comparator<Node> comparator = new NodeComparator();
		// PriorityQueue<Node> q = new PriorityQueue<Node>(1000, comparator);
		// q.offer(new Node(1,2,3));
		// q.offer(new Node(4,5,9));
		// q.offer(new Node(1,7,8));
		// q.offer(new Node(3,5,8));
		// q.offer(new Node(2,2,4));
		// System.out.println(q.contains(new Node(1,2,3)));
		// System.out.println(q.contains(new Node(1,2,4)));
		// System.out.println(q.contains(new Node(1,2)));
		// System.out.println(q.contains(new Node(2,2,3)));
		// System.out.println(q.contains(new Node(2,2,4)));
		//
		// q.remove(new Node(3,5,8));
		// q.remove(new Node(4,5,9));
		// q.remove(new Node(1,2,3));
		// q.remove(new Node(123,223,346));
		//
		// System.out.println(q.size());

		// Node n4 = new Node(1,2,15);
		// Node n5 = new Node(1,2,25);
		// System.out.println(n4.equals(n5));
	}

}
