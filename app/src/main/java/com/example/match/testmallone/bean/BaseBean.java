package com.example.match.testmallone.bean;

import java.io.Serializable;

/**
 * Created by match on 2018/12/13.
 */

public class BaseBean implements Serializable {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
