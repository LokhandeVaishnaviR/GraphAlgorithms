import java.util.ArrayList;

import TopologicalSortBFS.Edge;

public class BellmanFord {

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
		
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));
		
		
//		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, -4));
//		graph[1].add(new Edge(1, 3, 3));
		
		
		graph[2].add(new Edge(2, 3, 2));
//		graph[2].add(new Edge(2, 3, 1));
//		graph[2].add(new Edge(2, 4, 4));
		
		graph[3].add(new Edge(3, 4, 4));
//		graph[3].add(new Edge(3, 2, 1));
		
//		graph[4].add(new Edge(4, 0, 3));
		graph[4].add(new Edge(4, 1, -1));
		
//		graph[5].add(new Edge(5, 2, 3));
//		graph[5].add(new Edge(5, 0, 3));
	}
	
	public static void createGraph2(ArrayList<Edge> graph) {
		
	
		graph.add(new Edge(0, 1, 2));
		graph.add(new Edge(0, 2, 4));
		
		
//		graph[1].add(new Edge(1, 0, 5));
		graph.add(new Edge(1, 2, -4));
//		graph[1].add(new Edge(1, 3, 3));
		
		
		graph.add(new Edge(2, 3, 2));
//		graph[2].add(new Edge(2, 3, 1));
//		graph[2].add(new Edge(2, 4, 4));
		
		graph.add(new Edge(3, 4, 4));
//		graph[3].add(new Edge(3, 2, 1));
		
//		graph[4].add(new Edge(4, 0, 3));
		graph.add(new Edge(4, 1, -1));
		
//		graph[5].add(new Edge(5, 2, 3));
//		graph[5].add(new Edge(5, 0, 3));
	}	
	
	
	
	public static void bellman2(ArrayList<Edge> graph, int src, int V) {
		int dis[] = new int[V];
		for(int i=0; i<dis.length; i++) {
			if(i!=src) {
				dis[i] = Integer.MAX_VALUE;
			}
		}
		

		
		for(int i=0; i<V-1; i++) {

				for(int k=0; k<graph.size(); k++) {
					Edge e = graph.get(k);
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					
					//Relaxation
					if(dis[u] != Integer.MAX_VALUE && dis[u]+wt < dis[v]) {
						dis[v] = dis[u] + wt;
					}
				}
			
		}
		
		for(int i=0; i<dis.length; i++) {
			System.out.println(dis[i]+" ");
		}
	}
		
	public static void bellman(ArrayList<Edge> graph[], int src) {
		int dis[] = new int[graph.length];
		for(int i=0; i<dis.length; i++) {
			if(i!=src) {
				dis[i] = Integer.MAX_VALUE;
			}
		}
		
		int V = graph.length; //vertex
		
		for(int i=0; i<V-1; i++) {
			//edges
			for(int j=0; j<graph.length; j++) {
				for(int k=0; k<graph[j].size(); k++) {
					Edge e = graph[j].get(k);
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					
					//Relaxation
					if(dis[u] != Integer.MAX_VALUE && dis[u]+wt < dis[v]) {
						dis[v] = dis[u] + wt;
					}
				}
			}
		}
		
		for(int i=0; i<dis.length; i++) {
			System.out.println(dis[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		ArrayList<Edge> graph1 = new ArrayList<>();

		createGraph(graph);
		createGraph2(graph1);
//		bfs(graph);
//		dfs(graph, 0, new boolean[V]);
		bellman2(graph1, 0, V);

	}	
	
}
