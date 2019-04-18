package comparator;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Comparator;

/**
 * Class that sorts {@link JSONObject} using {@link JsonComparator#compare(JSONObject, JSONObject)} and {@value KEY_NAME} value.
 */
public class JsonComparator implements Comparator<JSONObject> {

    /**
     * {@value KEY_NAME} key name is a key word for sorting repositories by modyfication date.
     */
    private static final String KEY_NAME = "pushed_at";

    /**
     * <p> {@code compare} from {@link Comparator} sort {@link JSONObject} {@code a} and </p>
     * <p> {@link JSONObject} {@code b} by {@code "pushed_at"} values. </p>
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(JSONObject a, JSONObject b) {
        String valA = new String();
        String valB = new String();

        try {
            valA = (String) a.get(KEY_NAME);
            valB = (String) b.get(KEY_NAME);
        }
        catch (JSONException e) {
        }

        return -valA.compareTo(valB);
    }
}