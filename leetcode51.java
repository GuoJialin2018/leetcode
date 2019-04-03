package leetcode;
import java.util.*;
public class leetcode51 {
	 public List<List<String>> solveNQueens(int n) {
	        List<List<String>> res=new ArrayList<List<String>>();
	        int[] queenList=new int[n];
	        placeQueen(queenList,0,n,res);
	        return res;
	    }
	    private void placeQueen(int[] queenList,int row,int n, List<List<String>> res){
	        if(row==n){
	            ArrayList<String> list=new ArrayList<String>();
	            for(int i=0;i<n;i++){
	                String str="";
	                for(int col=0;col<n;col++){
	                    if(queenList[i]==col){
	                        str+="Q";
	                    }else{
	                        str+=".";
	                    }
	                }
	                list.add(str);
	            }
	            res.add(list);
	        }
	       for(int col=0;col<n;col++){
	           if(isValid(queenList,row,col)){
	              queenList[row]=col;
	              placeQueen(queenList,row+1,n,res);
	           }
	 
	       }
	    }
	    private boolean isValid(int[] queenList,int row, int col){
	        for(int i=0;i<row;i++){
	            int pos=queenList[i];
	            if(pos==col){
	                return false;
	            }
	            if(pos+row-i==col){
	                return false;
	            }
	            if(pos-row+i==col){
	                return false;
	            }
	        }
	        return true;
	    }
}
