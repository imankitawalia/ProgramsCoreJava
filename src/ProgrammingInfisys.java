import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgrammingInfisys {

    public static void main(String args[]) {

        int[] a = {0,0,0,1,0};

        List<List<Integer>> Qry = new ArrayList<>();

        //if(Qry.get(0) ==1) {
            int[] q2 = query2(a, 1, 0);
            System.out.println("Query 2- " + q2);
        //}

        //if(Qry.get(0)  ==0) {
            int[] q1 = query1(a, 1, 0);
            System.out.println("Query 1 - " + q1);
        //}

        //return a[k];

    }

    static int[]  query2 (int[] a,int q1,int q2){

            a  = Arrays.copyOf(a, a.length + 1);
            a[a.length - 1] = q2;

        return a;


    }
    static int[]  query1 (int[] a,int q1,int q2){
        int[] pre = new int[a.length - 1];
        int[] suf = new int[a.length - 1];
        if(q1 == 0) {
          if(a[0]==1){
                return  arrayCopy(a,0);
            }
            else {
                int index = 0;
                 for(int i = 0;i<a.length;i++){
                     if(a[i]==1){
                         index = i;
                     }
                }
                pre= arrayCopy(a,index);
                for(int i = index;i<a.length;i++){
                    int j=0;
                    suf[j] = a[i];j++;
                }
                if(pre.length > suf.length){
                    return pre;
                }else return suf;
            }
        } return a;

    }

    static int[] arrayCopy(int[] a, int index){
        int[] copy = new int[a.length - 1];
        for (int i = 0, j = 0; i < a.length; i++) {
            if (i != index) {
                copy[j++] = a[i];
            }
        }
        return copy;
    }

}
