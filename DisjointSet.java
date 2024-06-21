
public class DisjointSet {

	static int n = 12;
	static int par[] = new int[n];
	static int rank[]= new int[n];
	
	public static void init() {
		for(int i=0; i<n; i++) {
			par[i] = i;
		}
	}
	
	public static int find(int x) {//using backtraking and recursion 
		if(par[x] == x) {
			return x;
		}
		
		par[x] = find(par[x]);
		return find(par[x]);//path compression
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
//		System.out.println(find(3));
//		union(1,3);
//		System.out.println(find(3));
//		union(2,4);
//		union(1,2);
//		System.out.println(find(4));
		union(4, 2);
		union(3, 5);
		union(3, 6);
		union(1, 2);
		union(3, 1);
		
		
		union(8, 10);
		union(9, 11);
		union(9, 8);
		union(9, 1);
		System.out.println(rank[9]+" "+rank[4]+" "+find(4));
//		union(4, 2);

	}

}
