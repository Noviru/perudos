package main.java.org.anno.perudo;

import java.util.ArrayList;

public class GameController {
    private ArrayList<Player> players;
    private int currentDice;
    private int currentGuess;

    public GameController(ArrayList<Player> players) {
        this.currentDice = 0;
        this.currentGuess = 0;
        this.players = players;

    }

    public boolean handleBluff(Player p, int currentDice, int currentGuess){
        // Can only bluff the player that previously did a move
        // Can only bluff if it is the players turn
        int correct_num = 0;
        if(!p.getTurn()){
            // Throw exception
        }
        else{
            for (Player play: players){
                ArrayList<Dice> dices = play.getDices();
                for (Dice dice: dices){
                    if(dice.getValue() == currentDice){
                        correct_num += 1;
                    }
                }
            }
            // There existed more dices than the player thought, hence they lose

        }
        // There existed less dices hence the player wins the bluff
        return correct_num < currentGuess;
    }

    public boolean isValidGuess(int diceValue, int guessAmount) {
        if(this.currentGuess > guessAmount && this.currentDice > diceValue){
            return false;
        }
        if(this.currentGuess == guessAmount && this.currentDice >= diceValue){
            return false;
        }
        return true;

    }

    public void handleGuess(Player p, int diceValue, int guessAmount) {
        if(isValidGuess(diceValue, guessAmount)){
            this.currentGuess = guessAmount;
            this.currentDice = diceValue;
            nextTurn();
        }
    }

    public void nextTurn() {
        // Find the current player whose turn is true
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getTurn()) {
                // Set the current player's turn to false
                player.setTurn(false);

                // Find the next player (if we're at the last player, loop back to the first)
                int nextPlayerIndex = (i + 1) % players.size();  // Ensures the index wraps around

                // Set the next player's turn to true
                players.get(nextPlayerIndex).setTurn(true);
                break;  // Exit the loop once the turn has been passed
            }
        }
    }

    public int getCurrentDice() {
        return this.currentDice;
    }

    public int getCurrentGuess() {
        return this.currentGuess;
    }


}
