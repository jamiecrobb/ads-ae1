public class QuickSort  
{
    // Part 1, a
    // PARTITION(A,p,r)
    // x := A[r]
    // i := p – 1
    // for j = p to r - 1
    //     if A[j] <= x
    //         i := i + 1
    //         SWAP(A[i],A[j])
    // SWAP(A[i+1],A[r])
    // return i + 1
    static int Partition(int[] A, int p, int r)
    {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++)
        {
            if (A[j] <= x)
            {
                i++;
                int ai = A[i];
                int aj = A[j];
                A[i] = aj;
                A[j] = ai;
            }
        }
        int ai1 = A[i+1];
        int ar = A[r];
        A[i+1] = ar;
        A[r] = ai1;
        return i + 1;
    }


    // QUICKSORT(A,p,r)
    //   if p < r
    //     q := PARTITION(A,p,r)
    //     QUICKSORT(A,p,q-1)
    //     QUICKSORT(A,q+1,r)
    static void Quicksort(int[] A, int p, int r)
    {
        if (p < r)
        {
            int q = Partition(A, p, r);
            Quicksort(A, p, q-1);
            Quicksort(A, q+1, r);
        }
    }

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

    // Part 1, b
    // QUICKSORT (with INSERTION-SORT)
    // When calling QUICKSORT on a subarray with fewer than k elements, 
    // return without sorting the subarray
    // After the top-level call to QUICKSORT returns, 
    // run INSERTION-SORT on the entire array to finish the sorting process
    static void QuicksortInsertion(int[] A, int p, int r, int k)
    {
        if ((r - p) < k)
        {
            // DO NOTHING??
            System.out.print("");
        }
        else if (p < r)
        {
            int q = Partition(A, p, r);
            Quicksort(A, p, q-1);
            Quicksort(A, q+1, r);
        }
        InsertionSort(A);
    }


    public static void main(String[] args)
    {
        // Part 1a
        int[] arr = new int[]{3,2,5,1,4,8,6,-1};
        System.out.println("Unsorted list:");
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n\nPart 1A: Sorted list: ");
        Quicksort(arr, 0, arr.length - 1);
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        
        // Part 1b
        int[] arr2 = new int[]{3,2,5,1,4,8,6,-1};
        System.out.println("\n\nPart 1A: Sorted list: ");
        QuicksortInsertion(arr2, 0, arr2.length - 1, 3);
        for (int i : arr2)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }




    // Part 1, c
    // Median-of-three PARTITION


    // Part 1, d
    // 3-WAY-QUICKSORT
}  