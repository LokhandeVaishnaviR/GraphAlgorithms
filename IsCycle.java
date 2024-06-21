import java.util.ArrayList;

import BFS.Edge;

public class IsCycle {

	
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

	public static boolean isCycle(ArrayList<Edge> graph[]) {
		boolean vis[] = new boolean[graph.length];
		boolean stack[] = new boolean[graph.length];
		
		for(int i=0; i<graph.length; i++) {
			if(!vis[i]) {
				if(isCycleUtil(graph, i, vis, stack)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
		vis[curr] = true;
		stack[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(stack[e.dest]) {
				return true;
			}
			if(!vis[curr] && isCycleUtil(graph, e.dest, vis, stack)) {
				return true;
			}
		}
		stack[curr] = false;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
//		bfs(graph);
//		dfs(graph, 0, new boolean[V]);
		System.out.println(isCycle(graph));
	}

}
