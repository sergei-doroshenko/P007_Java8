package org.sergei.j8.dao;

/**
 * Created by sergei on 1/28/16.
 */
public class App {
    public static void main(String[] args) {
        // Create Dao
        TestDao dao = new TestDao();
        // Set error handler
        dao.setHandler(new Handler());

        System.out.println(dao.exec(dao.get));

        String result2 = dao.exec(dao.get2);
        System.out.println(result2);
    }
}
