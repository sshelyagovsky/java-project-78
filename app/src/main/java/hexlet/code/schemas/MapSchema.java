package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<String, T> extends BaseSchema<Map<String, T>> {

    public MapSchema<String, T> required() {
        setRequired();
        return this;
    }

    public MapSchema<String, T> sizeof(int size) {
        Predicate<Map<String, T>> map = (i) -> i.size() == size;
        setPredicate(map);
        return this;
    }

    public MapSchema<String, T> shape(Map<String, BaseSchema<T>> shapeMap) {

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
