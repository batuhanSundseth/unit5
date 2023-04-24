public class Runtime {
  public static void main(String[] args) {

  }

  public static int missingNumber(int[] nums, int maxNum) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    for (int i = 1; i <= maxNum; i += 1) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return 0;
  }

  public static int missingNumberSort(int[] nums, int maxNum) {
    Arrays.sort(nums);
    for (int i = 1; i < maxNum; i += 1) {
      if (i != nums[i - 1]) {
        return i;
      }
    }
    if (nums.length == maxNum && nums[maxNum - 1] == maxNum) {
      return 0;
    }
    return maxNum;
  }

  public static int missingNumberSum(int[] nums, int maxNum) {
    int expectedSum = 0;
    for (int i = 1; i <= maxNum; i += 1) {
      expectedSum += i;
    }
    int actualSum = Arrays.stream(nums).sum();
    return expectedSum - actualSum;
}