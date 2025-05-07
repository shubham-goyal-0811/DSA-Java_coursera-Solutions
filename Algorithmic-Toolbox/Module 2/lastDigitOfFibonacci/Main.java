import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
  }
  public static int lastDigitOfFibonacci(long n) {
        if (n <= 1) return (int)n;
        
        int prev = 0;
        int curr = 1;
        for (long i = 2; i <= n; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}