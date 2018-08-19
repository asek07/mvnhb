package com.asek.hibernate;

import com.asek.entity.PCGame;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;

public class DBUtility {

    private Session session = null;
    private HibernateUtil hb = null;

    private Session initSession() {
        if(this.getSession() == null) {
           try {
               hb = new HibernateUtil();
               return this.session = hb.getSession().openSession();
           }
           catch(Exception e) {
               System.out.println("Something went wrong!!!!!!");
               e.printStackTrace();
           }
        }
        return this.session;
    }

    // Add a new game to the DB, will catch duplicate entry exception also
    public void addNewGame(PCGame game) {
        Transaction transaction = null;

        try {
            this.initSession();
            transaction = this.getSession().beginTransaction();

            this.getSession().save(game);
            transaction.commit();

            System.out.println(game.getTitle() + " added to DB successfully.");
        }
        catch (PersistenceException p) {
            System.out.println("Duplicate entry.");
            p.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            if(session != null) {
                session.close();
               this.resetSession();
            }
        }
    }

    // Find and delete a game based on id
    public void deleteGame(long id) {
        Transaction transaction = null;

        try {
            this.initSession();
            transaction = this.initSession().beginTransaction();

            PCGame game = session.load(PCGame.class, id);

            this.getSession().delete(game);
            System.out.println("getting here!");
            transaction.commit();

        }
        catch (Exception e) {
            System.out.println("Delete: something happened...");
            e.printStackTrace();
            if(session != null) {
              transaction.rollback();
            }
        }
        finally {
            if (session != null) {
                session.close();
                this.resetSession();
            }
        }
    }

    //TODO:
    //Add update existing game entry
    public void updateExistingGame(PCGame game) {
        Transaction transaction = null;

        try {
            this.initSession();
            transaction = this.initSession().beginTransaction();

            this.getSession().update(game);
            System.out.println("Updating game info...");
            transaction.commit();

        }
        catch (Exception e) {
            System.out.println("DB Entry with ID=" + game.getId() + " may not exist in DB.");
            e.printStackTrace();
            if(session != null) {
                transaction.rollback();
            }
        }
        finally {
            if (session != null) {
                session.close();
                this.resetSession();
            }
        }
    };

    //Get game data
    public String getGameInfo(long id){

        Transaction transaction = null;
        String output;

        try {
            this.initSession();
            transaction = this.initSession().beginTransaction();

            PCGame game = this.getSession().load(PCGame.class, id);

            System.out.println("Finding game with ID=" + id);
            output = "{id:" + game.getId() + ", title: " + game.getTitle()
                    + ", platform: " + game.getPlatform() + "}";
            transaction.commit();

            return output;
        }
        catch (Exception e) {
            System.out.println("Game with ID=" + id + " does not exist in DB.");
            output = "Cannot fnd game with that ID!";
            e.printStackTrace();
            if(session != null) {
                transaction.rollback();
            }
        }
        finally {
            if (session != null) {
                session.close();
                this.resetSession();
            }
        }
      return output;
    };

    public HibernateUtil getHb() {
        return hb;
    }

    public Session getSession() {
        return session;
    }

    public void resetSession() {
        this.session = null;
    }

    public void shutdown() {
        if(hb != null) {
            hb.shutdown();
        }
    }
}
