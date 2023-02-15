public class TestSortingAlgorithms 
{   
    public static boolean testAscending(int[] sortedList)
    {
        for (int i = 1; i < sortedList.length; i++)
        {
            if (sortedList[i] < sortedList[i-1])
            {
                return false;
            }
        }
        return true;
    }
    public static boolean testDescending(int[] sortedList)
    {
        for (int i = 1; i < sortedList.length; i++)
        {
            if (sortedList[i] > sortedList[i-1])
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Sort sort = new Sort();
        int[] unsortedList = sort.readArray("./datasets/intBig.txt");
        // InsertionSort insertion = new InsertionSort(unsortedList);
        // SelectionSort selection = new SelectionSort(unsortedList);
        HeapSort heap = new HeapSort(unsortedList);

        boolean success = testAscending(unsortedList);
        for (int i = unsortedList.length - 1; i > unsortedList.length - 10; i--)
        {
            System.out.println(unsortedList[i]);
        }
        System.out.println(success);
    }
}
