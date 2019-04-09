package dahei.me.compute.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * created by yubosu
 * 2019年01月28日3:53 PM
 */
public class CollectionTest {


    private <T> List<T> getDefaultList(T... params) {
        return Collections.unmodifiableList(Arrays.asList(params));
    }


    private <T> List<T> getDefaultList(List<T> list) {
        return Collections.unmodifiableList(list);
    }
}
