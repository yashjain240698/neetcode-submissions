class Solution {
public:
    bool helper(string &s1, string &s2, string &s3, int i, int j , int k){
        if(i == s1.length() && k == s3.length() || j == s2.length() && k == s3.length()){
            return true;
        }
        bool ans = false;
        if(s1[i] == s3[k]){
            ans = ans | helper(s1,s2,s3,i+1,j,k+1);
        } 
        if(s2[j] == s3[k]) {
            ans = ans | helper(s1,s2,s3,i,j+1,k+1);
        }

        return ans;
    }
    bool isInterleave(string s1, string s2, string s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        return helper(s1, s2, s3, 0, 0, 0);
    }
};
