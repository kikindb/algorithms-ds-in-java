package kikin.dev.algorithms.twoPointers;

public class TwoSum {

  // given an array of sorted numbers, find 2 numbers that sum target value
  public static int[] twoSum (int[] numbers, int target) {
    int low = 0;
    int high = numbers.length - 1;
    // {1,2,3,4,5,6}
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      System.out.println(sum);
      if (sum == target) return new int[] {low, high};
      else if (sum < target) low++;
      else high--;
    }

    return new int[]{};
  }


}
