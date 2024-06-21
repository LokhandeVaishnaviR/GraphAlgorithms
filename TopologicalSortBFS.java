import java.util.ArrayList;
import java.util.*;

import BFS.Edge;

public class TopologicalSortBFS {

	
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
	
	public static void topSortBFS(ArrayList<Edge> graph[]) {
		int indeg[] = new int[graph.length];
		calIndeg(graph, indeg);
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<indeg.length; i++) {
			if(indeg[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			System.out.println(curr+" ");
			for(int i=0; i<graph[curr].size(); i++) {
				Edge e = graph[curr].get(i);
				indeg[e.dest]--;
				if(indeg[e.dest]==0) {
					q.add(e.dest);
				}
			}
		}
	}
	
	public static void calIndeg(ArrayList<Edge> graph[], int indeg[]) {
		
		for(int i=0; i<graph.length; i++) {
			int v=i;
			for(int j=0; j<graph[v].size(); j++) {
				Edge e = graph[v].get(j);
				indeg[e.dest]++;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
//		bfs(graph);
//		dfs(graph, 0, new boolean[V]);
		topSortBFS(graph);

	}

}
