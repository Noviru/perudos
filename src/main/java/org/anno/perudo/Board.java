package main.java.org.anno.perudo;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

public class Board extends JFrame {
    private static int NUM_PLAYERS = 4;
    private ArrayList<Player> players = new ArrayList<>();
    public GameController gc = new GameController(players);
    public Board() {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            Player p = new Player(5,i);
            players.add(p);
        }

        createBoard();
    }
    private void createBoard() {
        setTitle("Testing");
        setSize(500, 500);
        setLayout(new GridLayout(2, 2));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        for (Player p: players) {
            PlayerFrame playerFrame = new PlayerFrame(p, this);
            add(playerFrame);
        }

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));  // Use GridLayout to arrange the labels vertically

        // Create labels for the current dice value and the current guess
        JLabel currentDiceLabel = new JLabel("Current Dice: " + gc.getCurrentDice(), SwingConstants.CENTER);  // Default text for dice
        JLabel currentGuessLabel = new JLabel("Current Guess: " + gc.getCurrentGuess(), SwingConstants.CENTER);  // Default text for guess

        currentDiceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        currentGuessLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Add the labels to the center panel
        centerPanel.add(currentDiceLabel);
        centerPanel.add(currentGuessLabel);

        // Add the center panel to the center section of the frame
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);


    }

    public GameController getGameController() {
        return gc;
    }




}

