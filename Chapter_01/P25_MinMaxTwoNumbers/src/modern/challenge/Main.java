package modern.challenge;

import java.util.function.BinaryOperator;

public class Main {

    private static final int I1 = -45;
    private static final int I2 = -15;

    private static final long L1 = 123L;
    private static final long L2 = 3L;

    private static final float F1 = 33.34F;
    private static final float F2 = 33.213F;

    private static final double D1 = 0.023844D;
    private static final double D2 = 0.35468856D;

    public static void main(String[] args) {

        // compare two integers
        int minII = Integer.min(I1, I2);
        int minIM = Math.min(I1, I2);
        int minIB = BinaryOperator.minBy(Integer::compare).apply(I1, I2);

        int maxII = Integer.max(I1, I2);
        int maxIM = Math.max(I1, I2);
        int maxIB = BinaryOperator.maxBy(Integer::compare).apply(I1, I2);

        System.out.println("\nCompare two integers:");
        System.out.println("(" + I1 + ", " + I2 + "): BinaryOperator.minBy(): " + minIB + " BinaryOperator.maxBy():" + maxIB);
        System.out.println("(" + I1 + ", " + I2 + "): Math.min(): " + minIM + " Math.max(): " + maxIM);
        System.out.println("(" + I1 + ", " + I2 + "): Integer.min(): " + minII + " Integer.max(): " + maxII);

        // compare two longs
        long minLL = Long.min(L1, L2);
        long minLM = Math.min(L1, L2);
        long minLB = BinaryOperator.minBy(Long::compare).apply(L1, L2);

        long maxLL = Long.max(L1, L2);
        long maxLM = Math.max(L1, L2);
        long maxLB = BinaryOperator.maxBy(Long::compare).apply(L1, L2);

        System.out.println("\nCompare two longs:");
        System.out.println("(" + L1 + ", " + L2 + "): BinaryOperator.minBy(): " + minLB + " BinaryOperator.maxBy():" + maxLB);
        System.out.println("(" + L1 + ", " + L2 + "): Math.min(): " + minLM + " Math.max(): " + maxLM);
        System.out.println("(" + L1 + ", " + L2 + "): Long.min(): " + minLL + " Long.max(): " + maxLL);

        // compare two floats
        float minFF = Float.min(F1, F2);
        float minFM = Math.min(F1, F2);
        float minFB = BinaryOperator.minBy(Float::compare).apply(F1, F2);

        float maxFF = Float.max(F1, F2);
        float maxFM = Math.max(F1, F2);
        float maxFB = BinaryOperator.maxBy(Float::compare).apply(F1, F2);

        System.out.println("\nCompare two floats:");
        System.out.println("(" + F1 + ", " + F2 + "): BinaryOperator.minBy(): " + minFB + " BinaryOperator.maxBy():" + maxFB);
        System.out.println("(" + F1 + ", " + F2 + "): Math.min(): " + minFM + " Math.max(): " + maxFM);
        System.out.println("(" + F1 + ", " + F2 + "): Float.min(): " + minFF + " Float.max(): " + maxFF);

        // compare two doubles
        double minDD = Double.min(D1, D2);
        double minDM = Math.min(D1, D2);
        double minDB = BinaryOperator.minBy(Double::compare).apply(D1, D2);

        double maxDD = Double.max(D1, D2);
        double maxDM = Math.max(D1, D2);
        double maxDB = BinaryOperator.maxBy(Double::compare).apply(D1, D2);

        System.out.println("\nCompare two doubles:");
        System.out.println("(" + D1 + ", " + D2 + "): BinaryOperator.minBy(): " + minDB + " BinaryOperator.maxBy():" + maxDB);
        System.out.println("(" + D1 + ", " + D2 + "): Math.min(): " + minDM + " Math.max(): " + maxDM);
        System.out.println("(" + D1 + ", " + D2 + "): Double.min(): " + minDD + " Double.max(): " + maxDD);
    }
}
