import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Determine which problem to solve based on input
        // For simplicity, we'll assume the user knows which input to provide
        // for each problem. In practice, you might want to add a menu system.
        
        // Uncomment the method you want to test
        
        // System.out.println(fibonacciNumber(scanner.nextInt()));
        // System.out.println(lastDigitOfFibonacci(scanner.nextInt()));
        // System.out.println(hugeFibonacciModulo(scanner.nextLong(), scanner.nextInt()));
        // System.out.println(lastDigitOfFibonacciSum(scanner.nextLong()));
        System.out.println(lastDigitOfPartialFibonacciSum(scanner.nextLong(), scanner.nextLong()));
        // System.out.println(lastDigitOfSumOfSquares(scanner.nextLong()));
        // System.out.println(gcd(scanner.nextLong(), scanner.nextLong()));
        // System.out.println(lcm(scanner.nextLong(), scanner.nextLong()));
    }
    
    // 2.1.1 Fibonacci Number
    public static int lastDigitOfPartialFibonacciSum(long m, long n) {
        if (m > n) return 0;
        
        // Sum(Fm to Fn) = F(n+2) - F(m+1)
        int sumN = lastDigitOfFibonacciSum(n);
        int sumM = lastDigitOfFibonacciSum(m - 1);
        return (sumN - sumM + 10) % 10;
    }
    
    // Helper method for partial sum calculation
    private static int lastDigitOfFibonacciSum(long n) {
        if (n <= 0) return 0;
        
        // The sum of first n Fibonacci numbers is F(n+2) - 1
        int fibNPlus2 = lastDigitOfFibonacci((n + 2) % 60);
        return (fibNPlus2 - 1 + 10) % 10;
    }
}