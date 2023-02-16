import java.io.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

class Sort
{
    // Make sure to change this if the data files are not in a directory, datasets.
    public static String[] paths = new String[]{"datasets/int1000.txt",
                                            "datasets/int20k.txt",
                                            "datasets/int500k.txt",
                                            "datasets/dutch.txt",
                                            "datasets/intBig.txt",};

    List<String> inputList;

    public Sort()
    {
        this.inputList = new ArrayList<String>();   
    }

    // Utility method to swap two elements in an array
    public static void swap(int[] A, int p, int q)
    {
        int temporary = A[p];
        A[p] = A[q];
        A[q] = temporary;
    }

    public static int[] copyArray(ArrayList<Integer> data) {
        int n = data.size();
        int[] res = new int[n];
        for (int i = 0; i<n; i++)
        {
            res [i] = data.get(i);
        }
        return res;
    }

    public static int[] readArray(String path)
    {    
        ArrayList<Integer> data = new ArrayList<Integer>();
        try
        {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNextInt()) 
            {
                data.add(sc.nextInt());
            }
        } 
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        return copyArray(data);
    }
}