package median2SortedArrays;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {18,20},
              nums2 = {1,2,3,13,19,20,20,20,24,28,100,101,102,103,104,105,106,107,200,300,400,400,401,600,700,758,900};

        System.out.println((new Solution()).findMedianSortedArrays(nums1, nums2));
    }
}