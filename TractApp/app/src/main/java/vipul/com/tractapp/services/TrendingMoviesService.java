package vipul.com.tractapp.services;


import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import vipul.com.tractapp.model.Movie;

public class TrendingMoviesService {

    public interface MovieService {
        @GET("/cnskkMFhAi?indent=2")
        void getAllTrendingMovies(Callback<ArrayList<Movie>> moviesCallback);
    }

    public void fetchTrendingMovies(Callback<ArrayList<Movie>> moviesCallback) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.json-generator.com/api/json/get")
                .build();

        MovieService service = restAdapter.create(MovieService.class);
        service.getAllTrendingMovies(moviesCallback);
    }
}
