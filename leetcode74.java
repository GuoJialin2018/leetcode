package leetcode;

public class leetcode74 {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix==null||matrix.length==0||matrix[0].length==0)
	            return false;
	        int l=0,r=matrix.length-1,len=matrix[0].length;
	        while(l<=r){
	            int mid=(l+r)/2;
	            if(target>matrix[mid][len-1])
	                l=mid+1;
	            else if(target<matrix[mid][0])
	                r=mid-1;
	            else
	                return binSearch(matrix[mid],target);
	        }
	        return false;
	    }
	    public boolean binSearch(int[] arr, int target){
	        int l=0,r=arr.length-1;
	        while(l<=r){
	            int mid=(l+r)/2;
	            if(target>arr[mid])
	                l=mid+1;
	            else if(target<arr[mid])
	                r=mid-1;
	            else 
	                return true;
	        }
	        return false;
	    }
}
