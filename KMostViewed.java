public class KMostViewed extends Sort
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
            KMostViewed.swap(listToSort, 0, listToSort.length-1-i);
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
        int k = 20; // The number of videos to find
        long t1, t2, t3, t4, t5, t6;

        // Test Jamie
        int[] unsortedList = Sort.readArray("datasets/int500k.txt");
        t1 = System.nanoTime();
        int[] mostViewed = getKMostViewed(unsortedList, k);
        t2 = System.nanoTime();
        System.out.println("Jamie: " + (t2-t1));



        int[] unsortedListFin = Sort.readArray("datasets/int500k.txt");
        t3 = System.nanoTime();
        int[] finMostViewed = KLargestElements.findKLargestElements(unsortedListFin, k);
        t4 = System.nanoTime();
        System.out.println("Fin:   " + (t4-t3));


        int[] unsortedListJoe = Sort.readArray("datasets/int500k.txt");
        t5 = System.nanoTime();
        int[] joeMostViewed = KLargestElements.findKLargestElements(unsortedListJoe, k);
        t6 = System.nanoTime();
        System.out.println("Joe:   " + (t6-t5));


        // for (int video : mostViewed)
        // {
        //     System.out.println("Video had " + video + " views.");
        // }
    }
}
