package com.main;

/**
 * Classname: Athlete
 * Version information: 1.0
 * Date: 12/04/2024
 * Author: Sai Han Htet
 */
public class TrainingPlan {

  private final String trainingPlan;
  private final double weeklyFee;

  // Default training plans
  public static final TrainingPlan BEGINNER = new TrainingPlan(
    "Beginner",
    25.00
  );
  public static final TrainingPlan INTERMEDIATE = new TrainingPlan(
    "Intermediate",
    30.00
  );
  public static final TrainingPlan ELITE = new TrainingPlan("Elite", 35.00);

  public String getTrainingPlan() {
    return trainingPlan;
  }

  
  public TrainingPlan(String trainingPlan, double weeklyFee) {
    this.trainingPlan = trainingPlan;
    this.weeklyFee = weeklyFee;
  }

  public String getName() {
    return trainingPlan;
  }

  public double getTrainingCost() {
    return weeklyFee * 4; // 1 month has 4 weeks
  }

  public double getWeeklyFee() {
    return weeklyFee;
  }
}
