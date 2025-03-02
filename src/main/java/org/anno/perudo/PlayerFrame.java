package main.java.org.anno.perudo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerFrame extends JPanel {
    private Player p;
    private Board b;
    public PlayerFrame(Player p, Board b) {
        this.p = p;
        this.b = b;

        GameController gc = b.getGameController();

        setLayout(new BorderLayout());

        JLabel playerLabel = new JLabel("Player " + p.getId(), SwingConstants.CENTER);

        playerLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(playerLabel, BorderLayout.NORTH);

        // Create a DiceFrame for this player and add it to the center
        DiceFrame diceFrame = new DiceFrame(p);  // Pass player ID
        add(diceFrame, BorderLayout.CENTER);

        if(p.getId() == 0){
            displayHumanHUD();
        }

    }

    private void displayHumanHUD() {
        JButton bluff = new JButton("Bluff");
        bluff.setPreferredSize(new Dimension(60, 30));  // Width 100px, Height 30px

        bluff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message when the button is clicked
                gc.handleBluff();
            }
        });


        // Dropdown numebrs
        String[] diceNumbers = {"1", "2", "3", "4", "5", "6"};
        JComboBox<String> diceSelection = new JComboBox<>(diceNumbers);

        // Place guess, TODO check if guess valid aswell
        JTextField diceCountField = new JTextField(3);  // Allow 3 characters for number input
        diceCountField.setPreferredSize(new Dimension(60, 30));

        JButton placeTurn = new JButton("Submit");
        placeTurn.setPreferredSize(new Dimension(60, 30));  // Button size

        placeTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // invalid if, selectedDice is NULL, and diceCountField is null

                String selectedDice = (String) diceSelection.getSelectedItem();
                int selectedNumber = Integer.parseInt(selectedDice);  // Convert to int

                int guessedCount = Integer.parseInt(diceCountField.getText());

                gc.handleTurn(selectedNumber, guessedCount);

                // Print selected values for now
                System.out.println("Selected Dice: " + selectedNumber);
                System.out.println("Guessed Count: " + guessedCount);
            }
        });


        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(diceSelection);

        southPanel.add(diceCountField);
        southPanel.add(placeTurn);
        southPanel.add(bluff);
        add(southPanel, BorderLayout.SOUTH);

    }


}
