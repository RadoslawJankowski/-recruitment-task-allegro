import array.ArrayWithAllRepos;
import comparator.JsonComparator;
import org.json.JSONArray;
import org.json.JSONObject;
import url.AllegroURL;
import urlReader.URLReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayWithAllRepos arrayWithAllRepos = new ArrayWithAllRepos();

        // using the readUrl () method, we read pages with repositories and assign them to
        // dataFromPage1 etc...
        String dataFromPage1 = URLReader.readUrl(AllegroURL.URL);

        // create a JSONArray and insert values ​​read from all pages
        JSONArray jsonArrayWithDataFromPage1 = new JSONArray(dataFromPage1);

        // data from all arrays are added to the jsonArray from ArrayWithAllRepos class
        arrayWithAllRepos.addToJsonArrayArraysWithDataFromPage(jsonArrayWithDataFromPage1);

        // create a list jsonValues to which we add all values ​​from the jsonArray from ArrayWithAllRepos class
        List<JSONObject> jsonValues = new ArrayList<>();
        for (int i = 0; i < arrayWithAllRepos.getJsonArray().length(); i++) {
            jsonValues.add(arrayWithAllRepos.getJsonArray().getJSONObject(i));
        }

        // the jsonValues list is sorted by the date of the modification
        jsonValues.sort(new JsonComparator());

        // create a JSONArray sortedJsonArray and add sorted values ​​to it from the jsonValues list
        JSONArray sortedJsonArray = new JSONArray();
        for (int i = 0; i < arrayWithAllRepos.getJsonArray().length(); i++) {
            sortedJsonArray.put(jsonValues.get(i));
        }

        // using the printRepoWithLatestUpdate() method to print the repository with the earliest modification as highlighted and others as sorted
        arrayWithAllRepos.printRepoWithLatestUpdate(sortedJsonArray);
    }
}