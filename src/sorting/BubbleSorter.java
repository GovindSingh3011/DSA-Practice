package sorting;

public class BubbleSorter {
    public void bubbleSort(int[] arr) {
        for (int counter = 0; counter < arr.length; counter++) {
            for (int index = 0; index < arr.length - 1; index++) {
                if (arr[index] > arr[index + 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                }
            }
        }
    }
}
