package vipul.com.tractapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vipul.com.tractapp.R;
import vipul.com.tractapp.model.Movie;
import vipul.com.tractapp.ui.MovieDetailActivity;

public class TrendingMoviesAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Movie> mMovies;

    public TrendingMoviesAdapter(Context context, ArrayList<Movie> movies) {
        this.mContext = context;
        this.mMovies = movies;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int index) {
        return mMovies.get(index);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Movie movie = mMovies.get(i);

        if (view == null) {
            view = new ImageView(mContext) {
                @Override
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
                }
            };
        }

        ImageView imageView = (ImageView) view;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);


        Picasso picasso = Picasso.with(mContext);
        picasso.load(movie.images.poster).
                placeholder(R.drawable.placeholder).
                fit().
                centerCrop().
                into(imageView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MovieDetailActivity.class);
                intent.putExtra("poster", movie.images.poster);
                intent.putExtra("title", movie.title);
                intent.putExtra("year", movie.year);
                intent.putExtra("runtime", movie.runtime);
                intent.putExtra("ratings", movie.ratings.percentage);
                intent.putExtra("overview", movie.overview);
                mContext.startActivity(intent);
            }
        });

        return view;
    }
}
