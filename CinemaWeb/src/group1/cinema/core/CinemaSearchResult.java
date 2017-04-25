package group1.cinema.core;

/**
 * Cinema search result class
 */
final class CinemaSearchResult {

    /**
     * Target auditorium
     */
    private final Auditorium auditorium;

    /**
     * Target screening
     */
    private final Screening screening;

    /**
     * Gets the auditorium
     * 
     * @return Auditorium
     */
    public Auditorium getAuditorium() {
        return auditorium;
    }

    /**
     * Gets the screening
     * 
     * @return Screning
     */
    public Screening getScreening() {
        return screening;
    }

    /**
     * Instantiates a new cinema search result
     * 
     * @param auditorium Matched auditorium
     * @param screening Matched screening
     */
    CinemaSearchResult(Auditorium auditorium, Screening screening) {
        this.auditorium = auditorium;
        this.screening = screening;
    }

}
