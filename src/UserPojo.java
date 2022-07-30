import java.util.Comparator;

public class UserPojo implements Comparable<UserPojo>, Comparator<UserPojo> {

    String name;
    int age;

    public UserPojo() {
    }

    public UserPojo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(UserPojo obj) {
        System.out.println("compareTo() of Comparable Interface is called");
       /* if(this.getAge() == obj.getAge())
            return 0;
        if(this.getAge() > obj.getAge())
        return 1;
        else
            return -1;*/
        // OR
        return this.getAge() - obj.getAge();
    }

    @Override
    public int compare(UserPojo o1, UserPojo o2) {
        System.out.println("compare() of Comparator Interface is called");
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
