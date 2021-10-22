package Question2;

public class QuizTime {
  public static void main(String[] args) {
    Quiz a = new Quiz();

    // Set different questions
    a.addQuestion("a>b", "yes", 1);
    a.addQuestion("b>c", "yes", 1);
    a.addQuestion("a>c", "yes", 4);
    a.addQuestion("b>d", "false", 2);
    a.addQuestion("3+5 = 8", "yes", 4);

    // greater than 25 questions is not allowed
//        a.addQuestion("a>b", "yes", 1);
//        a.addQuestion("b>c", "yes", 1);
//        a.addQuestion("a>c", "yes", 4);
//        a.addQuestion("b>d", "false", 2);
//        a.addQuestion("3+5 = 8", "yes", 4);
//        a.addQuestion("a>b", "yes", 1);
//        a.addQuestion("b>c", "yes", 1);
//        a.addQuestion("a>c", "yes", 4);
//        a.addQuestion("b>d", "false", 2);
//        a.addQuestion("3+5 = 8", "yes", 4);
//        a.addQuestion("a>b", "yes", 1);
//        a.addQuestion("b>c", "yes", 1);
//        a.addQuestion("a>c", "yes", 4);
//        a.addQuestion("b>d", "false", 2);
//        a.addQuestion("3+5 = 8", "yes", 4);
//        a.addQuestion("a>b", "yes", 1);
//        a.addQuestion("b>c", "yes", 1);
//        a.addQuestion("a>c", "yes", 4);
//        a.addQuestion("b>d", "false", 2);
//        a.addQuestion("3+5 = 8", "yes", 4);
//        a.addQuestion("a>b", "yes", 1);

    // Start the quiz
    a.quizChoice();

    // verify the result
    a.verifyQuestions();
  }
}
