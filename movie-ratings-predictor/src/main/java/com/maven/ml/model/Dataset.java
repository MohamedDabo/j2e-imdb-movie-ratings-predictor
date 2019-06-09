package com.maven.ml.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class Dataset {

    private Map<String, List<String[]>> data;

    private static final int 
    COL_TITLES = 1,
    COL_GENRES = 2,
    COL_DIRECTORS = 4, 
    COL_ACTORS = 5,
    COL_DURATIONS = 7,
    COL_REVENUES = 10,
    COL_RATINGS = 8;

    public Dataset(String path) throws IOException {
        this.data = this.readCSV(path);
    }

    /**
     * READING CSV FILE AND INITIALIZING DATASET
     * @param dataset
     * @param path
     * @return
     * @throws IOException
     */
    private Map<String, List<String[]>> readCSV(String path) throws IOException {
        Map<String, List<String[]>> dataset = new HashMap<>();

        try {
            CSVReader reader = new CSVReader(new FileReader(path));

            List<String[]> data = reader.readAll();
            //remove the Rank column
            data.remove(0);
            for (String[] observation: data) {
                dataset.put(observation[COL_TITLES], Arrays.asList(
                    observation[COL_GENRES].split(","), 
                    observation[COL_DIRECTORS].split(","),
                    observation[COL_ACTORS].split(","),
                    observation[COL_DURATIONS].split(","),
                    observation[COL_REVENUES].split(","),
                    observation[COL_RATINGS].split(",")
                ));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error: couldn't close reader object!");
        }
        
        return dataset;
    }

    /**
     * RETURN A NEW DATASET MAP WITH ONLY THE PROPER VALUES
     * @return
     */
    public Map<String, double[]> getCleanedData() {
        Map<String, double[]> cleandedData = new HashMap<>();

        for(Map.Entry<String, List<String[]>> entry: this.data.entrySet()) {
            double features[] = new double[6];

            for(int i=0; i<6;i++) {
                features[i] = Double.parseDouble(entry.getValue().get(i)[0]);
            }

            cleandedData.put(entry.getKey(), features);
        }
        return cleandedData;
    }

    /**
     * IMPUTE MISSING VALUES IN REVENUE COLUMN USING MEAN STRATEGY
     */
    public void imputeMissingRevenues() {
        double mean = 0;
        DecimalFormat df = new DecimalFormat("#.##");

        for(Map.Entry<String, List<String[]>> entry: this.data.entrySet()) {
            if(entry.getValue().get(4)[0].length() != 0) {
                mean+=Double.parseDouble(entry.getValue().get(4)[0]);
            }
        }

        mean/=this.data.size();
        mean = Double.parseDouble(df.format(mean));

        for(Map.Entry<String, List<String[]>> entry: this.data.entrySet()) {
            if(entry.getValue().get(4)[0].length() == 0) {
                entry.getValue().get(4)[0] = String.valueOf(mean);
            }
        }
    }

    /**
     * GETTING UNIQUE VALUES FOR GENRE, ACTORS AND DIRECTOR
     * @param dataset
     * @param col
     * @return
     */
    public List<String> getUniqueValues(int col) {
        List<String> unique_values = new ArrayList<>();

        for(Map.Entry<String, List<String[]>> entry: this.data.entrySet()) {
            String[] variable = entry.getValue().get(col);
            // System.out.println(genres.length);
            for(int i=0; i<variable.length; i++) {
                if(!unique_values.contains(variable[i].trim()))
                    unique_values.add(variable[i].trim());
            }
        }

        return unique_values;
    }

    /**
     * MAPPING EACH UNIQUE VALUE TO AN INTEGER
     * @param dataset
     * @param stringX
     * @param col
     */
    public void mapStringsToInteger(Map<String, Integer> featureX, int col) {
        for(Map.Entry<String, List<String[]>> entry: this.data.entrySet()) {
            String[] variable = entry.getValue().get(col);
            int sum = 0;
            int val = 0;

            for(String value: variable) {
                val = featureX.get(value.trim());
                sum+=val;
            }

            variable[0] = String.valueOf(sum);
        }
    }

    public void printFeature(int i) {
        for(Map.Entry<String, List<String[]>> entry: this.data.entrySet()) {
            String[] feature = entry.getValue().get(i);
            System.out.println(Arrays.toString(feature));
        }
    }
}