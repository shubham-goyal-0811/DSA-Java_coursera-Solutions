import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);
     System.out.println(gcd(scanner.nextLong(), scanner.nextLong())); 
  }
  public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}