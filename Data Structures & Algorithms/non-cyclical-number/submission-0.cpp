class Solution {
public:
    bool isHappy(int n) {
        int k = n;
        set<int> st;
        while(k != 1){
            st.insert(k);
            int sum = 0;
            while(k){
                sum += pow((k%10),2);
                k = k/10;
            }
            k = sum;
            if(st.find(k) != st.end())
                return false;
        }

        return true;
    }
};
