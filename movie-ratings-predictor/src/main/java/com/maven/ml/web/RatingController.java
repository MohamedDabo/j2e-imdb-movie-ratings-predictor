package com.maven.ml.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maven.ml.Helper;
import com.maven.ml.model.Dataset;
import com.maven.ml.model.KNN;
import com.maven.ml.model.Movie;

/**
 * Servlet implementation class RatingController
 */
public class RatingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Used to fetch data from web page
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String path = System.getenv("PROJECT_LOCATION") + "/src/main/resources/data.csv";
		Dataset dataset = new Dataset(path);
		
		Map<String, double[]> cleanedData = new HashMap<>();
        List<Double> formatedMovie = new ArrayList<>();
        int k_neighbors = 0;
        
        List<String> unique_genres = dataset.getUniqueValues(0);
        Map<String, Integer> genreX = new HashMap<>();
        genreX = Helper.generateMapping(unique_genres);
        dataset.mapStringsToInteger(genreX, 0);

        List<String> unique_actors = dataset.getUniqueValues(2);
        Map<String, Integer> actorX = new HashMap<>();
        actorX = Helper.generateMapping(unique_actors);
        dataset.mapStringsToInteger(actorX, 2);

        List<String> unique_directors = dataset.getUniqueValues( 1);
        Map<String, Integer> directorX = new HashMap<>();
        directorX = Helper.generateMapping(unique_directors);
        dataset.mapStringsToInteger(directorX, 1);

        dataset.imputeMissingRevenues();
        
        cleanedData = dataset.getCleanedData();
		
		Movie movie = new Movie(Arrays.toString(request.getParameterValues("genres")),
				request.getParameter("directors"),
				request.getParameter("actors"),
				Integer.parseInt(request.getParameter("duration")),
				Integer.parseInt(request.getParameter("revenue")));
		
		formatedMovie = movie.formatMovie(genreX, actorX, directorX);
		
		double rating = 0;
		
		if(request.getParameter("k_neighbors") != "") {
			k_neighbors = Integer.parseInt(request.getParameter("k_neighbors"));
			KNN KNNmodel = new KNN(cleanedData, k_neighbors);
			rating = KNNmodel.predict(formatedMovie);
		}
		else {
			KNN KNNmodel = new KNN(cleanedData);
			rating = KNNmodel.predict(formatedMovie);
		}
		
		request.setAttribute("rating", rating);
		request.setAttribute("movieTitle", request.getParameter("title"));
		
		RequestDispatcher rd = request.getRequestDispatcher("showPrediction.jsp");
		rd.forward(request, response);
	}

	/**
	 * Used to send data to the server
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
