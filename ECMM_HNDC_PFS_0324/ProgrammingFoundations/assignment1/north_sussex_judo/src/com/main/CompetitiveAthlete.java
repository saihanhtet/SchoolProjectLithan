package com.main;

import java.util.ArrayList;

/**
 * Classname: Athlete
 * Version information: 1.0
 * Date: 12/04/2024
 * Author: Sai Han Htet
 */
class CompetitiveAthlete extends Athlete {

  public CompetitiveAthlete(
    String name,
    TrainingPlan trainingPlan,
    double currentWeight
  ) {
    super(name, trainingPlan, currentWeight);
  }

  /**
   * This method calculate the competition cost of the athlete
   * @return double
   */
  public double calculateCompetitionCost() {
    double competitionCost = 0;
    if (
      trainingPlanDetails
        .getName()
        .toLowerCase()
        .equalsIgnoreCase("intermediate") ||
      trainingPlanDetails.getName().toLowerCase().equalsIgnoreCase("elite")
    ) {
      competitionCost = competitionEnter * 22.00; // competition entry fee
    }
    return competitionCost;
  }

  /**
   * This method compare the current weight of the athlete to the weight category of the competition
   * @return String
   */
  public String compareWeightToCategory() {
    double currentWeight = getCurrentWeight();
    switch (competitionWeightCategory.toLowerCase()) {
      case "heavyweight":
        if (currentWeight > 100) {
          return "Above Heavyweight";
        } else if (currentWeight >= 100) {
          return "Within Heavyweight";
        } else {
          return "Below Heavyweight";
        }
      case "light-heavyweight":
        if (currentWeight > 100) {
          return "Above Light-Heavyweight";
        } else if (currentWeight >= 100) {
          return "Within Light-Heavyweight";
        } else {
          return "Below Light-Heavyweight";
        }
      case "middleweight":
        if (currentWeight > 90) {
          return "Above Middleweight";
        } else if (currentWeight >= 90) {
          return "Within Middleweight";
        } else {
          return "Below Middleweight";
        }
      case "light-middleweight":
        if (currentWeight > 81) {
          return "Above Light-Middleweight";
        } else if (currentWeight >= 81) {
          return "Within Light-Middleweight";
        } else {
          return "Below Light-Middleweight";
        }
      case "lightweight":
        if (currentWeight > 73) {
          return "Above Lightweight";
        } else if (currentWeight >= 73) {
          return "Within Lightweight";
        } else {
          return "Below Lightweight";
        }
      case "flyweight":
        if (currentWeight > 66) {
          return "Above Flyweight";
        } else if (currentWeight >= 66) {
          return "Within Flyweight";
        } else {
          return "Below Flyweight";
        }
      default:
        return "Unknown Category";
    }
  }

  @Override
  public double calculateCost() {
    return (super.calculateCost() + calculateCompetitionCost());
  }

  @Override
  public ArrayList<String> getAthleteInfo() {
    ArrayList<String> information = super.getAthleteInfo();
    information.add("Competitions Enter this Month: " + competitionEnter);
    information.add(
      "Competition Cost: $" + String.format("%.2f", calculateCompetitionCost())
    );
    information.add("Weight Category Comparison: " + compareWeightToCategory());
    return information;
  }
}
