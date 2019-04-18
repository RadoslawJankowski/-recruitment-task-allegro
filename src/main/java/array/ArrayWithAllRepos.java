package array;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class in which {@link JSONArray } {@code jsonArray } is located which stores data from all pages from {@link url.AllegroURL}
 * and has two methods:
 * {@link ArrayWithAllRepos#addToJsonArrayArraysWithDataFromPage(JSONArray)}
 * and
 * {@link ArrayWithAllRepos#printRepoWithLatestUpdate(JSONArray)}
 */
public class ArrayWithAllRepos{

    private JSONArray jsonArray = new JSONArray();

    /**
     * <p> Inserts all values ​​from the array given in the parameter into the {@code jsonArray} array. </p>
     * @param array
     */
    public void addToJsonArrayArraysWithDataFromPage(JSONArray array){
        for (int i = 0; i < array.length(); i++){
           ArrayWithAllRepos.this.jsonArray.put(array.get(i));
        }
    }

    /**
     * <p>The method assumes the array parameter, takes out the {@code "name"} and {@code "pushed_at"} values ​​from it,</p>
     * <p>and prints the result while omitting the {@code "T"} and {@code "Z"} dates for readability </p>
     * <p></p>
     * <p>Example: </p>
     * <pre>{@code Changes:     2019-04-10T07:39:33Z
     * to:     2019-04-10 07:39:33}</pre>
     * @param array
     */
    public void printRepoWithLatestUpdate(JSONArray array){
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            if (i == 0) {
                System.out.println("\n" + "Repositories name with the latest update: " +
                        jsonObject.get("name") + " " +
                        jsonObject.get("pushed_at").toString()
                                .replace("T", " ")
                                .replace("Z", "") + "\n\n" + "Others: " + "\n");
            } else {
                System.out.println(jsonObject.get("name") + " : " +
                        jsonObject.get("pushed_at").toString()
                                .replace("T", " ")
                                .replace("Z", ""));
            }
        }
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }
}