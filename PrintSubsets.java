class Solution {
  List<List<Integer>> output = new ArrayList();
  int n, k;

  public void backtrack(int first, ArrayList<Integer> list, int[] nums) {
    // if the combination is done
    if (list.size() == k) {
        output.add(new ArrayList(list)); 
        return ;
    }

    for (int i = first; i < n; ++i) {
      // add i into the current combination
      list.add(nums[i]);
      // use next integers to complete the combination
      backtrack(i + 1, list, nums);
      // backtrack
      list.remove(list.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    n = nums.length;
    for (k = 0; k < n + 1; ++k) {
      backtrack(0, new ArrayList<Integer>(), nums);
    }
    return output;
  }
}
