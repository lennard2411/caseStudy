package com.example.casestudy.entity;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Betriebsstellen {

    private Map<String, Betriebsstelle> betriebsstellenMap = new HashMap<>();

    private static Betriebsstellen instance = new Betriebsstellen();
    public static Betriebsstellen getInstance(){
        return instance;
    }

    private Betriebsstellen(){
        String fileName = "src\\main\\resources\\static\\DBNetz-Betriebsstellenverzeichnis-Stand2021-07.csv";
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            //skip first line
            boolean skip = true;
            String[] line;
            String[] data;
            while ((line = reader.readNext()) != null) {
                if (skip){
                    skip = false;
                    continue;
                }
                data = line[0].split(";");
                //skip row with missing values
                if (data.length < 12){
                    continue;
                }
                betriebsstellenMap.put(data[1].toLowerCase(), new Betriebsstelle(data[2], data[3], data[5]));
            }
            //System.out.println(betriebsstellenMap.size());
            reader.close();
        } catch(FileNotFoundException ex){
            System.out.println("CSV-file not found");
        } catch(IOException ex){
            System.out.println(ex);
        } catch(CsvException ex){
            System.out.println(ex);
        }
    }

    public Betriebsstelle getBetriebsstelle(String name){
        return betriebsstellenMap.get(name);
    }

}
