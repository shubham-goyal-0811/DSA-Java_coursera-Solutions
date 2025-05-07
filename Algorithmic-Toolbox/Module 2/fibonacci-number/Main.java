import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println(fibonacciNumber(sc.nextInt()));
  }
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
    
}