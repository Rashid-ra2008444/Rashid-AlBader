package Fall2022Past.Q2;

import java.util.ArrayList;

public class MoviesDataSet {
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    public MoviesDataSet() { }
    public MoviesDataSet(ArrayList<Movie> movies) { setMovies(movies); }
    public ArrayList<Movie> getMovies() { return movies; }
    public void setMovies(ArrayList<Movie> movies) { this.movies = movies; }


    //The method moviesByDirector that takes a director’s name DirectorName and returns a list of Movie objects having
    // that the movie is directed by the director DirectorName.
    public ArrayList<Movie> moviesByDirector(String DirectorName) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for(Movie m : movies) {
            if(m.getDirector().equals(DirectorName)) {
                result.add(m);
            }
        }
        return result;
    }
    //The method moviesByActor that takes an actor’s name ActorName and returns
    // a list of Movie objects having that the actor ActorName is acting in the movie.
    public ArrayList<Movie> moviesByActor(String ActorName) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for(Movie m : movies) {
            if(m.getActors().contains(ActorName)) {
                result.add(m);
            }
        }
        return result;
    }
    //The method gainedProfitMovies, which returns a list of movies’
    // titles where the earnings of the movie is more than the expenses of the movie
    public ArrayList<String> gainedProfitMovies() {
        ArrayList<String> result = new ArrayList<String>();
        for(Movie m : movies) {
            if(m.getEarnings() > m.getExpenses()) {
                result.add(m.getTitle());
            }
        }
        return result;
    }
    //The method highestRatingMovie that takes the int year
    // and returns the title of the movie having the highest rating in that year.
    // If the value of year passed to this method is zero,
    // then the method returns the title of the movie having the highest rating regardless of the year.
    public String highestRatingMovie(int year) {
        String result = "";
        double maxRating = 0.0;
        for(Movie m : movies) {
            if(m.getYear() == year & m.getRating() > maxRating) {
                maxRating = m.getRating();
                result = m.getTitle();
            }
        }
        return result;
    }
}
