package com.company;

import com.mongodb.DBCursor;

/**
 * Created by sony on 7/4/2016.
 */
public interface DataBaseSearchBox {
    public DBCursor Search(String mode,String test);
}
