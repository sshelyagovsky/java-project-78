package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        setRequired();
        return this;
    }

    public StringSchema minLength(int limitLength) {
        Predicate<String> minLength = (i) -> i.length() >= limitLength;
        updatePredicate(minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<String> contains = (i) -> i.toLowerCase().contains(substring.toLowerCase());
        setPredicate(contains);
        return this;
    }
}
