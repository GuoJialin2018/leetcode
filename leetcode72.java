package leetcode;
//用dp[i][j]表示当i和j个字符匹配时，此时所需要的编辑距离
//如果第一个字符串的i-1，j-1相同，那么，dp[i][j]=dp[i-1][j-1]
//如果不同，那么就等于插入/删除/替换三种情况最小编辑距离+1的编辑距离
public class leetcode72 {
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=len2;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
