package main.java.org.anno.perudo;

import javax.swing.*;
import java.util.ArrayList;

public class Player {

    private int num_dices;
    private int id;
    private ArrayList<Dice> dices = new ArrayList<Dice>();
    private boolean turn;



    public Player(int num_dices, int id) {
        this.num_dices = num_dices;
        this.id = id;
        if(id == 0){
            turn = true;
        }
        else{
            turn = false;
        }
        for (int i = 0; i < num_dices; i++) {
            dices.add(new Dice());
        }
    }

    public void loseDice(){
        if(this.num_dices == 0){
            throw new RuntimeException("Already has zero dices");
        }
        else{
            this.num_dices--;
        }
    }
    public void winDice(){
        if(this.num_dices == 0 || this.num_dices == 5){
            throw new RuntimeException("Already has zero dices or maximum");
        }
        else{
            this.num_dices++;
        }
    }

    public ArrayList<Dice> getDices() {
        return dices;
    }


    public int getId(){
        return this.id;
    }

    public boolean getTurn(){
        return this.turn;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }




}
