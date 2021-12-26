package com.database.iot;

import org.hibernate.Session;
import com.database.iot.util.HibernateUtil;
import com.database.iot.view.View;

public class App {
    public static void main(String[] args) {
        try (Session SESSION = HibernateUtil.getSession()) {
            System.out.println("Test session established. ");
            new View().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}