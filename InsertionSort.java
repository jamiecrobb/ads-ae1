public class InsertionSort extends Sort
{
    public static void Insertionsort(int[] listToSort)
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
}
