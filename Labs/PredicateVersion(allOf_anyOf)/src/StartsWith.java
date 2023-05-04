// don't change this code
// this is for option with String

import java.util.function.Predicate;

public class StartsWith implements Predicate<String> {

    public String s;

    public StartsWith(String s) {
        this.s = s;
    }

    @Override
    public boolean test(String t) {
        return t.startsWith(s);
    }
}
