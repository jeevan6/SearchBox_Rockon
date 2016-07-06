package com.company;

import com.sun.imageio.plugins.common.InputStreamAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Utils myUtils = new Utils();
        String mode = myUtils.getUserMode();
        String test = myUtils.getUserString();
        TextReader textReader = new TextReader();
        ArrayList<DataEntry> DeList = null ;
        try {
            DeList = textReader.readFile("C:/Users/sony/IdeaProjects/RockOn/src/com/company/Files/US.txt");
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
        DatabaseManager Dm=new DatabaseManager();
        Dm.connect();
        Dm.CreateCollection("GeoNamesData");
        System.out.println(DeList.size());
        Dm.addData(DeList);
        SearchBox box = new SearchBox(Dm.getDb());
        box.Search(mode,test);


    }
}
