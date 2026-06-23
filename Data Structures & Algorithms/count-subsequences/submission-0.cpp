class Solution {
public:
    int helper(string &s, string &t, int idx, string str){
        if(idx == s.length()){
            return str == t;
        }

        int take = 0, notTake = 0;
        take += helper(s, t, idx+1, str + s[idx]);
        notTake += helper(s, t, idx+1, str);

        return take + notTake;
    }
    int numDistinct(string s, string t) {
        string str = "";
        return helper(s, t, 0, str);
    }
};
