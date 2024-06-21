import java.util.ArrayList;

import DFS.Edge;

public class HasPath {

	static class Edge{
		int src;
		int dest;
		int wt;
		
		public Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 5));
		
		
		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));
		
		
		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 4));
		
		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 2, 1));
		
		graph[4].add(new Edge(4, 2, 3));
	}
	
	public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
		if(src == dest) {
			return true;
		}
		
		vis[src] = true;
		for(int i=0; i<graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		System.out.println(hasPath(graph, 2, 4, new boolean[V]));
	}

}
