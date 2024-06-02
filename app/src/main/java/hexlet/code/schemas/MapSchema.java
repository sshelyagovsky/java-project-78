package hexlet.code.schemas;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int size) {
        setMapSize(size);
        return this;
    }
}
