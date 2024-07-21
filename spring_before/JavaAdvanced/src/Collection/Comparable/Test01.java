package Collection.Comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Park", "203923"));
        list.add(new Person("Lee", "359332"));
        list.add(new Person("Jung", "123456"));

        Collections.sort(list);
        System.out.println(list);

    }
}
