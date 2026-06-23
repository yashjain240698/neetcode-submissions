class Solution {
public:
    double myPow(double x, int n) {

        if(n < 0){
            x = (double) 1/x;
            n = abs(n);
        }
        
        if(n == 0){
            return 1.00000;
        }

        if(n == 1){
            return x;
        }

        double ans = 0.0000;
        if(n%2){
            ans += myPow(x, n-1) * x;
        } else {
            double temp = myPow(x, n >> 1);
            ans += temp * temp;
        }

        return ans;
    }
};
