package vipul.com.tractapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vipul.com.tractapp.R;

public class MovieDetailActivity extends Activity {

    private ImageView moviePoster;
    private TextView movieTitle;
    private TextView movieYear;
    private TextView movieDuration;
    private TextView movieRatings;
    private TextView movieStoryline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_layout);

        getActionBar().hide();

        moviePoster = (ImageView) findViewById(R.id.moviePoster);
        movieTitle = (TextView) findViewById(R.id.movieTitle);
        movieYear = (TextView) findViewById(R.id.movieReleaseYear);
        movieDuration = (TextView) findViewById(R.id.movieRuntime);
        movieRatings = (TextView) findViewById(R.id.movieRatings);
        movieStoryline = (TextView) findViewById(R.id.movieStoryline);

        Picasso picasso = Picasso.with(this);
        picasso.load(getIntent().getStringExtra("poster")).
                placeholder(R.drawable.placeholder).
                fit().
                centerCrop().
                into(moviePoster);

        movieTitle.setText(getIntent().getStringExtra("title"));
        movieYear.setText("Release Year\n"+getIntent().getStringExtra("year"));

        int hours = Integer.parseInt(getIntent().getStringExtra("runtime")) / 60;
        int minutes = Integer.parseInt(getIntent().getStringExtra("runtime")) % 60;
        String duration=String.format("%d hours %02d mins", hours, minutes);
        movieDuration.setText("Runtime\n"+duration);

        movieRatings.setText("Ratings:"+getIntent().getStringExtra("ratings")+"%");
        movieStoryline.setText(getIntent().getStringExtra("overview"));
    }
}
