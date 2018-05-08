package pl.sda.readers;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.Something;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JSONFileReader implements TextFileReader {

    @Override
    public List<Something> read(String filePath) throws IOException {

        List<Something> result = new ArrayList<>();

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String json = new String(bytes, "UTF-8");

        JSONObject jsonObject = new JSONObject(json);
        String rootKey = jsonObject.keySet().iterator().next();
        JSONArray rawValues = new JSONArray(jsonObject.get(rootKey).toString());

        for (Object rawValue : rawValues) {
            JSONObject value = new JSONObject(rawValue.toString());
            Something something = new Something();
            Set<String> keys = value.keySet();
            for (String key : keys) {
                something.setMap(key, value.get(key).toString());
            }
            result.add(something);
        }
        return result;
    }
}
