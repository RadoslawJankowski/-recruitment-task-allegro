package url;

/**
 * Storage class for url with allegro repositories.
 * <pre>{@code
 * public static final String URL = "https://api.github.com/users/allegro/repos?page=1";
 * public static final String URL_2 = "https://api.github.com/users/allegro/repos?page=2";
 * public static final String URL_3 = "https://api.github.com/users/allegro/repos?page=3";}</pre>
 */
public class AllegroURL {

    /**
     * {@value URL} is
     is the first page of allegro repositories in the form of json
     */
    public static final String URL = "https://api.github.com/users/allegro/repos?per_page=1000&page=page_no";
}