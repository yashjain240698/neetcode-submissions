class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int c = 1, temp;
        vector<int> ans;
        for(int i = digits.size()-1 ; i>= 0 ; i--){
            temp = c + digits[i];
            c = temp > 9 ? 1 : 0;
            ans.push_back(temp%10); 
        }
        if(c)
            ans.push_back(1);
        reverse(ans.begin(),ans.end());
        return ans;
    }
};
