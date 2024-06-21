import java.util.ArrayList;

import TopologicalSortBFS.Edge;

public class PathPrint {
	
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
		
//		graph[0].add(new Edge(0, 1, 5));
		
		
//		graph[1].add(new Edge(1, 0, 5));
//		graph[1].add(new Edge(1, 2, 1));
//		graph[1].add(new Edge(1, 3, 3));
		
		graph[0].add(new Edge(0, 2, 3));
		graph[2].add(new Edge(2, 3, 1));
//		graph[2].add(new Edge(2, 3, 1));
//		graph[2].add(new Edge(2, 4, 4));
		
		graph[3].add(new Edge(3, 1, 3));
//		graph[3].add(new Edge(3, 2, 1));
		
		graph[4].add(new Edge(4, 0, 3));
		graph[4].add(new Edge(4, 1, 3));
		
		graph[5].add(new Edge(5, 2, 3));
		graph[5].add(new Edge(5, 0, 3));
	}
	
	public static void printPath(ArrayList<Edge> graph[], int src, int dest, String path) {
		if(src == dest) {
			System.out.println(path+dest);
			return;
		}
		
		for(int i=0; i<graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			printPath(graph, e.dest, dest, path+src);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		printPath(graph, 5, 3, "");

	}

}
