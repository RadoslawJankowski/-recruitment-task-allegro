package urlReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Class with the {@link URLReader#readUrl(String)} method. It is used to read all characters from the page and return them.
 */
public class URLReader {

    /**
     * <p>The method takes a {@link String} {@code url}, connects to it and reads all characters from the page</p>
     * @param urlString
     * @return {@link BufferedReader} {@code buffer} containing all characters from the page in toString
     * @throws Exception
     */
    public static String readUrl(String urlString) throws Exception {

        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}