class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int r = 0;
        for(int u: nums){
            r ^= u;
        }
        return r;
    }
};
