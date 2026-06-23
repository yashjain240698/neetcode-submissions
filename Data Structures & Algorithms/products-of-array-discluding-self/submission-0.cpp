class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> forward;
        vector<int> backward;
        forward.push_back(1);
        backward.push_back(1);
        for(int i = 0 ; i < nums.size() ; i++){
            forward.push_back(nums[i]*forward.back());
            backward.push_back(nums[nums.size()-1-i]*backward.back());
        }
        reverse(backward.begin(),backward.end());
        vector<int> ans;
        for(int i = 1 ; i <= nums.size() ; i++){
            ans.push_back(forward[i-1]*backward[i]);
        }
        return ans;
    }
};
