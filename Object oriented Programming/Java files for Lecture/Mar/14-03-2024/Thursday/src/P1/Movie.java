package P1;

import java.util.ArrayList;

public class Movie {
    private String title;
    private String director;
    private int year;
    private double rating;
    private double expenses;
    private double earning;

    private ArrayList<Actor> actors = new ArrayList<Actor>();

    public Movie() {}

    public Movie(String title, String director, int year, double rating, double expenses,
                 double earning, ArrayList<Actor> actors){
        setTitle(title);
        setDirector(director);
        setYear(year);
        setRating(rating);
        setExpenses(expenses);
        setEarning(earning);
        setActors(actors);

    }
    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }
}
