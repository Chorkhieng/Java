// don't change this code
// this is the option with Integer

import java.util.function.Predicate;

public class GreaterThanN implements Predicate<Integer> {

    private int n;

    public GreaterThanN(int n) {
        this.n = n;
    }

    @Override
    public boolean test(Integer val) {
        return val > n;
    }

}
