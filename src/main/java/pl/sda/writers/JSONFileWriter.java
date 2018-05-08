package pl.sda.writers;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.Something;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class JSONFileWriter implements TextFileWriter {

    @Override
    public void write(List<Something> somethings, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        JSONArray jsonArray = new JSONArray();
        for (Something something : somethings) {
            JSONObject somethingJsonObject = new JSONObject();
            Set<String> keySets = something.getMap().keySet();
            for (String keySet : keySets) {
                somethingJsonObject.put(keySet, something.getMap().get(keySet));
            }
            jsonArray.put(somethingJsonObject);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("values", jsonArray);

        bufferedWriter.write(jsonObject.toString());
        bufferedWriter.close();


//        StringBuilder builder = new StringBuilder();
//
//        for (Something something : somethings) {
//            builder.append("{").append("\n");
//            Set<String> keys = something.getMap().keySet();
//            for (String key : keys) {
//                builder.append("\"").append(key).append("\"").
//                        append(":").
//                        append("\"").append(something.getMap().get(key)).append("\"").
//                        append(",").append("\n");
//            }
//            builder.deleteCharAt(builder.length() - 2);
//            builder.append("}").append("\n");
//        }


    }
}
