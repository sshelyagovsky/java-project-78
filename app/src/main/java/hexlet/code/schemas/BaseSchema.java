package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class BaseSchema<T> {

    private boolean required = false;
    private int minLength = 0;
    private String contains = "";
    private boolean positive = false;
    private final Map<Integer, Integer> range = new HashMap<>();


    protected void setRequired(boolean required) {
        this.required = required;
    }

    protected void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    protected void setSubstring(String substring) {
        this.contains = substring;
    }

    protected void setPositive(boolean positive) {
        this.positive = positive;
    }

    public void setRange(int min, int max) {
        range.put(min, max);
    }

    public boolean isValid(T input) {

        if (input == null || input.equals("")) {
            if (required) {
                return false;
            }
        } else {
            if (minLength > input.toString().length()) {
                return false;
            }

            if (!contains.isEmpty()) {
                return StringUtils.containsIgnoreCase((String) input, contains);
            }

            if (positive) {
                if ((Integer) input <= 0) {
                    return false;
                }
            }

            if (!range.entrySet().isEmpty()) {

                var result = range.entrySet()
                        .stream()
                        .anyMatch((e) -> ((Integer) input >= e.getKey()) && ((Integer) input <= e.getValue()));
                if (!result) {
                    return false;
                }
            }
        }

        return true;
    }
}
