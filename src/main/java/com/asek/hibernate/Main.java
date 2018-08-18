package com.asek.hibernate;

import com.asek.entity.PCGame;

public class Main {

    public static void main(String[] args) {
        DBUtility db = new DBUtility();

        PCGame newGame = new PCGame();
        newGame.setId(710);
        newGame.setTitle("PUBG");
        newGame.setPlatform("PC");

        db.addNewGame(newGame);
        db.deleteGame(10);
        db.shutdown();
    }
}
