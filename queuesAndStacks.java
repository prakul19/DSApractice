import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        scanner.close();
        boolean isPalindrome = true;
        int n = sc.length();
        for (int i = 0; i < n / 2; i++) {
            if (sc.charAt(i) != sc.charAt(n - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("The word, " + sc + ", is " + (isPalindrome ? "a palindrome." : "not a palindrome."));
    }
}

