package com.DemoApplication5;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        // write your code here
        int count = 0;
        int j = 0;
        int i = 0;
        int [] Array = new int[100];
        double sum = 0;
        Scanner input =  new Scanner(System.in);
        for (; i < Array.length;i++ )
        {
            try
            {
                System.out.print("Enter a number:");
                Array[i] = input.nextInt();
                count++;
                if (Array[i] == 0)
                    break;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input");
            }
        }
        int [] array = new int[count -1];
        int p = 0; // 1st index main array
        for (; j < array.length ;j++)
        {
            array [j] = Array[j];
            // calculating sum of the integers entered by the user
            sum = sum + array[j];
        }
        // calculating average of the integers entered by the user
        double average = sum / array.length;
        System.out.println("Number of index : " + array.length);
        System.out.println("Before sorting : ");
        for(; p < array.length;p++)
        {
            System.out.print(array[p]+ " ");

        }
        System.out.println();
        System.out.println("After sorting : ");
        array = MergeSort(array);
        for (int k : array) {
            System.out.print(k + " ");
        }
        System.out.println();
        System.out.println("the sumer is : " + sum);
        System.out.println("the average is : " + average);
    }
    public static int[] MergeSort(int[] array)
    {
        if (array.length == 1 )
        {
            return array;
        }
// Divide
        else {
            int q;
            int n;
            int i = 0;
            int j = 0;
            if (array.length % 2 != 0) {
                q = (array.length / 2) + 1;
                n = array.length - q;
            } else {
                q = array.length / 2;
                n = q;
            }
            int[] leftarray = new int[q];
            int[] rightarray = new int[n];

            while(i < array.length)
            {
                if(i < q)
                {
                    leftarray[i] = array[i];
                }
                else
                {
                    rightarray[j] = array[i];
                    j++;
                }
                i++;
            }
// recursive call
            leftarray =  MergeSort(leftarray);
            rightarray = MergeSort(rightarray);


            return Merge(leftarray, rightarray);

        }
    }


    public static int[] Merge(int[] leftarray, int[] rightarray)
    {
        int t = 0;
        int i = 0;
        int l = 0;
        int [] array = new int [leftarray.length + rightarray.length];
        // Merge
        while(l < leftarray.length && t < rightarray.length)
        {
            if (leftarray[l] < rightarray[t])
            {
                array[i] = leftarray[l];
                i++;
                l++;
            }
            else
            {
                array[i] = rightarray[t];
                i++;
                t++;
            }
        }
        while (l < leftarray.length)
        {
            array[i] = leftarray[l];
            i++;
            l++;

        }
        while (t < rightarray.length)
        {
            array[i] = rightarray[t];
            i++;
            t++;
        }

        return array;
    }
}
