package leetcode;

import java.util.LinkedList;
import java.util.List;
/*问题描述：
给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。

输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

输入:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。

*/

public class leetcode68 {
	public static void main(String[] args) {
		String[] words= {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth=16;
		List<String> li=fullJustify(words,maxWidth);
		for(String ss:li) {
			System.out.println(ss);
		}
	}
//考虑到每一行都不能超过最大宽度,因此需要一行行加入,需要设置curSum.
	public static List<String> fullJustify(String[] words,int maxWidth) {
		List<String> ans =new LinkedList<String>();
		int i=0;
		while(i<words.length) {
			int curSum=words[i].length();
			int j=i+1;
			while(j<words.length&&curSum+1+words[j].length()<=maxWidth) {
				curSum+=1+words[j].length();
//每两个单词之间的至少有一个空格
				++j;
			}
			if(j==i+1||j==words.length) {
//由于是左对齐,只有每一行有两个单词或者最后一行的时候考虑
				StringBuilder sb=new StringBuilder(words[i]);
				for(int x=i+1;x<j;x++) sb.append(" "+words[x]);
				int len=maxWidth-sb.length();
				while((len--)>0) sb.append(' ');
				ans.add(sb.toString());
				i=j;
				continue;
			}
//当位于中间时,要保证到左边空格多于右边,因此需要把多的空格进行重新分配。
			int padding=maxWidth-curSum;
			int eachPad=padding/(j-i-1);
			int rem=padding%(j-i-1);
			StringBuilder sb=new StringBuilder(words[i]);
			for(int x=i+1;x<j;x++) {
				for(int sp=0;sp<eachPad;++sp) sb.append(' ');
				if(rem!=0) {
					sb.append(' ');
					rem--;
				}
				sb.append(' '+words[x]);
			}
			int len=maxWidth-sb.length();
			while((len--)>0) sb.append(' ');
			ans.add(sb.toString());
			i=j;		
		}
		return ans;
	}

}
