import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("pairs: ");
        int n = scanner.nextInt();
        double[] xVals = new double[n];
        double[] yVals = new double[n];
        System.out.println("input pairs");
        for (int i = 0; i < n; i++) {
            xVals[i] = scanner.nextDouble();
            yVals[i] = scanner.nextDouble();
        }
        double correlation = Correlation.correlate(xVals, yVals);
        double distribution = .5d + SimRule.integral(0d, correlation, new SimRule.NormDist(), .000000001d, n);
        System.out.println(correlation);
        System.out.println(distribution);
    }
}
