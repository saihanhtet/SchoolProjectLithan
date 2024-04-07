import java.util.Scanner;

class Athlete {

  private String name;
  private String trainingPlan;
  private double currentWeight;
  private String competitionWeightCategory;
  private int competitionsEntered;
  private int privateCoachingHours;

  public Athlete(
    String name,
    String trainingPlan,
    double currentWeight,
    String competitionWeightCategory,
    int competitionsEntered,
    int privateCoachingHours
  ) {
    this.name = name;
    this.trainingPlan = trainingPlan;
    this.currentWeight = currentWeight;
    this.competitionWeightCategory = competitionWeightCategory;
    this.competitionsEntered = competitionsEntered;
    this.privateCoachingHours = privateCoachingHours;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTrainingPlan() {
    return trainingPlan;
  }

  public void setTrainingPlan(String trainingPlan) {
    this.trainingPlan = trainingPlan;
  }

  public double getCurrentWeight() {
    return currentWeight;
  }

  public void setCurrentWeight(double currentWeight) {
    this.currentWeight = currentWeight;
  }

  public String getCompetitionWeightCategory() {
    return competitionWeightCategory;
  }

  public void setCompetitionWeightCategory(String competitionWeightCategory) {
    this.competitionWeightCategory = competitionWeightCategory;
  }

  public int getCompetitionsEntered() {
    return competitionsEntered;
  }

  public void setCompetitionsEntered(int competitionsEntered) {
    this.competitionsEntered = competitionsEntered;
  }

  public int getPrivateCoachingHours() {
    return privateCoachingHours;
  }

  public void setPrivateCoachingHours(int privateCoachingHours) {
    this.privateCoachingHours = privateCoachingHours;
  }

  public boolean isValidTrainingPlan() {
    return (
      trainingPlan.equals("beginner") ||
      trainingPlan.equals("intermediate") ||
      trainingPlan.equals("elite")
    );
  }

  /**
   * Input Prompt For Double
   * @param message The message what you want to show beside the input
   * @return double
   */
  public double promptDoubleInput(String message) {
    Scanner scanner = new Scanner(System.in);
    System.out.print(message + " : ");
    double res = scanner.nextDouble();
    scanner.close();
    return res;
  }

  /**
   * Input Prompt For Integer
   * @param message The message what you want to show beside the input
   * @return integer
   */
  public int promptIntegerInput(String message) {
    Scanner scanner = new Scanner(System.in);
    System.out.print(message + " : ");
    int res = scanner.nextInt();
    scanner.close();
    return res;
  }

  /**
   * This function calculate the training cost based on the training plan.
   * @return training cost (double data type)
   */
  public double calculateTrainingCost() {
    double trainingCost = 0;
    switch (trainingPlan.toLowerCase()) {
      case "beginner":
        trainingCost = 25.00 * 4;
        break;
      case "intermediate":
        trainingCost = 30.00 * 4;
      default:
        trainingCost = 35.00 * 4;
        break;
    }
    return trainingCost;
  }

  /**
   * This funtion calculate the competition cost based on the athlete's entered competitions.
   * @return competition cost (double data type)
   */
  public double calculateCompetitionCost() {
    double competitionCost = 0;
    boolean isIntermediate = trainingPlan.equalsIgnoreCase("intermediate");
    boolean isElite = trainingPlan.equalsIgnoreCase("elite");
    // only the intermediate and elite can calculate the competition cost
    if (isIntermediate || isElite) {
      competitionCost = competitionsEntered * 22.00;
    } else {
      System.out.println("Begineer cannot enter the competition.");
    }
    return competitionCost;
  }

  public double calculatePrivateCoachingCost() {
    double coachingCost = 0;
    // check if the private cocahing hours is maximun at 5
    if (privateCoachingHours > 0 && privateCoachingHours <= 5) {
      coachingCost = privateCoachingHours * 9.00;
    } else {
      System.out.println("Private Coaching Hours is maximum at 5 hours.");
    }
    return coachingCost;
  }
}

public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("Hello, World!");
  }
}
