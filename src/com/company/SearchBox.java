package com.company;

import com.mongodb.*;

import java.util.ArrayList;

/**
 * Created by sony on 7/4/2016.
 */
public class SearchBox {
    DB db;
    DBCollection collection;

    public SearchBox(DB db) {
        this.db = db;
        this.collection = db.getCollection("GeoNamesData");
    }

    public DBCursor Search(String mode,String test){
        DBCursor cursor = null;
        if(mode.equals("Zip")){
            cursor = collection.find(new BasicDBObject("PostalCode", test));
        }
        if(mode.equals("City")){
            //DBObject group = new BasicDBObject("$group","StateName");
            //collection.aggregate(group);
            cursor = collection.
                    find(new BasicDBObject("PlaceName",new BasicDBObject("$regex",test))).
                    sort(new BasicDBObject("StateName", 1).
                            append("PlaceName",1).
                            append("CountyName",1).
                            append("CommunityName",1));

        }
        if(mode.equals("Any")){
            DBObject clause1 = new BasicDBObject("PlaceName",new BasicDBObject("$regex",test));
            DBObject clause2 = new BasicDBObject("PostalCode",new BasicDBObject("$regex",test) );
            BasicDBList or = new BasicDBList();
            or.add(clause1);
            or.add(clause2);
            DBObject query = new BasicDBObject("$or", or);
            cursor = collection.find(query).
                    sort(new BasicDBObject("StateName", 1).
                    append("PlaceName",1).
                    append("CountyName",1).
                    append("CommunityName",1));

        }
        while(cursor.hasNext()){
            DBObject ne = cursor.next();
            PrintDBobject(ne);
        }
        return cursor;
    }
    public void PrintDBobject(DBObject obj){
        System.out.println(obj.get("CountryCode")+"    "+obj.get("PostalCode")+"  "+
                obj.get("PlaceName")+"   " +obj.get("StateName")+"    "+obj.get("StateCode")+"   "+
                        obj.get("CountyName")+"  "+obj.get("CountyCode")+"  " +obj.get("CommunityName")+" "+
                                obj.get("CommunityName")+"   "+obj.get("Latitude")+" "+obj.get("Longitude")+"  "+
                                        obj.get("Accuracy"));
    }
}
