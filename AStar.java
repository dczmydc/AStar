import java.util.*;

public class AStar {
	public PriorityQueue<Node> openList;
	public HashSet<Node> closeList = new HashSet<Node>();
	public Node startPoint = null;
	public Node targetPoint = null;
	public HashSet<Node> obstacleList = new HashSet<Node>();

	public static void main(String[] args) {
		Comparator<Node> comparator = new NodeComparator();

		AStar algo = new AStar();
		algo.openList = new PriorityQueue<Node>(1000, comparator);
		algo.setSample2();
		algo.findRoute();
	}

	public void setSample1() {
		this.setStartPoint(-3,0);
		this.setTargetPoint(3,0);
		this.appendObstacle(0,1);
		this.appendObstacle(0,0);
		this.appendObstacle(0,-1);
	}

	public void setSample2() {
		this.setStartPoint(50,50);
		this.setTargetPoint(65,65);
		this.appendObstacle(55,60);
		this.appendObstacle(56,60);
		this.appendObstacle(57,60);
		this.appendObstacle(58,60);
		this.appendObstacle(59,60);
		this.appendObstacle(60,60);
		this.appendObstacle(60,59);
		this.appendObstacle(60,58);
		this.appendObstacle(60,57);
		this.appendObstacle(60,56);
		this.appendObstacle(60,55);
	}

	public void setStartPoint(int x, int y) {
		this.startPoint = new Node(x,y);
		this.startPoint.setG(0);
	}

	public void setTargetPoint(int x, int y) {
		this.targetPoint = new Node(x,y);
	}

	public void appendObstacle(int x, int y) {
		this.obstacleList.add(new Node(x, y));
	}

	public void findRoute() {
		this.startPoint.calcH(this.targetPoint);
		openList.add(startPoint);
		while (!openList.isEmpty()) {
			Node current = openList.poll();
			int dist = current.g;
			System.out.println("AT\t"
				+ current.x + "\t"
				+ current.y + "\t"
				+ dist + "\t"
				+ current.getF());
			// System.out.println("AT " + current.x + " " + current.y + " " + dist);
			for (int dx = -1; dx <= 1; dx++) {
				for (int dy = -1; dy <= 1; dy++) {
					if ((dx == 0) && (dy == 0)) {
						continue;
					}
					Node nei = new Node(current.x + dx, current.y + dy);

					if (obstacleList.contains(nei)) {
						continue;
					}

					int newDist;
					if (dx * dy == 0) {
						newDist = dist + 1000;
					}
					else {
						newDist = dist + 1414;
					}
					nei.setG(newDist);
					nei.calcH(this.targetPoint);
					if (closeList.contains(nei)) {
						continue;
					}
					// else if (openList.contains(nei)) {
					// 	continue;
					// }
					// else {
					// 	System.out.println("New Node added " + nei.x + " " + nei.y);
					// }
					System.out.println("PROCESSING\t"
						+ nei.x + "\t"
						+ nei.y + "\t"
						+ newDist + "\t"
						+ nei.getF());

					openList.add(nei);
					if (nei.equals(this.targetPoint)) {
						System.out.println("DIST= " + nei.g);
						return;
					}
				}
			}
			closeList.add(current);
			// System.out.println("CLOSE SIZE " + closeList.size());
			// System.out.println("OPEN SIZE " + openList.size());

		}
	}
}
