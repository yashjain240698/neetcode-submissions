class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int i = nums[0];
        nums[0] = -1;
        while(nums[i] != -1){
            int t = nums[i];
            nums[i] = -1;
            i = t;
        }
        return i;
    }
};
