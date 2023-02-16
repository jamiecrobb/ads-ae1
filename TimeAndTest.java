public class TimeAndTest extends Sort
{
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

    public static void testAlgorithms(String path, int sortType)
    {
        int[] unsortedList = Sort.readArray(path);
        switch(sortType)
        {
            case 1:
                QuickSort.Quicksort(unsortedList, 0, unsortedList.length - 1);
                testAscending(unsortedList, "Quicksort");
                break;
            case 2:
                QuickSort.callInsertion(unsortedList, 10);
                testAscending(unsortedList, "Insertion Quicksort");
                break;
            case 3:
                QuickSort.QuicksortMedianOfThree(unsortedList, 0, unsortedList.length - 1);
                testAscending(unsortedList, "Median Quicksort");
                break;
            case 4:
                QuickSort.ThreeWayQuicksort(unsortedList, 0, unsortedList.length - 1);
                testAscending(unsortedList, "Three Way Quicksort");
                break;
            case 5:
                InsertionSort.Insertionsort(unsortedList);
                testAscending(unsortedList, "Insertion Sort");
                break;
            case 6:
                MergeSortClass.MergeSort(unsortedList, 0, unsortedList.length - 1);
                testAscending(unsortedList, "Merge Sort");
                break;
        }
    }

    public static long determineTime(String path, int sortType, int kValue)
    {
        int[] unsortedList = Sort.readArray(path);
        long time1, time2;
        switch(sortType)
        {
            case 1:
                time1 = System.nanoTime();
                QuickSort.Quicksort(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                System.out.print("    Basic Quicksort:");
                break;
            case 2:
                time1 = System.nanoTime();
                QuickSort.callInsertion(unsortedList, kValue);
                time2 = System.nanoTime();
                System.out.print("    Insertion Quicksort (k=" + kValue + "):");
                break;
            case 3:
                time1 = System.nanoTime();
                QuickSort.QuicksortMedianOfThree(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                System.out.print("    Median Quicksort:");
                break;
            case 4:
                time1 = System.nanoTime();
                QuickSort.ThreeWayQuicksort(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                System.out.print("    Three Way Quicksort:");
                break;
            case 5:
                time1 = System.nanoTime();
                InsertionSort.Insertionsort(unsortedList);
                time2 = System.nanoTime();
                System.out.print("    Insertion Sort:");
                break;
            case 6:
                time1 = System.nanoTime();
                MergeSortClass.MergeSort(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                System.out.print("    Merge Sort:");
                break;
            default:
                time1 = 0;
                time2 = 0;
        }
        System.out.print(" " + (time2 - time1) + " milliseconds\n");
        return time2 - time1;
    }

    public static void outputTimeStats(String path)
    {
        System.out.println(path);
        for (int i = 1; i <= 6; i++)
        {
            determineTime(path, i, 10);
        }
        System.out.println();
    }

    public static void timeWithK(String path)
    {
        System.out.println(path);
        for (int i = 2; i <= 512; i=i*4)
        {
            determineTime(path, 2, i);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        System.out.println("\nValidating sorting algorithms on 'int1000.txt':");
        for (int i = 1; i <= 6; i++)
        {
            testAlgorithms("datasets/int1000.txt", i);
        }
        
        System.out.println("\nRunning sorting algorithms on each dataset:\n");
        for (String path : Sort.paths)
        {
            outputTimeStats(path);
        }

        System.out.println("\nRunning Insertion Quicksort with varying k, on each dataset:\n");
        for (String path : Sort.paths)
        {
            timeWithK(path);
        }
    }
}
