package com.company;
/**
 * Created by sony on 7/4/2016.
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;

import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseManager {
    MongoClient mongoClient;
    DB db;
    DBCollection collection;
    public void connect(){
         try{

             // To connect to mongodb server
            mongoClient = new MongoClient( "localhost" , 27017 );

            // Now connect to your databases
            db = mongoClient.getDB( "ROCK_ON" );
            System.out.println("Connect to database successfully");
            //boolean auth = db.authenticate(myUserName, myPassword);
            //System.out.println("Authentication: "+auth);
            //CreateCollection("testCollection");

        }catch(Exception e){
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    public void CreateCollection(String name){
        collection = db.createCollection(name,null);
    }
    public void addData(ArrayList<DataEntry> list){
        if(collection.count()==0) {
            int i = 0;
            BasicDBObject doc;
            while (i < list.size()) {
                DataEntry d = list.get(i);
                doc = getDoc(d);
                collection.insert(doc);
                i++;
            }
            //System.out.println(collection.count());
        }
        System.out.println(collection.count());
    }

    private BasicDBObject getDoc(DataEntry d) {
        BasicDBObject doc = new BasicDBObject("CountryCode",d.getCountryCode()).
                append("PostalCode",d.getPostalCode()).
                append("PlaceName",d.getPlaceName()).
                append("StateName",d.getStateName()).
                append("StateCode",d.getStateCode()).
                append("CountyName",d.getCountyName()).
                append("CountyCode",d.getCountyCode()).
                append("CommunityName",d.getCommunityName()).
                append("CommunityCode",d.getCommunityCode()).
                append("Longitude", d.getLongitude()).
                append("Latitude", d.getLatitude()).
                append("Accuracy", d.getAccuracy());
        return doc;
    }

    public DB getDb() {
        return db;
    }

    public DBCollection getCollection() {
        return collection;
    }
}
