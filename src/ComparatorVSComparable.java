import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparatorVSComparable {

    public static void main(String[] args){

        List<UserPojo> users = new ArrayList<>();
        users.add(new UserPojo("Ankita",7));
        users.add(new UserPojo("Roshni",19));
        users.add(new UserPojo("Deeksha",3));
        users.add(new UserPojo("Dolly",6));

        System.out.println("Before Sorting of any kind - "+users);

        System.out.println("Sorting by Age using compareTo() of Comparable Interface");
        Collections.sort(users);
        System.out.println("Sorted by Age using compareTo() of Comparable Interface - "+users);

        System.out.println("Sorting by Name using compare() of Comparator Interface");
        Collections.sort(users,new UserPojo());
        System.out.println("Sorted by Name using compare() of Comparator interface - "+users);

    }
}
