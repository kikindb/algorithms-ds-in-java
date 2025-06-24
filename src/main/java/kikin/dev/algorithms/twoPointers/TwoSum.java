package kikin.dev.algorithms.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  // given an array of sorted numbers, find 2 numbers that sum target value
  public static int[] twoSumSorted (int[] numbers, int target) {
    int low = 0;
    int high = numbers.length - 1;

    while (low < high) {
      int sum = numbers[low] + numbers[high];
      System.out.println(sum);
      if (sum == target) return new int[] {low, high};
      else if (sum < target) low++;
      else high--;
    }

    return new int[]{};
  }

  public static int[] twoSumHashMap (int [] nums, int target) {
    Map<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (hashMap.containsKey(complement)) {
        return new int[]{hashMap.get(complement), i};
      }

      hashMap.put(nums[i], i);
    }
    return new int[]{};
  }


}
