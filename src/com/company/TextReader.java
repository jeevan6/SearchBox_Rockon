package com.company;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by sony on 7/4/2016.
 */
public class TextReader {
    FileInputStream In;
    public ArrayList<DataEntry> readFile(String path) throws IOException {
        ArrayList<DataEntry> list = new ArrayList<>();
        try{
            BufferedReader buf = new BufferedReader(new FileReader(path));
            ArrayList<String> words = new ArrayList<>();
            String currentLine = null;
            String[] wordsArray;


            int i=0;

            while(true){
                i++;
                currentLine = buf.readLine();
                if(currentLine == null){
                    break;
                }else{
                    DataEntry de = new DataEntry();
                    wordsArray = currentLine.split("\t");
                    de.setCountryCode(wordsArray[0]);
                    de.setPostalCode(wordsArray[1]);
                    de.setPlaceName(wordsArray[2]);
                    de.setStateName(wordsArray[3]);
                    de.setStateCode(wordsArray[4]);
                    de.setCountyName(wordsArray[5]);
                    de.setCountyCode(wordsArray[6]);
                    de.setCommunityName(wordsArray[7]);
                    de.setCommunityCode(wordsArray[8]);
                    de.setLatitude(wordsArray[9]);
                    de.setLongitude(wordsArray[10]);
                    de.setAccuracy(wordsArray[11]);
                    list.add(de);
                    /*public String countryCode;
                    public String postalCode;
                    public String placeName;
                    public String stateName;
                    public String stateCode;
                    public String countyName;
                    public String countyCode;
                    public String communityName;
                    public String communityCode;
                    public String latitude;
                    public String longitude;
                    public String Accuracy;*/

                    for(String each : wordsArray){
                        //if(!"".equals(each)){
                            words.add(each);
                        //}
                    }
                }
            }

            for(String each : words){
                //System.out.println(each);
            }

            buf.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
