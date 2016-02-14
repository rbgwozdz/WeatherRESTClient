package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Sample {

	public static void main(String[] args) throws MalformedURLException, IOException {
		String url = "http://freemusicarchive.org/api/get/genres.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
        String genreJson = IOUtils.toString(new URL(url).openStream());
        System.out.println(genreJson);
        JSONObject json = new JSONObject(genreJson);
        // get the title
        System.out.println(json.get("title"));
        // get the data
        JSONArray genreArray = (JSONArray) json.get("dataset");
        // get the first genre
        JSONObject firstGenre = (JSONObject) genreArray.get(0);
        System.out.println(firstGenre.get("genre_title"));	     
    }
}
