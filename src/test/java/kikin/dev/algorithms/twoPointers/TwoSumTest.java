package kikin.dev.algorithms.twoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumTest {

  @Test
  void shouldFindTwoSumValues() {
    int[] nums = {1,2,3,4,5,6};
    Assertions.assertArrayEquals(new int[] {0,4}, TwoSum.twoSumSorted(nums, 6));
    int[] nums2 = {};
    Assertions.assertArrayEquals(new int[] {}, TwoSum.twoSumSorted(nums2, 6));
//    int[] nums3 = {3,2,4};
//    Assertions.assertArrayEquals(new int[] {1,2}, TwoSum.twoSum(nums3, 6));
  }

  @Test
  void shouldFindTwoSumValuesNotSorted() {
    int[] nums = {1, 2, 3, 4, 5, 6};
    int[] result = TwoSum.twoSumHashMap(nums, 6);
    Assertions.assertEquals(6, nums[result[0]] + nums[result[1]]);
    int[] nums2 = {};
    Assertions.assertArrayEquals(new int[] {}, TwoSum.twoSumHashMap(nums2, 6));
    int[] nums3 = {3,2,4};
    Assertions.assertArrayEquals(new int[] {1,2}, TwoSum.twoSumHashMap(nums3, 6));
    int[] nums4 = {2, 11, 15, 7};
    Assertions.assertArrayEquals(new int[] {0,3}, TwoSum.twoSumHashMap(nums4, 9));
  }

}
