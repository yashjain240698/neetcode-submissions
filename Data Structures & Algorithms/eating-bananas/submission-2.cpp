class Solution {
public:
    long long int isValid(vector<int>& piles, long long int h){
        long long int cnt = 0;
        for(int i = 0 ; i < piles.size() ; i++){
            cnt += (piles[i] + h-1)/h;
        }
        return cnt;
    }   
    int minEatingSpeed(vector<int>& piles, int h) {
        long long int low = 1, high = *max_element(piles.begin(),piles.end());
        int ans = high;
        while(low <= high){
            long long int mid = low + (high-low)/2;

            if(isValid(piles, mid) > h){
                low = mid+1;
            } else {
                ans = mid;
                cout<<mid<<endl;
                high = mid - 1;
            }
        }
        return ans;
    }
};
