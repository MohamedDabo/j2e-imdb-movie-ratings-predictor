package com.maven.ml.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Movie {
    private String genres;
    private String directors;
    private String actors;
    private double duration;
    private double revenue;

    public Movie(String genres, String directors, String actors, double duration, double revenue) {
        this.genres = genres;
        this.directors = directors;
        this.actors = actors;
        this.duration = duration;
        this.revenue = revenue;
    }
    
    /**
     * 
     * @param featureX
     * @param feature
     * @return
     */
    public int formatMovieFeature(Map<String, Integer> featureX, String[] feature) {
        int sum = 0;

        for(String value: feature) {
            if(featureX.containsKey(value.trim())) {
                sum+=featureX.get(value.trim());
            }
        }
        
        return sum;
    }

    public List<Double> formatMovie(Map<String, Integer> genreX, Map<String, Integer> actorX, Map<String, Integer> directorX) {
        List<Double> formatedMovie = new ArrayList<>();
        double genres = formatMovieFeature(genreX, this.genres.split(","));
        double actors = formatMovieFeature(actorX, this.actors.split(","));
        double directors = formatMovieFeature(directorX, this.directors.split(","));

        formatedMovie.add(genres);
        formatedMovie.add(actors);
        formatedMovie.add(directors);
        formatedMovie.add(this.duration);
        formatedMovie.add(this.revenue);

        return formatedMovie;
    }
}