package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        setRequired(true);
        return this;
    }

    public StringSchema minLength(int num) {
        setMinLength(num);
        return this;
    }

    public StringSchema contains(String substring) {
        setSubstring(substring);
        return this;
    }
}
