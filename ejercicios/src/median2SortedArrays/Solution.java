package median2SortedArrays;

public class Solution {

    /* 
    Time -> O(n)
    Space -> O(n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = mergeSort(nums1,nums2);
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) return nums3[(len+1)/2-1];
        else return (double)(nums3[len/2]+nums3[len/2-1])/2;
    }

    private int[] mergeSort(int[] nums1, int[] nums2) {
        int len1 = nums1.length,
            len2 = nums2.length,
            i = 0,
            j = 0;

        int[] ret = new int[len1+len2];

        for(int idx = 0; idx < len1+len2; idx++)
            ret[idx] = (i < len1 && j < len2 && nums1[i] <= nums2[j] || j >= len2) ? nums1[i++] : nums2[j++];

        return ret;
    }  */

    //Time -> O(log(min(n,m)))
    //Space -> O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length,
            y = nums2.length;
        if (x > y)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0,
            high = x,
            px,
            py,
            rx,ry,
            lx,ly;

        while(true) {
            px = (low+high)/2;
            py = (x+y+1)/2-px;

            lx = (px == 0) ? Integer.MIN_VALUE : nums1[px-1];
            rx = (px == x) ? Integer.MAX_VALUE : nums1[px];

            ly = (py == 0) ? Integer.MIN_VALUE : nums2[py-1];
            ry = (py == y) ? Integer.MAX_VALUE : nums2[py];

            if (lx <= ry && ly <= rx) {
                if ((x+y) % 2 == 0) return (double)(Math.max(lx, ly)+Math.min(rx, ry))/2;
                else return Math.min(rx, ry);
            }

            else if (ly > rx) low = px+1;
            else high = px-1;
        }
    }

}