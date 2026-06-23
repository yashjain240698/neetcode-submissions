class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int l = temperatures.size();
        stack<int> st;
        vector<int> ans(l,0);
        for(int i = 0 ; i < l ; i++){
            if(st.empty()){
                st.push(i);
            } else {
                while(!st.empty() && temperatures[st.top()] < temperatures[i]){
                    ans[st.top()] = i - st.top();
                    st.pop();
                }
                st.push(i);
            }
        }
        return ans;
    }
};
