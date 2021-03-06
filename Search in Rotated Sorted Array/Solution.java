// https://leetcode.com/problems/search-in-rotated-sorted-array
// 
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// You are given a target value to search. If found in the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.
public class Solution {
    private int getMid(int left, int right) {
        return  left + (right - left) / 2;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = getMid(left, right);
        boolean isRotated = false;
        while (nums[left] > nums[right]) {
            isRotated = true;
            mid = getMid(left, right);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (target <= nums[mid] && target >= nums[0]) {
            left = 0;
            right = mid + 1;
        } else {
            left = mid;
            right = nums.length - 1;
        }
        if (!isRotated) {
            left = 0;
            right = nums.length - 1;
        }
        while (left < right) {
            mid = getMid(left, right);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
