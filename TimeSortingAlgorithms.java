public class TimeSortingAlgorithms 
{
    static String[] paths = new String[]{"./data/int10.txt", "./data/int50.txt", "./data/int100.txt", "./data/int1000.txt", "./data/int20k.txt",};

    public static long determineTime(String path, int sortType)
    {
        Sort sort = new Sort();
        int[] unsortedList = sort.readArray(path);
        long time1, time2;
        switch(sortType)
        {
            case 1:
                time1 = System.nanoTime();
                InsertionSort insertion = new InsertionSort(unsortedList);
                time2 = System.nanoTime();
                break;
            case 2:
                time1 = System.nanoTime();
                SelectionSort selection = new SelectionSort(unsortedList);
                time2 = System.nanoTime();
                break;
            default:
                time1 = 0;
                time2 = 0;
        }
        // long finalTime = (time2 - time1) / 1000000;
        return time2 - time1;
    }

    public static void outputStats(String path)
    {
        System.out.println(path);
        long timeInsertion = determineTime(path, 1);
        System.out.println("Insertion sort: " + timeInsertion + " milliseconds");
        long timeSelection = determineTime(path, 2);
        System.out.println("Selection sort: " + timeSelection + " milliseconds");
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
