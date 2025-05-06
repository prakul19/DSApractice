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

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

  public static int hourglassSum(List<List<Integer>> arr){
    int max_hourglass_sum = Integer.MIN_VALUE;
    for(int row = 0; row < 4; row++){
        for(int column = 0; column < 4; column++) {
            int hourglassSum = arr.get(row).get(column) + arr.get(row).get(column + 1) + arr.get(row).get(column + 2) + arr.get(row + 1).get(column + 1)
+ arr.get(row + 2).get(column) + arr.get(row + 2).get(column + 1) + arr.get(row + 2).get(column + 2);
            max_hourglass_sum = Math.max(max_hourglass_sum, hourglassSum);
        }
    }
    return max_hourglass_sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

