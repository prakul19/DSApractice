import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static int downToZero(int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{n, 0});
        visited.add(n);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num=current[0], steps=current[1];
            if (num==0) return steps;
            if (!visited.contains(num -1)){
                queue.offer(new int[]{num - 1, steps + 1});
                visited.add(num - 1);
            }
            for (int i = 2;i<=Math.sqrt(num); i++){
                if (num % i == 0) {
                    int maxFactor = Math.max(i,num/i);
                    if (!visited.contains(maxFactor)){
                        queue.offer(new int[]{maxFactor, steps + 1});
                        visited.add(maxFactor);
                    }
                }
            }
        }
        return -1;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

