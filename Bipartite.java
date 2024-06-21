import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import BFS.Edge;

public class Bipartite {
	
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

	public static boolean isBipartite(ArrayList<Edge> graph[]) {
		int col[] = new int[graph.length];
		Arrays.fill(col, -1);
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<graph.length; i++) {
			if(col[i] == -1) {
				q.add(i);
				col[i] = 0;
				while(!q.isEmpty()) {
					int curr = q.remove();
					for(int j=0; j<graph[curr].size(); j++) {
						Edge e = graph[curr].get(j);
						if(col[e.dest]==-1) {
							int nextCol = col[curr]==0 ? 1:0;
							col[e.dest] = nextCol;
							q.add(e.dest);
						}else if(col[e.dest] == col[curr]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
//		bfs(graph);
//		dfs(graph, 0, new boolean[V]);
		if(isBipartite(graph)) {
			System.out.println("Graph is Bipartite");
		}else {
			System.out.println("Graph is not Bipartite");
		}
		
	}

}
