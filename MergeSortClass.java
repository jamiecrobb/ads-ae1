public class MergeSortClass 
{
    static int[] Merge(int[] A, int p, int q, int r)
    {
        int n1 = q-p+1;
        int n2 = r-q;
        
        int[] L = new int[n1+1];
        for (int i = 0; i < n1; i++)
        {
            L[i] = A[p+i];
        }

        int[] R = new int[n2+1];
        for (int i = 0; i < n2; i++)
        {
            R[i] = A[q+1+i];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++)
        {
            if (L[i] <= R[j])
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = R[j];
                j++;
            }
        }
        return A;
    }

    static void MergeSort(int[] A, int p, int r)
    {
        if (p < r)
        {
            int q = (p+r) / 2;
            MergeSort(A, p, q);
            MergeSort(A, q+1, r);
            Merge(A, p, q, r);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{3,2,5,1,4};
        System.out.println("Unsorted list:");
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n\nSorted list: ");
        MergeSort(arr, 0, arr.length - 1);
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
