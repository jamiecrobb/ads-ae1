public class HeapSort extends Sort
{
    public static int Left(int i)
    {
        return (2*i)+1;
    }
    
    public static int Right(int i)
    {
        return (2*i)+2;
    }

    public static void MaxHeapify(int[] A, int i, int n)
    {
        int left = Left(i);
        int right = Right(i);
        int largest;

        if (left < n && A[left] > A[i])
        {
            largest = left;
        }
        else 
        {
            largest = i;
        }

        if (right < n && A[right] > A[largest])
        {
            largest = right;
        }

        if (largest != i)
        {
            swap(A, i, largest);
            MaxHeapify(A, largest, n);
        }
    }

    public static void BuildMaxHeap(int[] A)
    {
        for (int i = ((A.length / 2) - 1); i >= 0; i--)
        {
            MaxHeapify(A, i, A.length);
        }
    }

    public HeapSort(int[] listToSort)
    {
        BuildMaxHeap(listToSort);
        int s = listToSort.length;
        for (int i = listToSort.length - 1; i >= 1; i--)
        {
            swap(listToSort, 0, i);
            s = s-1;
            MaxHeapify(listToSort, 0, s);
        }
    }
}
