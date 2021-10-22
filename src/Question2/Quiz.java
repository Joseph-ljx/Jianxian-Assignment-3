package Question2;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

  ArrayList<Question> list = new ArrayList<Question>(); // All questions
  ArrayList<Question> selectedList =
      new ArrayList<Question>(); // Selected questions within the complexity range
  ArrayList<String> candidateAnswer = new ArrayList<String>(); // Candidate answer by the user
  Scanner sc = new Scanner(System.in);

  /**
   * Add a new question to the quiz
   *
   * @param query Question
   * @param result Correct Answer
   * @param complexity Complexity
   */
  public void addQuestion(String query, String result, int complexity) {
    if (this.list.size() >= 25) {
      System.out.println("25 questions now, no more questions allowed");
    } else {
      Question q = new Question(query, result);
      q.setComplexity(complexity); //set its complexity
      list.add(q); //add this question to the list
    }
  }

  /** Quiz Selection */
  public void quizChoice() {
    System.out.println("1 - All questions");
    System.out.println("2 - Base on complexity");
    System.out.print("Want a quiz with all questions or based on complexity? : ");
    int choice = sc.nextInt();
    switch (choice) {
      case 1:
        this.giveQuiz();
        break;
      case 2:
        System.out.print("Please input the MIN complexity: ");
        int minComplexity = sc.nextInt();
        System.out.print("Please input the MAX complexity: ");
        int maxComplexity = sc.nextInt();
        this.giveQuiz(minComplexity, maxComplexity);
        break;
    }
  }

  /** Present all the questions in the quiz */
  public void presentQuestions() {
    for (int i = 0; i < list.size(); i++) {
      System.out.println("Question" + (i + 1) + ": ");
      System.out.println(list.get(i).getQuestion());
    }
  }

  /** Give a quiz contains all the questions No matter what its complexity is */
  public void giveQuiz() {
    for (int i = 0; i < list.size(); i++) {
      this.selectedList.add(list.get(i));
      System.out.println("Question" + (i + 1) + ": ");
      System.out.println(list.get(i).getQuestion());
      System.out.println("Please input your answer: ");
      String answer = sc.next();
      candidateAnswer.add(answer);
    }
  }

  /**
   * Give quiz based on min and max complexity
   *
   * @param minComplexity Min complexity
   * @param maxComplexity Max complexity
   */
  public void giveQuiz(int minComplexity, int maxComplexity) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getComplexity() >= minComplexity
          && list.get(i).getComplexity() <= maxComplexity) { // question in the range of complexity
        this.selectedList.add(list.get(i)); // add to the selected list
        System.out.println("Question: " + (i + 1) + ": ");
        System.out.println(list.get(i).getQuestion()); // Show the question
        System.out.println("Please input your answer: ");
        String answer = sc.next();
        candidateAnswer.add(answer); // add the answer to the candidate answer list
      } else {
        continue; // go for the next question: could be omitted
      }
    }
  }

  /** Verify the questions */
  public void verifyQuestions() {
    System.out.println(" ");
    System.out.println("Your answers for the Quiz are: ");
    for (int i = 0; i < selectedList.size(); i++) {
      System.out.print("Question " + (i + 1) + ": ");
      System.out.println(selectedList.get(i).getQuestion());
      System.out.println("Correct Answer: " + selectedList.get(i).getAnswer());
      System.out.print("Your Answer is: " + this.candidateAnswer.get(i) + ", Status: ");
      if (selectedList
          .get(i)
          .answerCorrect(candidateAnswer.get(i))) { // if the candidate answer matches the answer
        System.out.println("Correct! ");
      } else { // if not match
        System.out.println("Wrong! ");
      }
      System.out.println(" ");
    }
  }
}
