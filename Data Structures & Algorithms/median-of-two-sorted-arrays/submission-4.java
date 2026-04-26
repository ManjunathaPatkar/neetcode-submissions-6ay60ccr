class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int totalSize = n1+n2;
        int mid1=-1,mid2=-1,v1=0,v2=0;
        if(totalSize%2==0){
            mid2=totalSize/2;
            mid1=mid2-1;
        }
        else{
            mid1=totalSize/2;
            mid2=mid1;
        }

        int i=0,j=0,k=0;
        boolean foundMid1=false,foundMid2=false;
        while(k<totalSize){
            int first = i==nums1.length?Integer.MAX_VALUE:nums1[i];
            int second = j==nums2.length?Integer.MAX_VALUE:nums2[j];
            if(first<second){
                i++;
            }
            else{
                j++;
            }
            k++;
            if(i+j-1==mid1){
                v1=first<second?first:second;
                foundMid1=true;
            }
            if(i+j-1==mid2){
                v2=first<second?first:second;
                foundMid2=true;
            }
            if(foundMid1 && foundMid2){
                return (double)(v1+v2)/2;
            }
        }
        return -1.0;
    }
}
