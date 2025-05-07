import java.io.*;
import java.util.*;

public class Main {
    static long getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;

        int firstMax = -1;
        int secondMax = -1;
        
        for (int i = 0; i < n; i++) {
            if (firstMax == -1 || numbers[i] > numbers[firstMax]) {
                firstMax = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i != firstMax && (secondMax == -1 || numbers[i] > numbers[secondMax])) {
                secondMax = i;
            }
        }
        
        return (long) numbers[firstMax] * numbers[secondMax];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}