import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayPrograms {

    public static void main(String args[]) {

        int[] my_array1 = {1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456};

        String[] my_array2 = {"Java", "Python", "PHP", "C#", "C Programming", "C++"};

        int[] my_array = {1, 2, 3, 5, 6};

        Integer[] arr3 = new Integer[]{1,2,3,4,5,1,2,3,4,5,5,3,3,3,3,4,4,4,4,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1};
        List<Integer> numArray =  Arrays.asList(arr3);

        Integer[] arrNumbs = {1,2,3,4,5,6,7,8,9,10};
        String str = "Hello";

        //Functional Interface - inbuilt
        String rev = reverseFunction.apply(str);
        System.out.println("Rev : " + rev);

        // Test custom functional interface
        //MyFunctionalInterface test1 = s -> System.out.println("Hi! "+s);
        //test1.testFun("Monali");
        MyFunctionalInterface test1 = s ->  "Hi! "+s;
        System.out.println(test1.testFun("Monalisa"));

        List<UserPojo> users = new ArrayList<>();
        users.add(new UserPojo("Ankita",7));
        users.add(new UserPojo("Roshni",19));
        users.add(new UserPojo("Deeksha",3));
        users.add(new UserPojo("Dolly",6));

        sortArray(my_array1, my_array2);
        insertArray(my_array, 3, 4);

        parseUsingIterator();

        sortMapByKey1();
        sortMapByValue();

        sortListInt();
        sortListString();
        sortUserByAge(users);
        sortUserByName(users);
        filterByAge(users);
        mapAge(users);
        sortAndFilter(users);
        countInt(numArray);
        getLargestNumber(arrNumbs);
    }


    static  void getLargestNumber(Integer[] arr1){
        List<Integer> list = Arrays.asList(arr1);
        /*List<Integer> largeNumbers = list.stream().map(x -> x*5)
                .filter(i -> i > 20).collect(Collectors.toList());*/

        List<Integer> largeNumbers = list.stream()
                .filter(i -> i*5>20)
                .collect(Collectors.toList());
        System.out.println("Numbers greater than 20" +largeNumbers);

    }

    static void sortArray(int[] arr1, String[] arr2) {
        Arrays.sort(arr1);
        System.out.println("SortArray number Array  " + Arrays.toString(arr1));
        Arrays.sort(arr2);
        System.out.println("SortArray number String  " + Arrays.toString(arr2));
    }

    static void insertArray(int[] arr, int index, int num) {
        System.out.println("Array before insertion : " + Arrays.toString(arr));
        int[] newArray = new int[arr.length + 1];
        int i = 0;
        for (int numb : arr) {

            if (i == index) {
                System.out.println("In IF i :" + i + " numb : " + numb);
                newArray[i] = num;
                System.out.println("New Array in IF 1 : " + Arrays.toString(newArray));
                i++;
                newArray[i] = numb;
                System.out.println("New Array in IF 2 : " + Arrays.toString(newArray));

            } else {

                System.out.println("In ELSE i :" + i + " numb : " + numb);
                newArray[i] = numb;

            }
            System.out.println("New Array : " + Arrays.toString(newArray));
            i++;
        }
        //System.out.println("Array after insertion : "+Arrays.toString(newArray));

    }

    static Function<String, String> reverseFunction = s -> new StringBuilder(s).reverse().toString();

    static void parseUsingIterator(){
        Map<String,String> unsortedMap = new HashMap<String,String>();
        unsortedMap.put("D","Deeksha");
        unsortedMap.put("R","Roshni");
        unsortedMap.put("A","Ankita");


        System.out.println("Print unsorted Map "+unsortedMap.toString());
        Map<String,String> sorted2 = new HashMap<>();
                unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(x->{System.out.println("Key --"+x.getKey()+" , Value : "+x.getValue());
                sorted2.put(x.getKey(), x.getValue());});
                //.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldVale,newValue)->oldVale,HashMap::new));
        System.out.println("Parsing through Map by Iterator");
        Iterator i  = sorted2.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry<String,String> mapSet = (Map.Entry<String,String>)i.next();
            System.out.println("mapSet --- "+mapSet+" Key : "+mapSet.getKey()+" Value : "+mapSet.getValue());
        }

    }

    static void sortMapByValue(){
        Map<String,String> unsortedMap = new HashMap<String,String>();
        unsortedMap.put("D","Deeksha");
        unsortedMap.put("R","Roshni");
        unsortedMap.put("A","Ankita");


        Map<String,String> sorted = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldV,newV)->oldV, LinkedHashMap::new));
        System.out.println("sorted map by value "+sorted.toString());
    }

    static void sortMapByKey1(){
        Map<String,String> unsortedMap = new HashMap<String,String>();
        unsortedMap.put("D","Deeksha");
        unsortedMap.put("R","Roshni");
        unsortedMap.put("A","Ankita");

        Map<String,String> sorted = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldV,newV)->oldV, LinkedHashMap::new));
        System.out.println("sorted map by Key "+sorted.toString());
    }

    static void sortListInt() {
        Integer[] a = new Integer[] {12,2,32,78,65,4,10,8,7,6,99};
        List<Integer> newL = Arrays.asList(a);
        List<Integer> sorted = newL.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Array : "+sorted);

        List<Integer> reversed = newL.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted Array in reversed order: "+reversed);
    }

    static void sortListString() {
        String[] str = new String[] {"Hello","Age","Number","Name","Please"};
        List<String> ls = Arrays.asList(str).stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted String Array  : "+ls);

        List<String> reversed = Arrays.asList(str).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted String Array in reversed order: "+reversed);
    }
    static void sortUserByAge(List<UserPojo> users) {
        List<UserPojo> usr = users.stream().sorted(Comparator.comparingInt(UserPojo::getAge))
                .collect(Collectors.toList());
        for(UserPojo us : usr) {
            System.out.println("1 User Name : " + us.getName()+" User Age : "+us.getAge());
        }
    }

    static void sortUserByName(List<UserPojo> users) {
        List<UserPojo> usr = users.stream().sorted(Comparator.comparing(UserPojo::getName))
                .collect(Collectors.toList());
        for(UserPojo us : usr) {
            System.out.println("2 User Name : " + us.getName()+" User Age : "+us.getAge());
        }
    }

    static void filterByAge(List<UserPojo> users) {
        List<UserPojo> usr = users.stream().filter(x->x.getAge()>5).collect(Collectors.toList());
        for(UserPojo us : usr) {
            System.out.println("3 User Name : " + us.getName()+" User Age : "+us.getAge());
        }
    }

    static void mapAge(List<UserPojo> users) {
        List<Integer> usr = users.stream().map(x->  x.getAge() *10).filter(x-> x<90).collect(Collectors.toList());
        for(Integer us : usr) {
            System.out.println("Double of emp age :"+us);
        }
    }
    static void sortAndFilter(List<UserPojo> users){
        List<UserPojo> usr = users.stream().filter(x->x.getName().startsWith("D")).sorted(Comparator.comparing(UserPojo::getName)).collect(Collectors.toList());
         for(UserPojo us : usr) {
            System.out.println("4 User Name : " + us.getName()+" User Age : "+us.getAge());
        }
    }
    static void countInt(List<Integer> numArray){
        Map<Integer,Integer> counts =new HashMap<>();
         List<Integer> reverseList = numArray.stream().sorted(Comparator.reverseOrder()).map(x-> {
            if(counts.get(x)==null){
                counts.put(x,1);
            }else{
                counts.put(x,counts.get(x)+1);
            }
           return x;
        }).collect(Collectors.toList());
         System.out.println("reverseList : "+reverseList);
         for(Map.Entry count : counts.entrySet()){
             System.out.println(count.getKey() +"-"+count.getValue());
         }

         Optional<Integer> x = numArray.stream().max((i,j)->i.compareTo(j));
         System.out.println("Max number in array "+x);
    }



}