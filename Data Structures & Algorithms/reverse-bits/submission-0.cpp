class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        int k = 0;
        int p = 32;
        while(p--){
            k = k << 1;
            if(n&1){
                k = k | 1;
            }
            n = n >> 1;
        }
        return k;
    }
};
