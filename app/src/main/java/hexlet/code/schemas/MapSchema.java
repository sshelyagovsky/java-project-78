package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema<T> extends BaseSchema {

    public MapSchema required() {
        setRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map<String, String>> map = (i) -> i.size() == size;
        setPredicate(map);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<T>> shapeMap) {

        Predicate<Map<String, T>> map = (i) -> {
            for (var entry: shapeMap.entrySet()) {
                T keyValue = i.get(entry.getKey());
                if (!entry.getValue().isValid(keyValue)) {
                    return false;
                }
            }
            return true;
        };

        setPredicate(map);
        return this;
    }
}
