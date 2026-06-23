class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        Set<List<Integer>> s = new HashSet<>();
        int f,r;
        for(int i = 0 ; i < l-2 ; i++){
            f = i+1;
            r = l-1;
            while(f<r){
                if(nums[i] + nums[f] + nums[r] == 0){
                    s.add(Arrays.asList(nums[i], nums[f], nums[r]));
                    f++;
                    r--;
                } else if(nums[i] + nums[f] + nums[r] < 0){
                    f++;
                } else {
                    r--;
                }
            } 
        }
        List<List<Integer>> ans = new ArrayList<>(); 
        for(List<Integer> arr: s){
            ans.add(arr);
        }
        return ans;
    }
}
