package com.company;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Scanner;

/**
 * Created by sony on 7/7/2016.
 */
public class Utils {
    public String getUserMode() {
        String mode = null;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your Choice" + "\n" +
                "1. Search by Zipcode" + "\n" +
                "2. Search by Partial/Full City Name" + "\n" +
                "3. Search by Partial/Full City Name or ZipCode" + "\n");

        int a = reader.nextInt();
        while (mode == null) {
            if (a == 1) {
                mode = "Zip";
                System.out.println("Please enter Zipcode to Search:");
            } else if (a == 2) {
                mode = "City";
                System.out.println("Please enter CityName to Search:");
            } else if (a == 3) {
                mode = "Any";
                System.out.println("Please enter String to Search:");
            } else {
                System.out.println("WARNING: Inavalid Input" + "\n" + "TRY AGAIN");
                a = reader.nextInt();
            }
        }

        return mode;
    }

    public String getUserString() {
        String mode;
        Scanner reader = new Scanner(System.in);
        mode = reader.next();
        return mode;
    }

    public void PrintDBobject(DBObject obj) {
        System.out.println(obj.get("CountryCode") + "    " + obj.get("PostalCode") + "  " +
                obj.get("PlaceName") + "   " + obj.get("StateName") + "    " + obj.get("StateCode") + "   " +
                obj.get("CountyName") + "  " + obj.get("CountyCode") + "  " + obj.get("CommunityName") + " " +
                obj.get("CommunityName") + "   " + obj.get("Latitude") + " " + obj.get("Longitude") + "  " +
                obj.get("Accuracy"));
    }

    public void PrintData(DBCursor cursor) {
        checkNull(cursor);
        while(cursor.hasNext()) {
        DBObject ne = cursor.next();
        PrintDBobject(ne);
        }
    }

    private void checkNull(DBCursor cursor) {
        if(cursor.size()==0){
            System.out.println("Sorry::Your Search returned ZERO results");
        }
        else{
            System.out.println("Your Search returned following results");
        }
    }

}
