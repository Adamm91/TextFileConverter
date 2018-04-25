package pl.sda;


import java.util.HashMap;
import java.util.Map;

public class Something {
    private Map<String, String> map = new HashMap();


    public void setMap(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String toString() {
        return "Something{" +
                "map=" + map +
                '}';
    }
}
