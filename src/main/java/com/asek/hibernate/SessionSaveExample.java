package com.asek.hibernate;

import com.asek.entity.PCGame;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionSaveExample {

//    public static void main(String[] args) {
//        Session session = null;
//        Transaction transaction = null;
//
//        try {
//            session = HibernateUtil.getSession().openSession();
//            transaction = session.beginTransaction();
//
//            PCGame game = new PCGame();
//            game.setId(2);
//            game.setTitle("League of Legends");
//            game.setPlatform("PC");
//
//           // PCGame gameFound = session.load(PCGame.class, (long) 1);
//
//            session.save(game);
//           // session.delete(gameFound);
//            transaction.commit();
//
////            System.out.println(game.getTitle() + " added successfully.");
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//            if(transaction != null) {
//                transaction.rollback();
//            }
//        }
//        finally {
//            if(session != null) {
//                session.close();
//            }
//        }
//
//        HibernateUtil.shutdown();
//
//    }

}
