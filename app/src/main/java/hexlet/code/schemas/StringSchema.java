package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public class StringSchema {

    private boolean required;
    private int minLen;
    public String contains;

    public StringSchema() {
        this.required = false;
        this.minLen = 0;
        this.contains = "";
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int num) {
        this.minLen = num;
        return this;
    }

    public StringSchema contains(String substring) {
        this.contains = substring;
        return this;
    }


    public boolean isValid(String str) {

        if (required) {
            if (StringUtils.isEmpty(str)) {
                return false;
            }
        }
        if (minLen > 0) {
            if (minLen > str.length()) {
                return false;
            }
        }
        if (!contains.isEmpty()) {
            return StringUtils.containsIgnoreCase(str, contains);
        }

        return true;
    }
}
