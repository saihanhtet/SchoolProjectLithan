public class Bolt {

  public static void main(String[] args) {
    String carType = "track";

    String[] cars = { "luxury", "normal", "track" };

    boolean found = false;
    for (int i = 0; i < cars.length; i++) {
      String car = cars[i];
      if (car.equals(carType)) {
        found = true;
        break;
      }
    }

    if (found) {
      System.out.printf("You choose the %s car.", carType);
    } else {
      System.out.println("You choose a normal car");
    }
    int row = 10, column = 10;
    int[][] grades = new int[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        System.out.println(grades[i][j] + " ");
      }
    }
  }
}
