package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        setRequired();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = (i) -> i > 0;
        setPredicate(positive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = (i) -> i >= min && i <= max;
        setPredicate(range);
        return this;
    }
}
