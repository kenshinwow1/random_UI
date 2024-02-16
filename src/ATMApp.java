import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class NumberGuessingGameGUI extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel statusLabel;
    private JLabel attemptsLabel;

    private int lowerBound = 1;
    private int upperBound = 100;
    private int numberToGuess;
    private int attempts = 5;
    private int remainingAttempts;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        guessField = new JTextField();
        guessButton = new JButton("Guess");
        statusLabel = new JLabel("");
        attemptsLabel = new JLabel("Attempts remaining: " + attempts);

        add(new JLabel("Guess the number between " + lowerBound + " and " + upperBound));
        add(guessField);
        add(guessButton);
        add(statusLabel);
        add(attemptsLabel);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        startNewGame();
    }

    private void startNewGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        remainingAttempts = attempts;
        statusLabel.setText("");
        attemptsLabel.setText("Attempts remaining: " + remainingAttempts);
        guessField.setText("");
    }

    private void checkGuess() {
        String guessText = guessField.getText();
        int guess;

        try {
            guess = Integer.parseInt(guessText);
        } catch (NumberFormatException ex) {
            statusLabel.setText("Invalid input. Please enter a number.");
            return;
        }

        if (guess < lowerBound || guess > upperBound) {
            statusLabel.setText("Guess out of range. Please enter a number between " + lowerBound + " and " + upperBound);
            return;
        }

        remainingAttempts--;

        if (guess == numberToGuess) {
            statusLabel.setText("Congratulations! You guessed the correct number: " + numberToGuess);
            guessButton.setEnabled(false);
        } else if (guess < numberToGuess) {
            statusLabel.setText("Too low! Try again.");
        } else {
            statusLabel.setText("Too high! Try again.");
        }

        if (remainingAttempts <= 0) {
            statusLabel.setText("Sorry, you have used all your attempts. The number was: " + numberToGuess);
            guessButton.setEnabled(false);
        }

        attemptsLabel.setText("Attempts remaining: " + remainingAttempts);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGameGUI().setVisible(true);
            }
        });
    }
}
