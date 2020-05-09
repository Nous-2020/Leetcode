class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);   //每次保证前一个数组长度不大于第二个数组
        }
        int left = 0;
        int right = n1;
        int k = (n1+n2+1)/2;                              //目的是找到中间两个数
        while(left<right){
            int m1 = left + (right - left)/2;             
            int m2 = k - m1;                      
            if(nums1[m1] < nums2[m2-1]){                  
                left = m1+1;                              //如果小于 则前面为前k-1小值（合在一起的数组）
            }else{
                right = m1;                               //如果不小于 抛弃后面的
            }
        }
        int m1 = left;
        int m2 = k-left;  
        int c1 = Math.max(m1 == 0? Integer.MIN_VALUE:nums1[m1-1],m2 == 0?Integer.MIN_VALUE:nums2[m2-1]);//判断边界
        if((n1 + n2) % 2 != 0){ return c1;}
        int c2 = Math.min(m1 == n1? Integer.MAX_VALUE:nums1[m1],m2 == n2?Integer.MAX_VALUE:nums2[m2]);//判断边界
        return (c1 + c2) * 0.5;
    }
}