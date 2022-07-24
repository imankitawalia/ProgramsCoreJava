import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringPrograms {



    public static void main(String args[]){
        System.out.println("Hello");
        String x = "hello";
        reverseString(x);
        reverseStringUsingStringBuilder(x);
        String arr[] = {"geoeksforgeeks","geoneks","geoeks","geoezer","geokk"};
        longestCommonPrefixInAnArray(arr);
    }

    static void reverseString(String x){
        char[] stringArr = x.toCharArray();
        int size = stringArr.length;
        System.out.println("Size : "+size);
        char[] revString = new char[size];
        for(int i=size-1; i>=0;i--){
            int n =0;
            revString[n++] = stringArr[i];
        }
        System.out.println("revString : "+size);
    }


    static void reverseStringUsingStringBuilder( String x){
        StringBuilder rev = new StringBuilder(x);
        System.out.println("Reverse of "+x+" is "+rev.reverse());
    }

    static void longestCommonPrefixInAnArray(String[] arr) {
        List<String> strArr = Arrays.asList(arr);
        System.out.println("Unsorted array : "+strArr);
        Collections.sort(strArr);
        System.out.println("Sorted array : "+strArr);
        //sort list to get the min character string
        String minString = strArr.get(0);
        System.out.println("Min String : "+minString);
        for(String str : strArr){
            if(str.contains(minString)){
                System.out.println(minString+" min string found in  "+str);
            }else {
                if(minString.length()>0) {
                    minString = minString.substring(0, minString.length() - 1);
                    System.out.println("Min string after change  " + minString);
                }else {
                    System.out.println("No Min string found " + minString);
                    return;
                }
            }
        }
        System.out.println("Min string found is  "+minString);
    }
}
