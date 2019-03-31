package leetcode;

import java.util.LinkedList;
import java.util.List;

public class leetcode68 {
	public static void main(String[] args) {
		String[] words= {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth=16;
		List<String> li=fullJustify(words,maxWidth);
		for(String ss:li) {
			System.out.println(ss);
		}
	}
	public static List<String> fullJustify(String[] words,int maxWidth) {
		List<String> ans =new LinkedList<String>();
		int i=0;
		while(i<words.length) {
			int curSum=words[i].length();
			int j=i+1;
			while(j<words.length&&curSum+1+words[j].length()<=maxWidth) {
				curSum+=1+words[j].length();
				++j;
			}
			if(j==i+1||j==words.length) {
				StringBuilder sb=new StringBuilder(words[i]);
				for(int x=i+1;x<j;x++) sb.append(" "+words[x]);
				int len=maxWidth-sb.length();
				while((len--)>0) sb.append(' ');
				ans.add(sb.toString());
				i=j;
				continue;
			}
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
