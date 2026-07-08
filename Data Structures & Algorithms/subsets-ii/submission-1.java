class Solution {
    Set<List<Integer>> s = new HashSet<>();
    private void helper(int[] nums, int idx, List<Integer> l){
        if(idx >= nums.length){
            s.add(new ArrayList(l));
            return;
        }
        int j = idx;
        while((j < nums.length) && (nums[j] == nums[idx])){
            j++;
        }
        helper(nums, idx+1, l);
        l.add(nums[idx]);
        helper(nums, idx+1, l);
        l.remove(l.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return s.stream().collect(Collectors.toList());
    }
}
