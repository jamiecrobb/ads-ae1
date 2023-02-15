public class QuickSort  
{
    // Utility method to swap two elements in an array
    public static void swap(int[] A, int p, int q)
    {
        int temporary = A[p];
        A[p] = A[q];
        A[q] = temporary;
    }

    // Part 1, a
    public static int Partition(int[] A, int p, int r)
    {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++)
        {
            if (A[j] <= x)
            {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i+1, r);
        return i + 1;
    }

    public static void Quicksort(int[] A, int p, int r)
    {
        if (p < r)
        {
            int q = Partition(A, p, r);
            Quicksort(A, p, q-1);
            Quicksort(A, q+1, r);
        }
    }

    // Part 1, b
    public static void InsertionSort(int[] listToSort)
    {
        for (int j = 1; j < listToSort.length; j++)
        {
            int key = listToSort[j];
            int i = j - 1;
            while (i >= 0 && listToSort[i] > key)
            {
                listToSort[i+1] = listToSort[i];
                i--;
            }
            listToSort[i+1] = key;
        }
    }

    public static void QuicksortInsertion(int[] A, int p, int r, int k)
    {
        if ((r - p) < k)
        {
            return;
        }
        else if (p < r)
        {
            int q = Partition(A, p, r);
            QuicksortInsertion(A, p, q-1, k);
            QuicksortInsertion(A, q+1, r, k);
        }
    }

    public static void callInsertion(int[] A)
    {
        QuicksortInsertion(A, 0, A.length - 1, 10);
        InsertionSort(A);
    }

    // Part 1c
    public static void sortElements(int[] A, int left, int right)
    {
        // Sort the left, right and middle elements
        int middle = (right + left) / 2;
        if (A[left] > A[middle])
        {
            swap(A, left, middle);
        }
        if (A[left] > A[right])
        {
            swap(A, left, right);
        }
        if (A[middle] > A[right])
        {
            swap(A, middle, right);
        }
        // Make the median element the second-to-right element
        swap(A, middle, right - 1);
    }

    public static void QuicksortMedianOfThree(int[] A, int p, int r)
    {
        if (p < r)
        {
            sortElements(A, p, r);
            int q = Partition(A, p, r);
            QuicksortMedianOfThree(A, p, q-1);
            QuicksortMedianOfThree(A, q+1, r);
        }
    }

    // Part 1d
    public static int[] ThreeWayPartition(int[] A, int p, int r)
    {
        int start = p;
        int end = r;
        int x = A[p];
        for(int i = start + 1 ; i <= end; i++)
        {
            if(A[i] < x)
            {
                swap(A, i, start);
                start++;
            }
            else if(A[i] > x)
            {
                swap(A, i, end);
                end--; 
                i--;
            }
        }
        int[] results = {start, end};
        return results;
    }

    public static void ThreeWayQuicksort(int[] A, int p, int r)
    {
        if (p < r)
        {
            int[] values = ThreeWayPartition(A, p, r);
            int start = values[0];
            int end = values[1];
            ThreeWayQuicksort(A, p, start-1);
            ThreeWayQuicksort(A, end+1, r);
        }
    }


    public static void main(String[] args)
    {
        // // Part 1a
        // System.out.println("Part 1a:");
        // int[] arr = new int[]{3,2,5,1,4,8,6,-1};
        // for (int i : arr)
        // {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // Quicksort(arr, 0, arr.length - 1);
        // for (int i : arr)
        // {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("----------------------------------------------------------------");

        // // Part 1b
        // System.out.println("Part 1b:");
        // int[] arr2 = new int[]{3,2,5,1,4,8,6,-1};
        // for (int i : arr2)
        // {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // Quicksort(arr2, 0, arr2.length - 1);
        // for (int i : arr2)
        // {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("----------------------------------------------------------------");

        // Part 1c
        System.out.println("Part 1c:");
        int[] arr3 = new int[]{3,2,5,1,4,8,6,-1};
        for (int i : arr3)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        QuicksortMedianOfThree(arr3, 0, arr3.length - 1);
        for (int i : arr3)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------");

        // Part 1d
        System.out.println("Part 1d:");
        int[] arr4 = new int[]{3,2,5,1,4,8,6,-1};
        for (int i : arr4)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        ThreeWayQuicksort(arr4, 0, arr4.length - 1);
        for (int i : arr4)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------");
    }
}  