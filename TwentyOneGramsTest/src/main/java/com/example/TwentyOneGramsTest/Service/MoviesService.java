package com.example.TwentyOneGramsTest.Service;

import com.example.TwentyOneGramsTest.Model.Movies;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class MoviesService {

    public MoviesService() {
        fetchAllMovies();
    }
    private final List<Movies> allMovies = new ArrayList<>();

    private void fetchAllMovies() {

        String rawJson = request();

        JSONObject root = new JSONObject(rawJson);

        JSONArray movies = root.getJSONArray("Movies");

        for(int i = 0; i < movies.length(); i++) {

            JSONObject jsonMovies = movies.getJSONObject(i);

            String title = jsonMovies.getString("Title");
            String year = jsonMovies.getString("Year");
            String rated = jsonMovies.getString("Rated");
            String released = jsonMovies.getString("Released");
            String runtime = jsonMovies.getString("Runtime");
            String genre = jsonMovies.getString("Genre");
            String director = jsonMovies.getString("Director");
            String writer = jsonMovies.getString("Writer");
            String actors = jsonMovies.getString("Actors");
            String plot = jsonMovies.getString("Plot");
            String language = jsonMovies.getString("Language");
            String country = jsonMovies.getString("Country");
            String awards = jsonMovies.getString("Awards");
            String poster = jsonMovies.getString("Poster");
            String metaScore = jsonMovies.getString("Metascore");
            String imdbRating = jsonMovies.getString("imdbRating");
            String imdbVotes = jsonMovies.getString("imdbVotes");
            String imdbId = jsonMovies.getString("imdbID");
            String type = jsonMovies.getString("Type");
            String response = jsonMovies.getString("Response");

            Movies movie = new Movies(title, year, rated, released, runtime,
                    genre, director, writer, actors, plot,
                    language, country, awards, poster, metaScore,
                    imdbRating, imdbVotes, imdbId, type, response);
            allMovies.add(movie);
        }
    }
    private String request() {
         StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/moviesData.json");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine = bufferedReader.readLine();
            while (inputLine != null) {
                sb.append(inputLine);
                inputLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public Movies getOneMovie(String title) {
        return allMovies.stream()
                .filter(t -> t.getTitle().contains(title))
                .findFirst()
                .orElse(null);
    }

    public List<Movies> getAllMovies() {
        return allMovies;
    }

    public List<Movies> getMoviesGenreAndLanguage(String genre, String language) {
        return allMovies.stream()
                .filter(t -> t.getGenre().contains(genre) && t.getLanguage().contains(language))
                .collect(Collectors.toList());
    }

    public List<Movies> getTitleByFilter(String title) {
        return allMovies.stream()
                .filter(t -> t.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Movies> getPlotByFilter(String plot) {
        return allMovies.stream()
                .filter(t -> t.getPlot().contains(plot))
                .collect(Collectors.toList());
    }

    public List<Movies> getDirectorByFilter(String director) {
        return allMovies.stream()
                .filter(t -> t.getDirector().contains(director))
                .collect(Collectors.toList());
    }

    public List<Movies> getActorByFilter(String actor) {
        return allMovies.stream()
                .filter(t -> t.getActors().contains(actor))
                .collect(Collectors.toList());
    }
}
