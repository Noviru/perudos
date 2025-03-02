package main.java.org.anno.perudo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DiceFrame extends JPanel {


    private Player p;

    public DiceFrame(Player p) {
        ArrayList<Dice> dice  = p.getDices();
        this.p = p;

        for (Dice d : dice) {
            // If human player display the human dices
            if(p.getId() == 0){
                JLabel diceLabel = new JLabel("" + d.getValue());
                diceLabel.setFont(new Font("Arial", Font.BOLD, 20));
                diceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(diceLabel);
            }
            // If bot display X
            else {
                JLabel diceLabel = new JLabel("X");
                diceLabel.setFont(new Font("Arial", Font.BOLD, 20));
                diceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(diceLabel);
            }

        }



    }
}
