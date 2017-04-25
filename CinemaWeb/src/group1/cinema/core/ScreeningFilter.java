package group1.cinema.core;

import java.util.function.BiPredicate;

/**
 * Screening filterer enum
 * 
 * @author Emil Bertilsson
 */
public enum ScreeningFilter implements BiPredicate<Auditorium, Screening> {
    ALL((t, u) -> true),
    THIS_DAY((t, u) -> {
        // TODO: Implement day searching
        return true;
    }),
    THIS_WEEK((t, u) -> {
        // TODO: Implement week searching
        return true;
    }),
    THIS_MONTH((t, u) -> {
        // TODO: Implement month searching
        return true;
    });

    /**
     * Filtering predicate
     */
    private BiPredicate<Auditorium, Screening> predicate;

    /**
     * Tests the filter
     * 
     * @param t Auditorium
     * @param u Screening
     */
    @Override
    public boolean test(Auditorium t, Screening u) {
        return predicate.test(t, u);
    }

    /**
     * Screening filterer
     * 
     * @param predicate Filtering predicate
     */
    private ScreeningFilter(BiPredicate<Auditorium, Screening> predicate) {
        this.predicate = predicate;
    }

}
