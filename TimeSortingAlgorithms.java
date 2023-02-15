public class TimeSortingAlgorithms 
{
    static String[] paths = new String[]{"datasets/int1000.txt",
                                            "datasets/int20k.txt",
                                            "datasets/int500k.txt",
                                            "datasets/dutch.txt",
                                            "datasets/intBig.txt",};

    public static long determineTime(String path, int sortType)
    {
        Sort sort = new Sort();
        // QuickSort quick = new QuickSort();
        int[] unsortedList = sort.readArray(path);
        long time1, time2;
        switch(sortType)
        {
            case 1:
                time1 = System.nanoTime();
                QuickSort.Quicksort(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                break;
            case 2:
                time1 = System.nanoTime();
                QuickSort.callInsertion(unsortedList);
                time2 = System.nanoTime();
                break;
            case 3:
                time1 = System.nanoTime();
                QuickSort.QuicksortMedianOfThree(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                break;
            case 4:
                time1 = System.nanoTime();
                QuickSort.ThreeWayQuicksort(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                break;
            case 5:
                time1 = System.nanoTime();
                InsertionSort.Insertionsort(unsortedList);
                time2 = System.nanoTime();
                break;
            case 6:
                time1 = System.nanoTime();
                MergeSortClass.MergeSort(unsortedList, 0, unsortedList.length - 1);
                time2 = System.nanoTime();
                break;
            default:
                time1 = 0;
                time2 = 0;
        }
        return time2 - time1;
    }

    public static void outputStats(String path)
    {
        System.out.println(path);
        
        long timeA = determineTime(path, 1);
        System.out.println("1a - Basic Quicksort: " + timeA + " milliseconds");
        
        long timeB = determineTime(path, 2);
        System.out.println("1b - Quicksort w/ Insertion: " + timeB + " milliseconds");

        long timeC = determineTime(path, 3);
        System.out.println("1c - Quicksort w/ Median: " + timeC + " milliseconds");

        long timeD = determineTime(path, 4);
        System.out.println("1d - Three Way Quicksort: " + timeD + " milliseconds");

        long timeE = determineTime(path, 5);
        System.out.println("Insertion Sort: " + timeE + " milliseconds");

        long timeF = determineTime(path, 6);
        System.out.println("Merge Sort: " + timeF + " milliseconds");
        
        System.out.println();
    }

    public static void main(String[] args)
    {
        for (String path : paths)
        {
            outputStats(path);
        }
    }
}
