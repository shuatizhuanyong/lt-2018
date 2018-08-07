
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int total = n + m;
        if (total % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, total / 2) + findKth(nums1, 0, nums2, 0, (total / 2) + 1)) / 2;
        } else {
            return findKth(nums1, 0, nums2, 0, total / 2);
        }
    }

    private double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int n = nums1.length, m = nums2.length;
        if (n - start1 < m - start2) {
            return findKth(nums2, start2, nums1, start1, k);
        }
        if (start2 == nums2.length - 1) {
            return nums1[start1 + k];
        }
        if (k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int hk1 = nums1[start1 + (k / 2)];
        int offset2 = Math.min(k - (k / 2), (nums2.length - 1 - start2));
        if (hk1 > nums2[offset2]) {
            return findKth(nums1, start1, nums2, offset2, k - offset2 );
        }
        return findKth(nums1, start1 + (k / 2), nums2, start2, k - (k / 2));
    }  
}
