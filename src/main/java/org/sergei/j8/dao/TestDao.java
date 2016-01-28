package org.sergei.j8.dao;

import java.util.function.Function;

/**
 * Created by sergei on 1/28/16.
 */
public class TestDao {

    private Handler handler;

    public TestDao() {
    }

    public TestDao(Handler handler) {
        this.handler = handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public String exec(Function<TestDao, String> func) {
        if (handler == null) {
            throw new IllegalStateException("Handler can't be null");
        }

        try {
            return func.apply(this);
        } catch (Exception e) {
            return handler.handleError(e);
        }
    }

    public Function<TestDao, String> get = (dao) -> dao.getName();

    public Function<TestDao, String> get2 = (dao) -> {
           throw new RuntimeException("TEst");
    };

    private String getName() {
        return "Dao: Name";
    }
}
