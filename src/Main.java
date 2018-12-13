import java.util.Scanner;

/**
 * Created by Vishal on 12/9/2018.
 */
public class Main {
    private static Boolean palindrome[][];

    public static void main(String[] args) {
        System.out.println("Enter string: ");
        Scanner reader = new Scanner(System.in);
        String s = reader.next();
        System.out.println("Longest palindrome: \"" + longestPalindrome(s) + "\"");
    }

    private static String longestPalindrome(String s) {
        int l = s.length();
        palindrome = new Boolean[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                palindrome[i][j] = (i >= j) ? true : null;
            }
        }
        String longestPalindrome = "";
        for (int i = 0; i < l; i++) {
            String longestPalindromeStartingAtI = longestPalindromeStartingAtI(s, i);
            if (longestPalindromeStartingAtI.length() > longestPalindrome.length()) {
                longestPalindrome = longestPalindromeStartingAtI;
            }
        }
        return longestPalindrome;
    }

    private static String longestPalindromeStartingAtI(String s, int i) {
        for (int j = s.length(); j > i; j--) {
//            System.out.println("[DEBUG] checking string \"" + ss + "\"");
            if (isPalindrome(s.toCharArray(), i, j - 1)) {
                return s.substring(i, j);
            }
        }
        return String.valueOf(s.charAt(i));
    }

    private static boolean isPalindrome(char[] cs, int start, int end) {
//        System.out.println("[DEBUG] checking string \"" + String.valueOf(cs) + "\" with start " + start + " and end " + end);
        if (palindrome[start][end] != null) {
            return palindrome[start][end];
        }
        palindrome[start][end] = (cs[start] == cs[end]) && isPalindrome(cs, start + 1, end - 1);
//        System.out.println("[DEBUG] first check " + ((cs[start] == cs[end]) ? "succeeded" : "failed"));
        return palindrome[start][end];
    }
}
