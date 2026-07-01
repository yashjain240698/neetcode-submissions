class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int half = (l1 + l2)/2;

        if(l1 > l2){
            return findMedianSortedArrays(nums2, nums1);
        } 

        int l = 0 , r = l1-1;
        int topLeft,topRight,bottomLeft,bottomRight;
        while (true){
            int mid = Math.floorDiv((r+l),2);
            int j = half - mid - 2 ;
            topLeft = mid < 0 ? Integer.MIN_VALUE : nums1[mid];
            topRight = mid + 1 >= l1 ? Integer.MAX_VALUE : nums1[mid+1];
            bottomLeft = j < 0 ? Integer.MIN_VALUE : nums2[j];
            bottomRight = j+1 >= l2 ? Integer.MAX_VALUE : nums2[j+1];

            if((topLeft <= bottomRight) && (topRight >= bottomLeft)){
                if((l1 + l2) % 2 == 0){
                    return (Math.max(topLeft,bottomLeft) + Math.min(topRight, bottomRight))/2.0;
                } else {
                    return (double) Math.min(topRight, bottomRight);
                }
            } else if (topLeft > bottomRight) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
    }
}
