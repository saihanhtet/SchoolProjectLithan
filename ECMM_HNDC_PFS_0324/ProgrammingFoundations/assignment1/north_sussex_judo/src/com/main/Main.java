package com.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classname: Main
 * @version information: 1.0
 * @since 12/04/2024
 * @author Sai Han Htet
 * Description: – To keep tracking the athlete of the North Judo Training Club
 */

public class Main {

  // competitive athlete array list and athlete array list
  private static final ArrayList<CompetitiveAthlete> competitiveAthletes = new ArrayList<>();
  private static final ArrayList<Athlete> athletes = new ArrayList<>();

  // scanner object
  private static final Scanner input = new Scanner(System.in);

  /**
   * This method is used to check whether the user is already registered or not based on username.
   * @return boolean
   */
  public static boolean isUserRegistered(String username) {
    username = username.toLowerCase();
    // search in competitive athlete first
    for (CompetitiveAthlete c_user : competitiveAthletes) {
      if (c_user.getName().toLowerCase().equals(username)) {
        return true;
      }
    }
    // search user in athlete class
    for (Athlete a_user : athletes) {
      if (a_user.getName().toLowerCase().equals(username)) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method return the athlete object based on the username
   * @return Object Athlete/CompetitiveAthlete
   */
  public static Object getUserByName(String username) {
    username = username.toLowerCase();
    // search in competitive athlete first
    for (CompetitiveAthlete c_user : competitiveAthletes) {
      if (c_user.getName().toLowerCase().equals(username)) {
        return c_user;
      }
    }
    // search user in athlete class
    for (Athlete a_user : athletes) {
      if (a_user.getName().toLowerCase().equals(username)) {
        return a_user;
      }
    }
    return new Athlete();
  }

  /**
   * This is the welcome message method.
   */
  public static void welcomeMessage() {
    OutputUtil.printLine();
    OutputUtil.printInfo(
      "Welcome to the North Sussex Judo Training Cost Calculation Program!"
    );
    OutputUtil.printLine();
  }

  /**
   * This method get the username from console input.
   * @return String
   */
  public static String getUsername() {
    String username;
    while (true) {
      OutputUtil.printNormal("Please enter name: ", "");
      username = input.next();
      // Check if the input contains only letters
      if (!username.matches("[a-zA-Z]+")) {
        OutputUtil.printWarning("Please enter letters only!");
      } else {
        if (!isUserRegistered(username)) {
          break;
        } else {
          OutputUtil.printWarning("User already existed!");
          displayUserInfo(username);
          System.out.println(); // separate line
        }
      }
    }
    return username;
  }

  /**
   * This method used to display the user information.
   *
   * @param username
   */
  public static void displayUserInfo(String username) {
    OutputUtil.printLine("-");
    OutputUtil.printInfo("User Information");
    OutputUtil.printLine("-");
    Object user = getUserByName(username);

    if (user instanceof Athlete athlete) {
      ArrayList<String> info = athlete.getAthleteInfo();
      // loop each athlete information for each and display it
      for (String i : info) {
        System.out.println(i);
      }
      OutputUtil.printLine();
    }
  }

  /**
   * This method is used to select the training plan.
   *
   * @return TrainingPlan object
   */
  public static TrainingPlan selectTrainingPlan() {
    while (true) {
      OutputUtil.printInfo(
        "Please select the Training Plan below (enter only number):"
      );
      System.out.println(); // separate line
      OutputUtil.printInfo("1. Beginner Plan : $ 25.00");
      OutputUtil.printInfo("2. Intermediate Plan : $ 30.00");
      OutputUtil.printInfo("3. Elite Plan : $ 35.00");
      System.out.println(); // separate line
      OutputUtil.printWarning("Enter 1 or 2 or 3 only.");
      OutputUtil.printNormal("Enter your plan: ", "");
      // error handling started
      try {
        int trainingPlanInput = input.nextInt();
        switch (trainingPlanInput) {
          case 1:
            OutputUtil.printSuccess("You have selected the Beginner Plan.");
            return TrainingPlan.BEGINNER;
          case 2:
            OutputUtil.printSuccess("You have selected Intermediate Plan.");
            return TrainingPlan.INTERMEDIATE;
          case 3:
            OutputUtil.printSuccess("You have selected Elite Plan.");
            return TrainingPlan.ELITE;
          default:
            OutputUtil.printSuccess("Please choose 1 to 3 only.");
        }
      } catch (Exception e) {
        OutputUtil.printWarning("Please enter number only.");
        input.nextLine(); // Consume the invalid input
      }
    }
  }

  /**
   * this method is for asking athlete to enter their current weight.
   *
   * @return double
   */
  public static double enterCurrentWeight() {
    while (true) {
      OutputUtil.printNormal("Please enter your current weight: ", "");
      try {
        return Double.parseDouble(input.next());
      } catch (NumberFormatException e) {
        OutputUtil.printWarning("Please enter a valid weight (numeric value).");
      }
    }
  }

  /**
   * This method is for asking athlete to select private coaching or not.
   *
   * @return private coaching hours in number format
   */
  public static int selectPrivateCoaching() {
    while (true) {
      OutputUtil.printInfo("Rule: maximum private coaching hours is 5 hours.");
      OutputUtil.printInfo("Cost: $9 dollar for an hour.");
      System.out.println(); // separte line
      OutputUtil.printNormal(
        "Do you want to take the private coaching? (yes/no): ",
        ""
      );
      String answer = input.next();
      if (answer.toLowerCase().startsWith("y")) {
        OutputUtil.printInfo(
          "Ok then, How many hours would you like for private coaching?"
        );
        OutputUtil.printNormal("Enter hours: ", "");
        try {
          int privateCoachingHours = input.nextInt();
          if (privateCoachingHours > 0 && privateCoachingHours <= 20) {
            return privateCoachingHours;
          } else if (privateCoachingHours > 20) {
            OutputUtil.printDanger("Athlete can only received ", "");
            OutputUtil.printDanger("maximum 20 hours of private coaching.");
          } else {
            OutputUtil.printWarning(
              "Please enter a valid number between 1 to 20."
            );
          }
        } catch (Exception e) {
          OutputUtil.printWarning("Please enter only the number.");
        }
      } else if (answer.toLowerCase().startsWith("n")) {
        break;
      } else {
        OutputUtil.printWarning("Please enter only Yes/No");
      }
    }
    return 0;
  }

  /**
   * This method is used to ask athlete has willing for competition
   * @return boolean
   */
  public static boolean willingForCompetition() {
    boolean flag = false;
    while (true) {
      OutputUtil.printInfo(
        "The entry fee for one competition will cost $22 dollar."
      );
      OutputUtil.printNormal(
        "Do you want to enter the competition? (yes/no): ",
        ""
      );
      String answer = input.next();
      if (answer.toLowerCase().startsWith("y")) {
        flag = true;
      }
      break;
    }
    return flag;
  }

  /**
   * This method is used to select the competition weight type
   * @return the competition weight type (String)
   */
  public static String selectCompetitionWeightCategory() {
    while (true) {
      OutputUtil.printInfo("Please choose the weight category from below:");
      OutputUtil.printLine("-");
      OutputUtil.printInfo("1. Heavyweight : Unlimited (over 100) kg");
      OutputUtil.printInfo("2. Light-Heavyweight : 100 kg");
      OutputUtil.printInfo("3. Middleweight : 90 kg");
      OutputUtil.printInfo("4. Light-Middleweight : 81 kg");
      OutputUtil.printInfo("5. Lightweight : 73 kg");
      OutputUtil.printInfo("6. Flyweight : 66 kg");

      OutputUtil.printNormal("Enter your competition weight category: ", "");
      try {
        int chosenIntWeightCategory = input.nextInt();
        // check if the input is valid
        switch (chosenIntWeightCategory) {
          case 1:
            return "Heavyweight";
          case 2:
            return "Light-Heavyweight";
          case 3:
            return "Middleweight";
          case 4:
            return "Light-Middleweight";
          case 5:
            return "Lightweight";
          case 6:
            return "Flyweight";
          default:
            OutputUtil.printWarning("Please enter a number between 1 to 6");
        }
      } catch (Exception e) {
        OutputUtil.printWarning("Please enter a valid number.");
        input.nextLine(); // consume the newline character
      }
    }
  }

  /**
   * This method is used to add a competitive athlete to the system
   *
   * @param athleteName
   * @param trainingPlan
   * @param currentWeight
   * @param privateCoachingHours
   * @param willingForCompetition
   * @param noOfCompetitions
   * @param competitionWeightCategory
   */
  public static void addCompetitiveAthlete(
    String athleteName,
    TrainingPlan trainingPlan,
    double currentWeight,
    int privateCoachingHours,
    boolean willingForCompetition,
    int noOfCompetitions,
    String competitionWeightCategory
  ) {
    CompetitiveAthlete user = new CompetitiveAthlete(
      athleteName,
      trainingPlan,
      currentWeight
    );
    // Set additional attributes for competition
    user.setCompetitionsEntered(noOfCompetitions);
    user.setCompetitionWeightCategory(competitionWeightCategory);
    user.setPrivateCoachingHours(privateCoachingHours);
    competitiveAthletes.add(user);

    displayUserInfo(user.getName());
    OutputUtil.printInfo(
      "You have successfully added a new competitive athlete to the list of athletes."
    );
  }

  /**
   * This method is used to add a new athlete to the list of athletes
   *
   * @param athleteName
   * @param trainingPlan
   * @param currentWeight
   * @param privateCoachingHours
   * @param willingForCompetition
   */
  public static void addAthlete(
    String athleteName,
    TrainingPlan trainingPlan,
    double currentWeight,
    int privateCoachingHours,
    boolean willingForCompetition
  ) {
    if (willingForCompetition) {
      int noOfCompetitions;
      String competitionWeightCategory;
      while (true) {
        OutputUtil.printInfo(
          "Ok, then how many competitions would you like to participate in this month?"
        );
        OutputUtil.printNormal("Enter competition number: ", "");
        try {
          noOfCompetitions = input.nextInt();
          if (noOfCompetitions > 0) {
            competitionWeightCategory = selectCompetitionWeightCategory();
            break;
          } else {
            OutputUtil.printWarning("Please enter a valid number.");
          }
        } catch (Exception e) {
          OutputUtil.printWarning("Please enter a valid number.");
          input.nextLine();
        }
      }
      addCompetitiveAthlete(
        athleteName,
        trainingPlan,
        currentWeight,
        privateCoachingHours,
        willingForCompetition,
        noOfCompetitions,
        competitionWeightCategory
      );
    } else {
      Athlete user = new Athlete(athleteName, trainingPlan, currentWeight);
      // Set additional attributes for private coaching
      user.setPrivateCoachingHours(privateCoachingHours);
      athletes.add(user);
      displayUserInfo(user.getName());
      OutputUtil.printInfo(
        "You have successfully added a new competitive athlete to the list of athletes."
      );
    }
    OutputUtil.printLine();
  }

  /**
   * This method is used to ask the user if he/she wants to quit the program
   * @return true if the user wants to quit, false otherwise
   */
  public static boolean wantToQuit() {
    OutputUtil.printDanger("Do you want to quit? (Y/N): ", "");
    String answer = input.next();
    return answer.toLowerCase().startsWith("y");
  }

  /**
   * This method is for demo users data
   */
  public static void demoData() {
    CompetitiveAthlete user1 = new CompetitiveAthlete(
      "Lucy",
      TrainingPlan.ELITE,
      70
    );
    CompetitiveAthlete user2 = new CompetitiveAthlete(
      "Nick",
      TrainingPlan.INTERMEDIATE,
      68
    );
    CompetitiveAthlete user3 = new CompetitiveAthlete(
      "Peter",
      TrainingPlan.ELITE,
      110
    );
    Athlete user4 = new Athlete("John", TrainingPlan.BEGINNER, 70.0);
    Athlete user5 = new Athlete("Alice", TrainingPlan.INTERMEDIATE, 65.0);
    Athlete user6 = new Athlete("Bob", TrainingPlan.ELITE, 80.0);

    user1.setCompetitionsEntered(2);
    user1.setCompetitionWeightCategory("Middleweight");
    user1.setPrivateCoachingHours(3);
    user2.setCompetitionsEntered(2);
    user2.setCompetitionWeightCategory("LightWeight");
    user2.setPrivateCoachingHours(2);
    user3.setCompetitionsEntered(3);
    user3.setCompetitionWeightCategory("HeavyWeight");
    user3.setPrivateCoachingHours(5);

    // add user1 to 3 to competitive athlete list and user4 to 6 to normal athlete list
    competitiveAthletes.add(user1);
    competitiveAthletes.add(user2);
    competitiveAthletes.add(user3);
    athletes.add(user4);
    athletes.add(user5);
    athletes.add(user6);
  }

  public static void main(String[] args) {
    // add demo data
    demoData();
    // loop the program for infinite adding user
    while (true) {
      // display the welcome message
      welcomeMessage();

      // call get username method to ask the athlete his/her name
      String athleteName = getUsername();
      System.out.println(); // to seprate the output

      // call the select training method to ask the athlete which training plan he/she want
      TrainingPlan trainingPlan = selectTrainingPlan();
      System.out.println(); // to seprate the output

      // call the enter current weight method to ask the athlete his/her current weight
      double currentWeight = enterCurrentWeight();
      System.out.println(); // to seprate the output

      // call the select private coaching method to ask the athlete how many private coaching hours he/she want
      int privateCoachingHours = selectPrivateCoaching();
      System.out.println(); // to seprate the output

      // check the athlete has willing for competition and if he/she is not in beginner plan
      boolean willing = false;
      if (!trainingPlan.getName().equalsIgnoreCase("beginner")) {
        willing = willingForCompetition();
      }
      // add the new athlete to the list
      addAthlete(
        athleteName,
        trainingPlan,
        currentWeight,
        privateCoachingHours,
        willing
      );

      System.out.println(); // to seprate the output

      // ask if the user want to quit
      if (wantToQuit()) {
        OutputUtil.printLine();
        OutputUtil.printSuccess(
          "Thanks for using the North Sussex Judo Program."
        );
        OutputUtil.printLine();
        break;
      }
    }
  }
}
