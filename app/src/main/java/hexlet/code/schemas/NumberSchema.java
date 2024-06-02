package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        setPositive(true);
        return this;
    }

    public NumberSchema range(int min, int max) {
        setRange(min, max);
        return this;
    }
}
