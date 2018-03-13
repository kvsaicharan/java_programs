import java.util.*;
import java.util.regex.*;

class longPalindrome{
  public static void main(String[] args) {
    longPalindrome prac = new longPalindrome();
    String str = "agbdba";
    System.out.println(prac.longestPalindrome(str));
  }

    public String longestPalindrome(String str) {

    int n = str.length();
    StringBuilder sb = new StringBuilder("");
    int[][] T = new int[n][n];
    for (int i = 0 ; i < n; i++){
      T[i][i] = 1;
    }
    for(int l = 2; l <= n; l++){
    for(int i = 0 ; i <= n-l; i++){
      int j = i+l-1;
      if(l == 2 && str.charAt(i) == str.charAt(j)){

                    T[i][j] = 2;
                    sb.append(str.charAt(i-1));
                }
      else if(str.charAt(i) == str.charAt(j)){
                    if(T[i + 1][j-1]==1) sb.append(str.charAt(i+1));
                    T[i][j] = T[i + 1][j-1] + 2;
                    sb.setCharAt(0,str.charAt(i));
                    sb.append(str.charAt(i));
                }
      else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
    }
  }
  return sb.toString();
}
}
