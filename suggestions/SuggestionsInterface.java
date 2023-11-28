package suggestions;

/**
 * The SuggestionsInterface defines methods for handling suggestions, including viewing, editing,
 * submitting, responding to, and checking the status of suggestions.
 *
 * Implementations of this interface can provide specific functionality for handling suggestions
 * based on the requirements of the application.
 * 
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */

public interface SuggestionsInterface {
    /**
     * Views suggestions based on specific implementation logic.
     */
    public default void viewSuggestions() {
    }

    /**
     * Edits suggestions based on specific implementation logic.
     */
    public default void editSuggestions() {
    }

    /**
     * Submits new suggestions based on specific implementation logic.
     */
    public default void submitSuggestions() {
    }

    /**
     * Responds to suggestions based on specific implementation logic.
     */
    public default void respondToSuggestions() {
    }

    /**
     * Checks the status of suggestions based on specific implementation logic.
     */
    public default void statusOfSuggestions() {
    }
}
