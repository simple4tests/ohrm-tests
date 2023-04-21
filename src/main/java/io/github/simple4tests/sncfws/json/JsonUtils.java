package io.github.simple4tests.sncfws.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class JsonUtils {

    public static List<String> getJsonDifferences(Object obj1, Object obj2, String key) {
        List<String> differences = new ArrayList<>();

        if (obj1 instanceof JSONObject && obj2 instanceof JSONObject) {
            JSONObject json1 = (JSONObject) obj1;
            JSONObject json2 = (JSONObject) obj2;

            Set<String> keys = new HashSet<>(json1.keySet());
            keys.addAll(json2.keySet());
            for (String innerKey : keys) {
                if (!json1.has(innerKey)) {
                    differences.add("\nKey " + key + "." + innerKey + " is missing from response 1");
                } else if (!json2.has(innerKey)) {
                    differences.add("\nKey " + key + "." + innerKey + " is missing from response 2");
                } else {
                    differences.addAll(getJsonDifferences(json1.get(innerKey), json2.get(innerKey), key + "." + innerKey));
                }
            }
        } else if (obj1 instanceof JSONArray && obj2 instanceof JSONArray) {
            JSONArray arr1 = (JSONArray) obj1;
            JSONArray arr2 = (JSONArray) obj2;

            if (arr1.length() != arr2.length()) {
                differences.add("\nArray length for key " + key + " is different between the two responses");
            } else {
                for (int i = 0; i < arr1.length(); i++) {
                    differences.addAll(getJsonDifferences(arr1.get(i), arr2.get(i), key + "[" + i + "]"));
                }
            }
        } else if (!Objects.equals(obj1, obj2)) {
//            differences.add("Value for key " + key + " is different between the two responses");
            differences.add(String.format("\nValue for key '%s' is different [R1:  %s] ; [R2: %s]",
                    key,
                    obj1.toString(),
                    obj2.toString()));
        }
        return differences;
    }

    public static List<String> getJsonDifferences(JSONObject obj1, JSONObject obj2) {
        return getJsonDifferences(obj1, obj2, "");
    }
}
