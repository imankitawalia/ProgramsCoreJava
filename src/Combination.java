// Java program to print all combination of size r in an array of size n
import java.io.*;

class Combination {

    /* arr[] ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Starting and Ending indexes in arr[]
    index ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static int combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r, int x)
    {
        int out = 1;
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            String num ="";
            for (int j=0; j<r; j++) {
                System.out.print(data[j] + " ");
                 num = num+""+data[j];
                System.out.println("");

                System.out.print("num - "+num);
                if(Integer.parseInt(num)<=x){
                    if(Integer.parseInt(num)>out)
                    out =Integer.parseInt(num);
                }
            }
            System.out.println(""); }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r,x);
        }
        return out;
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static int  printCombination(int arr[], int n, int r, int x)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temporary array 'data[]'
        return combinationUtil(arr, data, 0, n-1, 0, r,x);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        int x = 23;
        int digitsInX = findNumberOfDigits(x);
        int large = 0;
        for (int i=digitsInX;i>0;i--) {
            large = printCombination(arr, n, digitsInX, x);
            digitsInX--;
        }
        System.out.println("largest subarray : "+large);
    }

    static int findNumberOfDigits(int number) {
        //declare a variable to count number of digits
        int digit = 0;
        while(number != 0)
        {
            //pick last digit of the number and count one by one - 23
            int pick_last = number % 10;
            digit++;
            number = number / 10;
        }

        //display number of digits
        System.out.print("Number of Digits = "+digit+"---");
        return digit;
    }
}


