## Requirement Analysis

### Assignment Brief

- **Course:** Applied Degree in Software Engineering (BDSE)
- **Qualification Name:** Applied Degree in Software Engineering (BDSE)
- **Module Name:** Programming Foundations
- **Assignment:** Assignment 1

### Scenario

- **Company:** AQ Digital Solutions (AQDS)
- **Client:** North Sussex Judo
- **Project:** Develop a program to calculate training fees for athletes.
- **Requirements:**
  - Input: Athlete name, training plan, current weight, competition weight category, competitions entered, optional private coaching hours.
  - Output: Athlete's name, itemized costs, total cost, weight comparison.
  - Additional conditions provided.

### Assignment Tasks

#### Task 1:

1. **Selected Application:** A program to calculate training fees for athletes at North Sussex Judo.
2. **Programming Paradigms:**
   - Procedural: Organizing code as a sequence of procedures or functions. Focuses on the procedures to perform tasks.
   - Object-Oriented: Organizing code around objects that encapsulate data and behavior. Focuses on classes and objects.
   - Event-Driven: Responding to events triggered by user actions or system events. Focuses on event handlers.
3. **Selected Paradigm:** Object-Oriented Programming (OOP) would be suitable for this project. We can use Java for implementation, leveraging its OOP features such as classes, objects, inheritance, and polymorphism.

#### Task 2:

1. **Features of IntelliJ or Eclipse:**
   - Code auto-completion: Helps in writing code faster and with fewer errors.
   - Integrated Debugger: Allows for easier debugging of code, identifying and fixing errors.
   - Version Control Integration: Facilitates collaboration and tracking changes using tools like Git.
   - Refactoring Tools: Simplifies code restructuring, improving code quality and maintainability.
   - Code Navigation: Enables easy traversal through codebase, finding classes, methods, and references quickly.
2. **Advantages of Using an IDE:**
   - Productivity: IDEs provide tools and features that streamline development, improving productivity.
   - Code Quality: IDEs offer built-in code analysis, refactoring, and debugging tools, enhancing code quality.
   - Collaboration: IDEs with version control integration support team collaboration and code sharing.
   - Ease of Use: IDEs provide a user-friendly interface with intuitive features, making development easier for developers of all levels.

### Conclusion

This requirement analysis outlines the project scope, client requirements, and tasks to be accomplished. It sets the stage for developing the program efficiently, leveraging suitable programming paradigms and IDE features for implementation.

### Algorithm

```text
Algorithm for Judo

Start

1. Display the training plan of judo that includes 3 levels with fees.
	(E.g.,
			Beginner - $25.00,
			Intermediate - $30.00,
			Elite - $35.00
	)

2. Display Weight Categories based on Kg.

3. Display other information such as 5 maximum hours of private coaching, and Intermediate and Elite level can only enter competitions, and date of competitions.

4. Show the prompt to user to enter their informations:
	- name
	- training plan which includes 3 levels: Beginner, Intermediate, Elite.
	- current weight in Kg.
	- competition weight category.
	- option to add the numbers of private coaching.

5.  Whether can enter the competition:
	if the training plan not is "Intermediate" or "Elite"
		then display "Beginner level can't enter competition".
	else
		then ask "Do you want to enter competition"
			if yes, fee will be the $22 per competition.(number of  competitions * competition entry fee)
			if no, no competition fee.

6. Calculate the training fees:
	- Calculate the fees based on the chosen training plan.
		- if user chooses "Beginner" the weekly fee will be $25 and for a month it will be $25 * 4
		- if user chooses "Intermediate" the weekly fee will be $30 and for a month it will be $30 * 4
		- if user chooses "Elite" the weekly fee will be $35 and for a month it will be $35 * 4

	- Calculate the addtitional fees for private coaching (optional)
		- if user choose the private coaching the fee will be cost based on the number_of_hours * $9

7. If user input is not valid during the 4 to 6 steps it will return and display the suitable error messages
	- and return to step 1.

8. Output
	- athlete name
	- chosen training plan
	- current weight in kg
	- competition entered in kg
	- competition entered in this month
	- private coaching hours (optional)
	- total cost of training plan, private coaching and others.

9. Repeat the step 1 to 8 for each athletes.

10. Display the Farewell message.

End
```
