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
        double r = Correlation.correlate(xVals, yVals);
        double t = Correlation.significance(r, n);
        System.out.println(r);
        System.out.println(t);
    }
}
