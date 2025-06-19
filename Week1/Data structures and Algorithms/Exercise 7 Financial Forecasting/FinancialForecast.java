import java.util.HashMap;

public class FinancialForecast {

    /*
     * Step 1: Understand Recursive Algorithms
     * ---------------------------------------
     * Recursion is a technique where a method calls itself to solve a smaller version of the problem.
     * It is useful for problems that can be broken down into repetitive subproblems, like calculating:
     * - Factorials
     * - Fibonacci numbers
     * - Future financial values with repeated compounding
     * 
     * For financial forecasting, recursion helps simulate compound growth:
     * futureValue = presentValue * (1 + rate)^years
     * Each year depends on the value from the previous year.
     */

    // Step 2 & 3: Recursive Method to calculate Future Value
    public static double futureValueRecursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue, rate, years - 1) * (1 + rate);
    }

    // Step 3 (Optimized): Recursive Method with Memoization
    public static double futureValueMemo(double presentValue, double rate, int years, HashMap<Integer, Double> memo) {
        if (years == 0) return presentValue;

        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        double result = futureValueMemo(presentValue, rate, years - 1, memo) * (1 + rate);
        memo.put(years, result);
        return result;
    }

    // Step 3 (Alternative): Iterative Method using Dynamic Programming
    public static double futureValueIterative(double presentValue, double rate, int years) {
        double futureValue = presentValue;
        for (int i = 1; i <= years; i++) {
            futureValue *= (1 + rate);
        }
        return futureValue;
    }

    // Step 4: Main method - Execution and Output
    public static void main(String[] args) {
        double presentValue = 1000.0;
        double annualGrowthRate = 0.05; // 5% growth
        int forecastYears = 5;

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Step 1: Understanding Recursion - See comments for details.");
        System.out.println("Step 2: Set up present value, rate, and years.");
        System.out.printf("Present Value: $%.2f\n", presentValue);
        System.out.printf("Growth Rate: %.2f%%\n", annualGrowthRate * 100);
        System.out.printf("Forecast Period: %d years\n\n", forecastYears);

        System.out.println("Step 3: Implementation - Different Approaches\n");

        // 1. Recursive approach
        double resultRec = futureValueRecursive(presentValue, annualGrowthRate, forecastYears);
        System.out.printf("1. Recursive Result: $%.2f\n", resultRec);

        // 2. Recursive with Memoization
        HashMap<Integer, Double> memo = new HashMap<>();
        double resultMemo = futureValueMemo(presentValue, annualGrowthRate, forecastYears, memo);
        System.out.printf("2. Memoized Result: $%.2f\n", resultMemo);

        // 3. Iterative version
        double resultIter = futureValueIterative(presentValue, annualGrowthRate, forecastYears);
        System.out.printf("3. Iterative Result: $%.2f\n", resultIter);

        // Step 4: Analysis
        System.out.println("\nStep 4: Analysis");
        System.out.println("- Recursive Time Complexity: O(n), Space: O(n) (due to call stack)");
        System.out.println("- Memoized Time Complexity: O(n), Space: O(n) (faster due to caching)");
        System.out.println("- Iterative Time Complexity: O(n), Space: O(1) (best performance)");
    }
}
