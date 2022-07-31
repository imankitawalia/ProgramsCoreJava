import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main (String[] args) {
        List<Long> l = new ArrayList<>();
        l.add(Long.valueOf(503));
        l.add(Long.valueOf(2));
        l.add(Long.valueOf(5));
        l.add(Long.valueOf(20));
        int a = findLength(4,l,"25615");

    }


    public static int findLength(int N, List<Long> A, String x)
    {
        int count =0;
        Long givenNumber = Long.parseLong(x);
        String number = String.valueOf(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            String current  = String.valueOf(A.get(i));
            Long currentNumber = Long.parseLong(number+current);
            if(currentNumber<=givenNumber)
                count++;
            number = current;
        }
        return count;
    }
}
