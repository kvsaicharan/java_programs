import java.util.*;

class MaxWithoutComparison{
  public static void main(String[] args) {
    int x = 10, y= 20;
    int c = x - y;
    int k = (c >> 31) & 1;
    int max = x - k*c;
    int min = y + k*c;
    System.out.println(max);
    System.out.println(min);

    //--------------------------------------------

    int a = 10, b = 20;
    int c1 = Math.abs(a-b);
    int min1 = (a+b)/2 - c1/2 ;
    int max1 = (a+b)/2 + c1/2 ;
    System.out.println(max1);
    System.out.println(min1);

  }
}
