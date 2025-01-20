package kikin.dev.algorithms;

public class BinarySearch {

  public static int binarySearch(int[] values, int target) {
    int low = 0;
    int high = values.length - 1;

    while (low <= high) {
      int middle = (low + high) / 2;

      if (values[middle] == target) {
        return middle;
      } else if (values[middle] < target) {
        low = middle + 1;
      } else {
        high = middle - 1;
      }

    }
    return -1;
  }

  public static <T extends Comparable<T>> int genericBinarySearch(T[] values, T toFind) {
    int low = 0;
    int high = values.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      int cmp = toFind.compareTo(values[mid]);

      if (cmp < 0) {
        high = mid - 1;
      } else if (cmp > 0) {
        low = mid + 1;
      } else {
        return mid; // Target found at index mid
      }
    }

    return -1; // Target not found
  }

}
