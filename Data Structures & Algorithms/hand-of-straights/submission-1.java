class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            cntMap.put(hand[i], cntMap.getOrDefault(hand[i], 0) + 1);
        }
        Arrays.sort(hand);
        for (int j = 0; j < hand.length; j++) {
            int k = hand[j];
            if(cntMap.get(k) == 0){
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                if (cntMap.getOrDefault(k + i, 0) > 0)
                    cntMap.put(k + i, cntMap.get(k + i) - 1);
                else
                    return false;
            }
        }
        return true;
    }
}
