package com.asek.hibernate;

import com.asek.entity.PCGame;

public class Main {

    public static void main(String[] args) {
        DBUtility db = new DBUtility();

        PCGame newGame = new PCGame();
        newGame.setId(3);
        newGame.setTitle("WoW");
        newGame.setPlatform("PC");

        PCGame updatedGame = new PCGame();
        updatedGame.setId(1111);
        updatedGame.setTitle("Need for Speed: Most Wanted");
        updatedGame.setPlatform("Playstation");

//        db.addNewGame(newGame);
//        db.updateExistingGame(updatedGame);
//        db.deleteGame(1);
        System.out.println(db.getGameInfo(91991));
        db.shutdown();
    }
}
