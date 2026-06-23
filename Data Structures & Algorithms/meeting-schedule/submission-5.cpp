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
    bool canAttendMeetings(vector<Interval>& intervals) {
        if(intervals.size() == 0)
            return true;
        vector<int> v(1000010, 0);
        for(int i = 0; i < intervals.size() ; i++){
            v[intervals[i].start]++;
            v[intervals[i].end]--;
        }

        for(int i = 1 ; i < 1000010 ; i++){
            v[i] += v[i-1];
            //cout<<v[i]<<" ";
            if(v[i] > 1)
                return false;
        }
        return true;
    }
};
