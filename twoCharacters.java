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
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int alternate(String s) {
        Set<Character> chars = new HashSet<>();
        for (char c:s.toCharArray()) {
            chars.add(c);
        }
        List<Character> list = new ArrayList<>(chars);
        int maxLength=0;
        for (int i=0;i<list.size();i++) {
            for (int j = i+1;j<list.size();j++){
                char first=list.get(i);
                char second= list.get(j);
                StringBuilder filterString = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == first||c==second) {
                        filterString.append(c);
                    }
                }
                if (isValidString(filterString.toString())) {
                    maxLength = Math.max(maxLength, filterString.length());
                }
            }
        }
        return maxLength;
    }
    private static boolean isValidString(String str) {
        for (int i = 0; i<str.length()-1;i++) {
            if (str.charAt(i) ==str.charAt(i+ 1)) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

