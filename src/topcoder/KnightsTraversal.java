package topcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class KnightsTraversal {
	
	
	public static void main(String...args) {
		KnightsTraversal knightsTraversal = new KnightsTraversal();
		System.out.println(knightsTraversal.tour(0, 0, 7, 7));
	}
	
	public List<Point> tour(int startX, int startY, int endX, int endY) {
		return tour(new Point(startX, startY), new Point(endX, endY));
	}
	
	public List<Point> tour(Point src, Point dest) {
		Queue<Point> toVisit = new LinkedList<>();
		Set<Point> visited = new HashSet<>();
		toVisit.add(src);
		while(!toVisit.isEmpty()) {
			Point curPoint = toVisit.remove();
			if (curPoint.equals(dest)) {
				return getPath(curPoint);
			}
			List<Point> possibleLegalMoves = getPossibleLegalMoves(curPoint);
			for (Point point : possibleLegalMoves) {
				if (!visited.contains(point)) {
					if (!toVisit.contains(point)) {
						point.setBackPoint(curPoint);
						toVisit.add(point);
					}
				}
			}
		}
		return null;
	}
	
	private List<Point> getPath(Point curPoint) {
		List<Point> path = new ArrayList<Point>();
		Point iterPoint = curPoint;
		path.add(iterPoint);
		while(iterPoint.getBackPoint() != null) {
			path.add(iterPoint.getBackPoint());
			iterPoint = iterPoint.getBackPoint();
		}
		Collections.reverse(path);
		return path;
	}

	public List<Point> getPossibleLegalMoves(Point src) {
		List<Point> possibleLegalMoves = new ArrayList<>();
		int startX = src.getX();
		int startY = src.getY();
		if (startX + 1 <= 7) {
			if (startY + 2 <= 7) {
				possibleLegalMoves.add(new Point(startX+1, startY+2));
			}
			if (startY - 2 >= 0) {
				possibleLegalMoves.add(new Point(startX+1, startY-2));
			}
		}
		if (startX + 2 <= 7) {
			if (startY + 1 <= 7) {
				possibleLegalMoves.add(new Point(startX + 2, startY + 1));
			}
			if (startY - 1 >= 0) {
				possibleLegalMoves.add(new Point(startX + 2, startY - 1));
			}
		}
		if (startX - 1 >= 0) {
			if (startY + 2 <= 7) {
				possibleLegalMoves.add(new Point(startX - 1, startY + 2));
			}
			if (startY - 2 >= 0) {
				possibleLegalMoves.add(new Point(startX - 1, startY - 2));
			}
		}
		if (startX - 2 >= 0) {
			if (startY + 1 <= 7) {
				possibleLegalMoves.add(new Point(startX - 2, startY + 1));
			}
			if (startY - 1 >= 0) {
				possibleLegalMoves.add(new Point(startX - 2, startY - 1));
			}
		}
		return possibleLegalMoves;
	}
	
	public class Point {
		int x;
		int y;
		Point backPoint = null;
		public Point getBackPoint() {
			return backPoint;
		}
		public void setBackPoint(Point backPoint) {
			this.backPoint = backPoint;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		private KnightsTraversal getOuterType() {
			return KnightsTraversal.this;
		}
	}
}
