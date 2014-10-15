package vipul.com.tractapp.model;

public class Movie {
    public String title;
    public String year;
    public String runtime;
    public String overview;
    public Image images;
    public Rating ratings;

    public class Image {
        public String poster;

        @Override
        public String toString() {
            return poster;
        }
    }

    public class Rating {
        public String percentage;

        @Override
        public String toString() {
            return percentage;
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", runtime='" + runtime + '\'' +
                ", overview='" + overview + '\'' +
                ", images=" + images +
                ", ratings=" + ratings +
                '}';
    }
}