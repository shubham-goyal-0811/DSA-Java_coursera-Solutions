import java.util.Scanner;

class Main{
  public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);
    System.out.println(lcm(scanner.nextLong(), scanner.nextLong()));
  }
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