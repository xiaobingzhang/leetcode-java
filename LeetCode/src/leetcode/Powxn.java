 

public class Powxn {
	public static void main(String[] args) {
		double a = 0.1;
		System.out.println(a);
		long begin = System.currentTimeMillis();
		System.out.println(pow(2, 10000));
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

	
	public static double pow(double x, int n) {
		if(n==0){
			return 1.0;
		}
		double half;
		if(n>0){
			 half = pow(x, n>>1);
			
		}else{
			 half = 1.0/pow(x, -(n>>1));
		}
		if(n%2==0){
			return half*half;
		}else{
			return half*half*x;
		}
	}
}
