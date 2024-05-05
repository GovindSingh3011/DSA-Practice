package sorting;

public class SelectionSorter {
    public void SelectionSort(int[] arr) {
        for (int counter = 0; counter < arr.length - 1; counter++) {
            int swap = counter;

            for (int index = counter + 1; index < arr.length; index++) {
                if (arr[index] < arr[swap]) {
                    swap = index;
                }
            }

            int temp = arr[counter];
            arr[counter] = arr[swap];
            arr[swap] = temp;
        }

    }
}
