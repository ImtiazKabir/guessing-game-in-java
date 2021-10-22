import javax.swing.JOptionPane;
import java.util.Random;

public class GuessingGame {
  public static void main(String[] args) {
    int num = new Random().nextInt(100) + 1;
    System.out.println("The correct guess would be " + num); //! DEBUG

    int guess = 0;
    String title = "Guessing Game";
    String prompt = "Enter a guess between 1 and 100";

    for (int count = 1; guess!=num; count++) {
      String response = JOptionPane.showInputDialog(
        null, prompt, title, JOptionPane.QUESTION_MESSAGE
      );
      guess = Integer.parseInt(response);
      String status = getStatus(guess, num, count);
      JOptionPane.showMessageDialog(null, status);
    }
  }

  public static String getStatus(int guess, int num, int count) {
    if (guess < 1 || guess > 100) return "Your guess is invalid";

    String msg = "You guessed " + count + " time(s)";
    if (guess==num) return "Correct!\n" + msg;
    else if (guess<num) return "Your guess is too low, try again.\n" + msg;
    else return "Your guess is too high, try again.\n" + msg;
  }
}
