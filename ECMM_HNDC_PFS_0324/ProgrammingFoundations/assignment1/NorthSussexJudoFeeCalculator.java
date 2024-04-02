package ECMM_HNDC_PFS_0324.ProgrammingFoundations.assignment1;

class Athlete {

  // declaring the necessary variables
  private String athleteName;
  private String trainingPlan;
  private double currentWeight;
  private String competitionWeightCategory;
  private int competitionEntered;
  private int privateCoachingHours;

  // getters and setters
  public String getAthleteName() {
    return athleteName;
  }

  public void setAthleteName(String athleteName) {
    this.athleteName = athleteName;
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

  public int getCompetitionEntered() {
    return competitionEntered;
  }

  public void setCompetitionEntered(int competitionEntered) {
    this.competitionEntered = competitionEntered;
  }

  public int getPrivateCoachingHours() {
    return privateCoachingHours;
  }

  public void setPrivateCoachingHours(int privateCoachingHours) {
    this.privateCoachingHours = privateCoachingHours;
  }

  /**
   * Constructs an Athlete object with the provided details.
   *
   * @param athleteName                 The name of the athlete.
   * @param trainingPlan                The training plan chosen by the athlete.
   * @param currentWeight               The current weight of the athlete in kilograms.
   * @param competitionWeightCategory   The weight category for competitions.
   * @param competitionsEntered         The number of competitions entered by the athlete this month.
   * @param privateCoachingHours        The number of hours of private coaching received by the athlete.
   */
  public Athlete(
    String athleteName,
    String trainingPlan,
    double currentWeight,
    String competitionWeightCategory,
    int competitionsEntered,
    int privateCoachingHours
  ) {
    this.athleteName = athleteName;
    this.trainingPlan = trainingPlan;
    this.currentWeight = currentWeight;
    this.competitionWeightCategory = competitionWeightCategory;
    this.competitionEntered = competitionsEntered;
    this.privateCoachingHours = privateCoachingHours;
  }

  /**
   * Calculates the training cost based on the training plan the athlete chose.
   *
   * @return The calculated training cost.
   */
  public double calculateTrainingCost() {
    double trainingCost = 0;
    // calculate the training cost by the training plan
    switch (trainingPlan.toLowerCase()) {
      case "beginner":
        trainingCost = 25.00 * 4; // a month consists of four weeks.
        break;
      case "intermediate":
        trainingCost = 30.00 * 4;
        break;
      case "elite":
        trainingCost = 35.00 * 4;
        break;
    }
    return trainingCost;
  }

  /**
   *
   * @return The calculated competition cost.
   */
  public double calculateCompetitionCost() {
    double competitionCost = 0;
    return competitionCost;
  }
}

public class NorthSussexJudoFeeCalculator {}
