package com.main;

import java.util.ArrayList;

/**
 * Classname: Athlete
 * Version information: 1.0
 * Date: 12/04/2024
 * Author: Sai Han Htet
 */
public class Athlete implements CostCalculator {

  protected String name;
  protected TrainingPlan trainingPlanDetails;
  protected double currentWeight;
  protected String competitionWeightCategory;
  protected int competitionEnter;
  protected int privateCoachingHours;

  public Athlete(String name, TrainingPlan trainingPlan, double currentWeight) {
    this.name = name;
    this.trainingPlanDetails = trainingPlan;
    this.currentWeight = currentWeight;
  }

  public Athlete() {}

  public String getName() {
    return name;
  }

  public TrainingPlan getTrainingPlan() {
    return trainingPlanDetails;
  }

  public double getCurrentWeight() {
    return currentWeight;
  }

  public String getCompetitionWeightCategory() {
    return competitionWeightCategory;
  }

  public int getCompetitionsEntered() {
    return competitionEnter;
  }

  public int getPrivateCoachingHours() {
    return privateCoachingHours;
  }

  public void setCompetitionWeightCategory(String competitionWeightCategory) {
    this.competitionWeightCategory = competitionWeightCategory;
  }

  public void setCompetitionsEntered(int competitionEnter) {
    this.competitionEnter = competitionEnter;
  }

  public void setPrivateCoachingHours(int privateCoachingHours) {
    this.privateCoachingHours = privateCoachingHours;
  }

  /**
   * This method calculate the training plan cost for an month that athlete chose.
   * @return double
   */
  public double calculateTrainingCost() {
    double trainingCost = 0;
    if (trainingPlanDetails != null) {
      trainingCost = trainingPlanDetails.getWeeklyFee() * 4; // Weekly fee * 4 weeks
    }
    return trainingCost;
  }

  /**
   * This method calculate the private coaching cost based on the hour that athlete taken.
   * @return double
   */
  public double calculatePrivateCoachingCost() {
    double coachingCost = 0;
    if (privateCoachingHours > 0 && privateCoachingHours <= 5) {
      coachingCost = privateCoachingHours * 9.00; // per hour private coaching cost
    }
    return coachingCost;
  }

  @Override
  public double calculateCost() {
    return calculateTrainingCost() + calculatePrivateCoachingCost();
  }

  /**
   * This method return the information of the current athlete
   * @return ArrayList - String
   */
  public ArrayList<String> getAthleteInfo() {
    ArrayList<String> information = new ArrayList<>();
    information.add("Athlete Name: " + name);
    information.add("Training Plan: " + trainingPlanDetails.getName());
    information.add("Current Weight: " + currentWeight + " kg");
    information.add("Private Coaching Hours: " + privateCoachingHours);
    information.add(
      "Training Cost: $" + String.format("%.2f", calculateTrainingCost())
    );
    information.add(
      "Private Coaching Cost: $" +
      String.format("%.2f", calculatePrivateCoachingCost())
    );
    information.add("Total Cost: $" + String.format("%.2f", calculateCost()));
    return information;
  }
}
