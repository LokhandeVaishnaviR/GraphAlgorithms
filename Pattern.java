
public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(i==0 || j==0 || i==n-1 || j==n-1) {
//					System.out.print("*");
//				}else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				System.out.print(" ");
			}
			
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		int a = 0;
		for(int i=n; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				System.out.print(a+++" ");			
			}
			System.out.println();
		}
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=i; j++) {
				if((i+j)%2==0) {
					System.out.print("1");
				}else {
					System.out.print("0");
				}
							
			}
			System.out.println();
		}
		
//		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");		
			}
			for(int j=1; j<=2*(n-i); j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=n; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");		
			}
			for(int j=1; j<=2*(n-i); j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=n; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++){
				System.out.print(" ");
			}
			for(int j=1; j<=n; j++) {
				if(j==1||i==1||j==n||i==n) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
		
		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n-i; j++){
//				System.out.print(" ");
//			}
			for(int j=1; j<=(n-i); j++) {
				System.out.print(" ");				
			}
			for(int j=1; j<=(2*i)-1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		for(int i=n; i>=1; i--) {
//			for(int j=1; j<=n-i; j++){
//				System.out.print(" ");
//			}
			for(int j=1; j<=(n-i); j++) {
				System.out.print(" ");				
			}
			for(int j=1; j<=(2*i)-1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
	}

}
