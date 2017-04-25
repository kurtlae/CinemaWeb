package group1.cinema.core;

/**
 * Movie class
 * 
 * @author Mats Norlund
 */
public class Movie extends StoredObject {

    /**
     * Table name
     */
    public static final String TABLE_NAME = "movie";

    /**
     * Movie title
     */
    private String title;

    /**
     * Movie duration (in minutes)
     */
    private int duration;

    /**
     * Movie description
     */
    private String description;

    /**
     * Minimum age requirement (in years)
     */
    private int ageRequirement;

    /**
     * Movie release date
     */
    private int year;

    /**
     * Movie genre
     */
    private String genre;

    /**
     * Screened movie language
     */
    private String language;

    /**
     * Gets the movie title
     * 
     * @return Movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the movie duration
     * 
     * @return Movie duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the movie description
     * 
     * @return Movie description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the age requirement of the movie
     * 
     * @return Age requirement
     */
    public int getAgeRequirement() {
        return ageRequirement;
    }

    /**
     * Gets the movie release date
     * 
     * @return Release date
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the movie genre
     * 
     * @return Movie genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the language the movie is displayed in
     * 
     * @return Displayed language
     */
    public String getLanguage() {
        return language;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Movie [id=" + getId() + ", title=" + title + ", duration=" + duration + ", description=" + description
                + ", ageRequirement=" + ageRequirement + ", year=" + year + ", genre=" + genre + ", language="
                + language + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see group1.cinema.core.StoredObject#StoredObject(int)
     */
    public Movie(int id) {
        super(id);
    }

    /**
     * Movie
     *
     * @param id ID
     * @param title Title
     * @param duration Duration
     * @param description Description
     * @param ageRequirement Age requirement
     * @param year Year
     * @param genre Genre
     * @param language Language
     */
    public Movie(String title, int duration, String description, int ageRequirement, int year, String genre,
            String language) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.ageRequirement = ageRequirement;
        this.year = year;
        this.genre = genre;
        this.language = language;
    }

}
