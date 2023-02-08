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
        int[] unsortedList = sort.readArray("./data/int10.txt");
        // InsertionSort insertion = new InsertionSort(unsortedList);
        SelectionSort selection = new SelectionSort(unsortedList);

        boolean success = testAscending(unsortedList);
        System.out.println(success);
    }
}
