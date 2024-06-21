import java.util.*;

import BFS.Edge;

public class TopologicalSort {
	
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
//		
//		
//		graph[1].add(new Edge(1, 0, 5));
//		graph[1].add(new Edge(1, 2, 1));
//		graph[1].add(new Edge(1, 3, 3));
//		
//		
//		graph[2].add(new Edge(2, 1, 1));
//		graph[2].add(new Edge(2, 3, 1));
//		graph[2].add(new Edge(2, 4, 4));
//		
//		graph[3].add(new Edge(3, 1, 3));
//		graph[3].add(new Edge(3, 2, 1));
//		
//		graph[4].add(new Edge(4, 2, 3));
		
		graph[1].add(new Edge(1, 0, 5));
		graph[0].add(new Edge(0, 2, 1));
		graph[2].add(new Edge(2, 1, 3));
		
		
		graph[2].add(new Edge(2, 5, 1));
		graph[5].add(new Edge(5, 4, 1));
		graph[4].add(new Edge(4, 6, 4));
		
		graph[6].add(new Edge(6, 5, 3));
//		graph[3].add(new Edge(3, 2, 1));
//		
//		graph[4].add(new Edge(4, 2, 3));
		
		
	}
	
	
	public static void topSort(ArrayList<Edge> graph[]) {
		Stack<Integer> s = new Stack<>();
		boolean vis[] = new boolean[graph.length];
		
		for(int i=0; i<graph.length; i++) {
			if(!vis[i]) {
				topSortUtil(graph, i, vis, s);
			}
		}
		while(!s.isEmpty()) {
			System.out.println(s.pop()+" ");
		}
	}
	
	public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				topSortUtil(graph, e.dest, vis, stack);
			}
		}
		stack.push(curr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int V = 7;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
//		bfs(graph);
//		dfs(graph, 0, new boolean[V]);
		topSort(graph);
		
	}

}
