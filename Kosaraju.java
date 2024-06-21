import java.util.ArrayList;
import java.util.*;
//18 Jun

public class Kosaraju {
	
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
		
		graph[0].add(new Edge(0, 2, 5));
		graph[0].add(new Edge(0, 3, 5));

		
		graph[1].add(new Edge(1, 0, 5));
//		graph[1].add(new Edge(1, 2, 1));
//		graph[1].add(new Edge(1, 3, 3));
		
		
		graph[2].add(new Edge(2, 1, 1));
//		graph[2].add(new Edge(2, 3, 1));
//		graph[2].add(new Edge(2, 4, 4));
		
		graph[3].add(new Edge(3, 4, 3));
//		graph[3].add(new Edge(3, 2, 1));
//		
//		graph[4].add(new Edge(4, 0, 3));
//		graph[4].add(new Edge(4, 1, 3));
//		
//		graph[5].add(new Edge(5, 2, 3));
//		graph[5].add(new Edge(5, 0, 3));
	}	
	
	
	public static void topSort(ArrayList<Edge> graph[],int curr, boolean vis[], Stack<Integer> s) {
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				topSort(graph, e.dest, vis, s);	
			}				
		}
		s.push(curr);
//		System.out.println(curr);
	}
	
	public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
		vis[curr] = true;
		System.out.print(curr+" ");
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				dfs(graph, e.dest, vis);
			}
		}
	}
	
	public static void kosaraju(ArrayList<Edge> graph[], int V) {
		boolean vis[] = new boolean[V];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<V; i++) {
			if(!vis[i]) {
				topSort(graph, i, vis, s);
			}
		}
		
		ArrayList<Edge> transpose[] = new ArrayList[V];
		
		for(int i=0; i<transpose.length; i++) {
			vis[i] = false;
			transpose[i] = new ArrayList<>();
		}
		
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph[i].size(); j++) {
				Edge e = graph[i].get(j);
				transpose[e.dest].add(new Edge(e.dest, e.src,  1));
			}
		}
		
		while(!s.isEmpty()) {
			int curr = s.pop();
			if(!vis[curr]) {
				dfs(transpose, curr, vis);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		kosaraju(graph, V);
	}

}
