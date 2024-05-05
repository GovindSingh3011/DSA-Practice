package sorting;

public class InsertionSorter {
    public void InsertionSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int currentElement = arr[index];
            int comparingIndex = index - 1;
            while (comparingIndex >= 0 && arr[comparingIndex] > currentElement) {
                arr[comparingIndex + 1] = arr[comparingIndex];
                comparingIndex--;
            }
            arr[comparingIndex + 1] = currentElement;
        }
    }
}
