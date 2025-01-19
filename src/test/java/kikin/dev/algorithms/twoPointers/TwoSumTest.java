package kikin.dev.algorithms.twoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoSumTest {

  @Test
  void shouldFindTwoSumValues() {
    int[] nums = {1,2,3,4,5,6};
    Assertions.assertArrayEquals(new int[] {0,4}, TwoSum.twoSum(nums, 6));
    int[] nums2 = {};
    Assertions.assertArrayEquals(new int[] {}, TwoSum.twoSum(nums2, 6));
  }

}
