class Solution {
    List<List<Integer>> l = new ArrayList<>();
    private void helper(int[] nums, int idx){
        if(idx == nums.length){
            l.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i = idx ; i < nums.length ; i++){
            int k = nums[i];
            nums[i] = nums[idx];
            nums[idx] = k;
            helper(nums, idx+1);
            k = nums[i];
            nums[i] = nums[idx];
            nums[idx] = k;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        l = new ArrayList<>();
        helper(nums, 0);
        return l;
    }
}
