package library;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-07/오후 3:57
 */

import javafx.beans.NamedArg;

import java.io.Serializable;
import java.util.ArrayList;

public class Pair<A, B> implements Serializable {

    /**
     * First of this <code>Pair</code>.
     */
    private final A first;

    /**
     * Second of this <code>Pair</code>.
     */
    private final B second;

    /**
     * Gets the key for this pair.
     * @return key for this pair
     */
    public A getFirst() { return first; }

    /**
     * Gets the key for this pair.
     * @return key for this pair
     */
    public B getSecond() { return second; }

    /**
     * Creates a new pair
     * @param first The key for this pair
     * @param second The value to use for this pair
     */
    public Pair(@NamedArg("First") A first, @NamedArg("Second") B second) {
        this.first = first;
        this.second = second;
    }

    /**
     * <p><code>String</code> representation of this
     * <code>Pair</code>.</p>
     *
     * <p>The default name/value delimiter '=' is always used.</p>
     *
     *  @return <code>String</code> representation of this <code>Pair</code>
     */
    @Override
    public String toString() { return first + " , " + second; }

    /**
     * <p>Test this <code>Pair</code> for equality with another
     * <code>Object</code>.</p>
     *
     * <p>If the <code>Object</code> to be tested is not a
     * <code>Pair</code> or is <code>null</code>, then this method
     * returns <code>false</code>.</p>
     *
     * <p>Two <code>Pair</code>s are considered equal if and only if
     * both the names and values are equal.</p>
     *
     * @param o the <code>Object</code> to test for
     * equality with this <code>Pair</code>
     * @return <code>true</code> if the given <code>Object</code> is
     * equal to this <code>Pair</code> else <code>false</code>
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            if (second != null ? !second.equals(pair.second) : pair.second != null) return false;
            return true;
        }
        return false;
    }
}

