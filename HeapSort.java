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

    public static void BuildMaxHeap(int[] A, int length)
    {
        for (int i = (length - 1); i >= 0; i--)
        {
            MaxHeapify(A, i, length);
        }
    }

    public static int[] getKMostViewed(int[] listToSort, int k)
    {
        int[] mostViewed = new int[k];
        for (int i = 0; i < k; i++)
        {
            BuildMaxHeap(listToSort, listToSort.length - i);
            mostViewed[i] = listToSort[0];
            HeapSort.swap(listToSort, 0, listToSort.length-1-i);
            // listToSort[0] = 0;
        }
        return mostViewed;
    }

    public static boolean testAscending(int[] sortedList, String algorithm)
    {
        for (int i = 1; i < sortedList.length; i++)
        {
            if (sortedList[i] < sortedList[i-1])
            {
                return false;
            }
        }
        System.out.print("    " + algorithm + " worked successfully.\n");
        return true;
    }

    public static void main(String[] args)
    {
        int k = 50; // The number of videos to find
        int[] unsortedList = Sort.readArray("datasets/int500k.txt");

        int[] mostViewed = getKMostViewed(unsortedList, k);
        for (int video : mostViewed)
        {
            System.out.println("Video had " + video + " views.");
        }
    }
}
