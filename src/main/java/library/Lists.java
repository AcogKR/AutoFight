package library;

/*
 * Created by IntelliJ IDEA
 * Developer : Acog Date : 2020-10-08/오후 4:38
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {

    @SafeVarargs
    public static <T> List<T> listOf(T... values) {
        switch (values.length) {
            case 0:
                return Collections.emptyList();
            case 1:
                return Collections.singletonList(values[0]);
            default:
                return new ArrayList(Arrays.asList(values));
        }
    }
}
