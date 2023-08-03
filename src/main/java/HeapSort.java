import java.util.Random;

// Реализовать пирамидальную сортировку
public class HeapSort {
    public void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) largest = left;

        if (right < n && array[right] > array[largest]) largest = right;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    static void printArray(int[] array) {
        int n = array.length;
        for (int j : array) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = new int[new Random().nextInt(10,21)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(101);
        }
        System.out.println("Исходный массив для сортировки: ");
        printArray(arr);
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        System.out.println("Готов отсортированый массив: ");
        printArray(arr);
    }
}

