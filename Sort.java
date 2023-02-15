import java.io.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

class Sort
{
    List<String> inputList;

    public Sort()
    {
        this.inputList = new ArrayList<String>();   
    }

    // Utility method to swap two elements in an array
    public static void swap(int[] A, int p, int q)
    {
        // System.out.println("Length: " + A.length);
        // System.out.println("p: " + p);
        // System.out.println("q: " + q);
        int temporary = A[p];
        A[p] = A[q];
        A[q] = temporary;
    }

    public int[] copyArray(ArrayList<Integer> data) {
        int n = data.size();
        int[] res = new int[n];
        for (int i = 0; i<n; i++)
        {
            res [i] = data.get(i);
        }
        return res;
    }

    public int[] readArray(String path)
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