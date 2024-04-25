package com.main;

public class OutputUtil {

  public static void printInfo(String message, String end) {
    System.out.print(ColoredIO.CYAN + message + end + ColoredIO.RESET);
  }

  public static void printDanger(String message, String end) {
    System.out.print(ColoredIO.RED + message + end + ColoredIO.RESET);
  }

  public static void printSuccess(String message, String end) {
    System.out.print(ColoredIO.GREEN + message + end + ColoredIO.RESET);
  }

  public static void printNormal(String message, String end) {
    System.out.print(ColoredIO.RESET + message + end + ColoredIO.RESET);
  }

  public static void printWarning(String message, String end) {
    System.out.print(ColoredIO.YELLOW + message + end + ColoredIO.RESET);
  }

  public static void printLine(String sign) {
    System.out.println(sign.repeat(30));
  }

  // Overloaded method with default sign
  public static void printLine() {
    printLine("=");
  }

  public static void printInfo(String message) {
    printInfo(message, "\n");
  }

  public static void printDanger(String message) {
    printInfo(message, "\n");
  }

  public static void printSuccess(String message) {
    printInfo(message, "\n");
  }

  public static void printNormal(String message) {
    printInfo(message, "\n");
  }

  public static void printWarning(String message) {
    printWarning(message, "\n");
  }
}
