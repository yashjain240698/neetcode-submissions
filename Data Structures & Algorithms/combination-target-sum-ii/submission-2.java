class Solution {
    List<List<Integer>> s = new ArrayList<>();
    private void helper(int[] candidates, int idx, int target, List<Integer> l) {
        if (target == 0) {
            s.add(new ArrayList(l));
            return;
        }
        
        if (idx < 0 || target < 0) {
            return;
        }
        int j = idx;
        while(j >= 0 && candidates[j] == candidates[idx]){
            j--;
        }
        helper(candidates, j, target, l);
        if (candidates[idx] <= target) {
            l.add(candidates[idx]);
            helper(candidates, idx - 1, target - candidates[idx], l);
            l.remove(l.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, candidates.length - 1, target, new ArrayList());
        return s;
    }
}
