

public class Correlation {

    public static double correlate (double[] x, double[] y) {
        int n = x.length;
        double sumX = 0,
                avgX = 0,
                sumY = 0,
                avgY = 0,
                num = 0,
                den1 = 0,
                den2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
        }
        avgX = sumX / n;
        avgY = sumY /n;
        for (int i = 0; i < n; i++) {
            num += (x[i] - avgX)*(y[i] - avgY);
            den1 += (x[i] - avgX)*(x[i] - avgX);
            den2 += (y[i] - avgY)*(y[i] - avgY);
        }

        return num / Math.sqrt(den1*den2);
    }
}