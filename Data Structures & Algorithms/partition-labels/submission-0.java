class Solution {
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> endIndexMap = new HashMap<>();
        for(int i = 0 ; i < len ; i++){
            endIndexMap.put(s.charAt(i), i);
        }
        int currentPointer = 0;
        int windowEndIndex = -1;
        int windowStartIndex = 0;
        while(currentPointer < len){
            if(endIndexMap.get(s.charAt(currentPointer)) >= windowEndIndex){
                windowEndIndex = endIndexMap.get(s.charAt(currentPointer));
            }

            if(windowEndIndex == currentPointer){
                ans.add(windowEndIndex - windowStartIndex + 1);
                windowStartIndex = windowEndIndex+1;
            }
            currentPointer++;
        }
        return ans;
    }
}
