
import java.util.Scanner;

class SimRule {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Segments: ");
		int n = s.nextInt();
		System.out.print("Integrate from ∞ to: ");
		double high = s.nextDouble();
		System.out.println(.5d + integral(0d, high, new NormDist(), .000000001d, n));
		
	}
	
	public static double integral (double xlow, double xhigh, Function f, double errorThreshold, double n) {
		
		double lastResult = 0;
		double result = 0;
		double error = 0;
		
		boolean done = false;
		while (!done || error > errorThreshold) {
			lastResult = result;
			
			double width = (xhigh - xlow) / n;
			double third = width / 3;
			result = f.of(xlow) * third;
			for (int i = 1; i < n; i++) {
				double value = f.of(xlow + i * width) * third;
				if ((i & 1) == 0) { // test if even
					result += 2 * value;
				} else {
					result += 4 * value;
				}
			}
			result += f.of(xhigh) * third;
			
			error = Math.abs(lastResult - result);
			n *= 2;
			done = true;
		}
		return result;
		
	}
	
	public interface Function {
		public double of(double x);
	}
	
	public static class NormDist implements Function {
		public double of(double x) {
			return Math.exp( - (x * x ) / 2 ) / Math.sqrt(Math.PI * 2);
		}
	}
}
// 43 LOC