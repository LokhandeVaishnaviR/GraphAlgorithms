import java.util.ArrayList;
import java.util.Collections;

public class KruskalsMST {
	
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int cost;
		
		public Edge(int s, int d, int c) {
			this.src = s;
			this.dest = d;
			this.cost = c;
		}
		
		@Override
		public int compareTo(Edge e2) {
			return this.cost - e2.cost;
		}
	}
	
	
	public static void createGraph(ArrayList<Edge> edges) {
		edges.add(new Edge(0,1,15));
		edges.add(new Edge(0,2,10));
		edges.add(new Edge(0,3,19));
		edges.add(new Edge(1,3,7));
		edges.add(new Edge(1,4,17));
		// edges.add(new Edge(1,0,15));
		// edges.add(new Edge(2,0,10));
		edges.add(new Edge(2,3,16));
		edges.add(new Edge(2,5,14));
		// edges.add(new Edge(3,0,19));
		// edges.add(new Edge(3,1,7));
		// edges.add(new Edge(3,2,16));
		edges.add(new Edge(3,4,12));
		edges.add(new Edge(3,5,6));
		edges.add(new Edge(3,6,3));
		// edges.add(new Edge(4,1,17));
		// edges.add(new Edge(4,3,12));
		edges.add(new Edge(4,6,20));
		edges.add(new Edge(4,7,13));
		// edges.add(new Edge(5,2,14));
		// edges.add(new Edge(5,3,6));
		edges.add(new Edge(5,6,9));
		edges.add(new Edge(5,8,5));
		// edges.add(new Edge(6,4,20));
		// edges.add(new Edge(6,3,3));
		// edges.add(new Edge(6,5,9));
		edges.add(new Edge(6,7,4));
		edges.add(new Edge(6,9,11));
		edges.add(new Edge(6,8,1));
		// edges.add(new Edge(7,4,13));
		// edges.add(new Edge(7,6,4));
		edges.add(new Edge(7,9,2));
		// edges.add(new Edge(8,5,5));
		edges.add(new Edge(8,9,18));
		// edges.add(new Edge(8,6,1));
		// edges.add(new Edge(9,7,2));
		// edges.add(new Edge(9,8,18));
		// edges.add(new Edge(9,6,11));
	}

	static int n = 10;
	static int par[] = new int[n];
	static int rank[]= new int[n];
	
	public static void init() {
		for(int i=0; i<n; i++) {
			par[i] = i;
		}
	}
	
	public static int find(int x) {
		if(par[x] == x) {
			return x;
		}
		
		return par[x] = find(par[x]);
//		return par[x];
	}
	
	public static void union(int a, int b) {
		int parA = find(a);
		int parB = find(b);
		
		if(rank[parA] == rank[parB]) {
			par[parB] = parA;
			rank[parA]++;
		}else if(rank[parA] < rank[parB]) {
			par[parA] = parB;
		}else {
			par[parB] = parA;
		}
	}
	
	public static void kruskal(ArrayList<Edge> edges, int V) {
		init();
		Collections.sort(edges);
		int cost = 0;
		int count = 0;
		
		for(int i=0; count<V-1; i++) {
			Edge e = edges.get(i);
			
			int parA = find(e.src);
			int parB = find(e.dest);
			
			if(parA != parB) {
				union(e.src, e.dest);
				cost+= e.cost;
				count++;
			}
		}
		System.out.println("Cost of Minimum Spanning Tree using Kruskals :"+cost);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 10;
		ArrayList<Edge> edges = new ArrayList<>();
		createGraph(edges);
		kruskal(edges, V);

	}

}
