import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        HashSet<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=0;i<n;i++){
            String s1 = sc.next();
            String s2 = sc.next();
            String s = s1 + " " + s2;
            set.add(s);
            System.out.println(set.size());
        }
    }
}
