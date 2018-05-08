package pl.sda;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Something {
    private Map<String, String> map = new LinkedHashMap<>();


    public void setMap(String key, String value) {
        map.put(key, value);
    }

    public Map<String, String>  getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "Something{" +
                "map=" + map +
                '}';
    }
}
