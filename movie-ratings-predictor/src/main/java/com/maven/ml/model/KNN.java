package com.maven.ml.model;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.maven.ml.Helper;

import java.text.DecimalFormat;

public class KNN {

    private Map<String, double[]> trainingData;
    private int k_neighrbors = 8;
    
    public KNN(Map<String, double[]> trainingData) {
        this.trainingData = trainingData;
    }

    public KNN(Map<String, double[]> trainingData, int k_neighbors) {
        this.trainingData = trainingData;
        this.k_neighrbors = k_neighbors;
    }

    public double predict(List<Double> movie) {
        double prediction = 0;
        int i = 0;
        DecimalFormat df = new DecimalFormat("#.##");

        Map<String, Double> distances = computeAllDistances(this.trainingData, movie);
        distances = Helper.sortMapByValue(distances);
        
        for(Map.Entry<String, Double> entry: distances.entrySet()) {
            if(i<this.k_neighrbors) {
                prediction+=this.trainingData.get(entry.getKey())[5];
                i++;
            }
            else {
                break;
            }
        }

        return Double.parseDouble(df.format(prediction/this.k_neighrbors));
    }

    public static Map<String, Double> computeAllDistances(Map<String, double[]> cleanedData, List<Double> movie) {
        Map<String, Double> distances = new HashMap<>();

        for(Map.Entry<String, double[]> entry: cleanedData.entrySet()) {
            double[] features = entry.getValue();
            String movieTitle = entry.getKey();
            double d = distance(features, movie);
            distances.put(movieTitle, d);
        }

        return distances;
    }

    public static double distance(double[] features1, List<Double> movie) {
        double s = 0;
        
        for(int i=0; i<movie.size();i++) {
            s+=Math.pow(features1[i] - movie.get(i), 2);
        }

        return Math.sqrt(s);
    }
}