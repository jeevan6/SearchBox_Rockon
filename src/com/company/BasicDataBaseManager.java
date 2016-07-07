package com.company;

import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.util.ArrayList;

public interface BasicDataBaseManager{;
    public void connect();
    public void CreateCollection(String name);
    public void addData(ArrayList<DataEntry> list);
    public DB getDb();
    public DBCollection getCollection();

}