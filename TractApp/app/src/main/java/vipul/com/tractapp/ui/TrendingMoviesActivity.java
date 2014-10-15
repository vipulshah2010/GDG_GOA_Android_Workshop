package vipul.com.tractapp.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import vipul.com.tractapp.R;
import vipul.com.tractapp.adapter.TrendingMoviesAdapter;
import vipul.com.tractapp.model.Movie;
import vipul.com.tractapp.services.TrendingMoviesService;


public class TrendingMoviesActivity extends Activity {

    private ProgressDialog progressDialog;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_grid_layout);
        context = TrendingMoviesActivity.this;

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading Movies");
        progressDialog.setCancelable(false);
        progressDialog.show();

        new TrendingMoviesService().
                fetchTrendingMovies(new Callback<ArrayList<Movie>>() {
                    @Override
                    public void success(ArrayList<Movie> trendingMovies, Response response) {
                        progressDialog.dismiss();
                        Toast.makeText(TrendingMoviesActivity.this,
                                "Success fetching the data!! ", Toast.LENGTH_LONG).
                                show();
                        Log.i("vipul",trendingMovies.get(0).title);
                        GridView gridView=(GridView)findViewById(R.id.movieView);
                        gridView.setAdapter(
                                        new TrendingMoviesAdapter(context, trendingMovies));
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismiss();
                        error.printStackTrace();
                        Toast.makeText(TrendingMoviesActivity.this,
                                "Error while loading movies ", Toast.LENGTH_LONG).
                                show();
                    }
                });
    }
}
