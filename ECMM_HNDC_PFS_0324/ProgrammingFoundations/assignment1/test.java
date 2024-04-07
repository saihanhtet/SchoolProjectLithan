package assignment1;

public class test {

  public static void main(String[] args) {
    int res = puzzle(22, 11);
    System.out.println(res);
  }

  public static int lastDigit(int num) {
    int res1 = (int) Math.floor(num);
    int res2 = Math.abs(num % 10);
    int res3 = num / 10;
    int res4 = num % 10;
    System.out.println(res1 + " " + res2 + " " + res3 + " " + res4);
    return res4; // Return the last digit
  }

  public static String makeFancy(String s) {
    if (s.length() == 0) {
      return "*";
    }
    return "*" + s.substring(0, 1) + makeFancy(s.substring(0, s.length() - 1));
  }

  public static int puzzle(int i, int j) {
    if (i == j) {
      return 0;
    } else {
      return 1 + puzzle(i - 2, j - 1);
    }
  }
}
