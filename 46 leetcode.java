class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> ans) {

        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int x : nums) {

            if (temp.contains(x))
                continue;

            temp.add(x);
            backtrack(nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}