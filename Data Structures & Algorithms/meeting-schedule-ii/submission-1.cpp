/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        if(intervals.size() == 0)
            return 0;
        vector<int> v(1000010, 0);
        int ans = 0;
        for(int i = 0; i < intervals.size() ; i++){
            v[intervals[i].start]++;
            v[intervals[i].end]--;
        }

        for(int i = 1 ; i < 1000010 ; i++){
            v[i] += v[i-1];
            ans = max(ans, v[i]);
        }
        return ans;
    }
};
