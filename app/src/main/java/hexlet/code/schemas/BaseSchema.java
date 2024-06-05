package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private boolean required = false;
    private final List<Predicate<T>> predicates = new ArrayList<>();


    protected final void setRequired() {
        this.required = true;
    }

    protected final void setPredicate(Predicate<T> predicate) {
        predicates.add(predicate);
    }

    protected final void updatePredicate(Predicate<T> predicate) {
        predicates.clear();
        predicates.add(predicate);
    }

    public final boolean isValid(T input) {

        if (input == null || input.equals("")) {
            if (required) {
                return false;
            }
        } else {
            for (Predicate<T> p : predicates) {
                if (!p.test(input)) {
                    return false;
                }
            }
        }

        return true;
    }
}
