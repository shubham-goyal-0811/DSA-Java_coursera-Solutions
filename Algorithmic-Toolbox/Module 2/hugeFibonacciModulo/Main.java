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
        System.out.println(hugeFibonacciModulo(scanner.nextLong(), scanner.nextInt()));
        // System.out.println(lastDigitOfFibonacciSum(scanner.nextLong()));
        // System.out.println(lastDigitOfPartialFibonacciSum(scanner.nextLong(), scanner.nextLong()));
        // System.out.println(lastDigitOfSumOfSquares(scanner.nextLong()));
        // System.out.println(gcd(scanner.nextLong(), scanner.nextLong()));
        // System.out.println(lcm(scanner.nextLong(), scanner.nextLong()));
    }
    
    // 2.1.1 Fibonacci Number
    public static int fibonacciNumber(int n) {
        if (n <= 1) return n;
        
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    // 2.1.2 Last Digit of Fibonacci Number
    public static int lastDigitOfFibonacci(int n) {
        if (n <= 1) return n;
        
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    // 2.1.3 Huge Fibonacci Number Modulo m
    public static long hugeFibonacciModulo(long n, int m) {
        if (n <= 1) return n % m;
        
        // Find Pisano period for m
        long period = findPisanoPeriod(m);
        long equivalentFib = n % period;
        
        return fibonacciMod(equivalentFib, m);
    }
    
    private static long findPisanoPeriod(int m) {
        long prev = 0;
        long curr = 1;
        long period = 0;
        
        for (int i = 0; i < m * m; i++) {
            long next = (prev + curr) % m;
            prev = curr;
            curr = next;
            period++;
            
            if (prev == 0 && curr == 1) {
                return period;
            }
        }
        return period;
    }
    
    private static long fibonacciMod(long n, int m) {
        if (n <= 1) return n % m;
        
        long prev = 0;
        long curr = 1;
        for (long i = 2; i <= n; i++) {
            long next = (prev + curr) % m;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    // 2.1.4 Last Digit of the Sum of Fibonacci Numbers
    public static int lastDigitOfFibonacciSum(long n) {
        // The sum of first n Fibonacci numbers is F(n+2) - 1
        // So last digit is (F(n+2) - 1) mod 10
        int equivalentFib = (int)((n + 2) % 60); // Pisano period for mod 10 is 60
        int fib = lastDigitOfFibonacci(equivalentFib);
        return (fib - 1 + 10) % 10; // +10 to handle negative mod result
    }
    
    // 2.1.5 Last Digit of the Partial Sum of Fibonacci Numbers
    public static int lastDigitOfPartialFibonacciSum(long m, long n) {
        // Sum(Fm to Fn) = F(n+2) - F(m+1)
        int sumN = lastDigitOfFibonacciSum(n);
        int sumM = lastDigitOfFibonacciSum(m - 1);
        return (sumN - sumM + 10) % 10; // +10 to handle negative mod result
    }
    
    // 2.1.6 Last Digit of the Sum of Squares of Fibonacci Numbers
    public static int lastDigitOfSumOfSquares(long n) {
        // Sum of squares F0^2 + F1^2 + ... + Fn^2 = Fn * F(n+1)
        int equivalentFibN = (int)(n % 60);
        int equivalentFibNPlus1 = (int)((n + 1) % 60);
        
        int fibN = lastDigitOfFibonacci(equivalentFibN);
        int fibNPlus1 = lastDigitOfFibonacci(equivalentFibNPlus1);
        
        return (fibN * fibNPlus1) % 10;
    }
    
    // 2.1.7 Greatest Common Divisor
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 2.1.8 Least Common Multiple
    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
}