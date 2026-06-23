class Solution {
public:
    vector<string> ans;
    void generateParenthesisString(int open, int close, int n, string s){
        if(open == close && open == n){
            ans.push_back(s);
            return ;
        }
        
        if(open > close){
            if(open+1 <= n)
                generateParenthesisString(open+1, close, n, s+'(');
            generateParenthesisString(open, close+1, n, s+')');
        } else if(open == close && open < n){
            generateParenthesisString(open+1, close, n, s+'(');
        }
    }
    vector<string> generateParenthesis(int n) {
        string s = "";    
        generateParenthesisString(0,0,n,s);
        return ans;
    }
};
