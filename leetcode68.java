package leetcode;

import java.util.LinkedList;
import java.util.List;
/*����������
����һ�����������һ������ maxWidth�������Ű浥�ʣ�ʹ���Ϊÿ��ǡ���� maxWidth ���ַ������������˶�����ı���

��Ӧ��ʹ�á�̰���㷨�������ø����ĵ��ʣ�Ҳ����˵�������ܶ����ÿ���з��õ��ʡ���Ҫʱ���ÿո� ' ' ��䣬ʹ��ÿ��ǡ���� maxWidth ���ַ���

Ҫ�󾡿��ܾ��ȷ��䵥�ʼ�Ŀո����������ĳһ�е��ʼ�Ŀո��ܾ��ȷ��䣬�������õĿո���Ҫ�����Ҳ�Ŀո�����

�ı������һ��ӦΪ����룬�ҵ���֮�䲻�������Ŀո�

˵��:

������ָ�ɷǿո��ַ���ɵ��ַ����С�
ÿ�����ʵĳ��ȴ��� 0��С�ڵ��� maxWidth��
���뵥������ words ���ٰ���һ�����ʡ�

����:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
���:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

����:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
���:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
����: ע�����һ�еĸ�ʽӦΪ "shall be    " ������ "shall     be",
     ��Ϊ���һ��ӦΪ����룬�������������˶��롣       
     �ڶ���ͬ��Ϊ����룬������Ϊ����ֻ����һ�����ʡ�

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
//���ǵ�ÿһ�ж����ܳ��������,�����Ҫһ���м���,��Ҫ����curSum.
	public static List<String> fullJustify(String[] words,int maxWidth) {
		List<String> ans =new LinkedList<String>();
		int i=0;
		while(i<words.length) {
			int curSum=words[i].length();
			int j=i+1;
			while(j<words.length&&curSum+1+words[j].length()<=maxWidth) {
				curSum+=1+words[j].length();
//ÿ��������֮���������һ���ո�
				++j;
			}
			if(j==i+1||j==words.length) {
//�����������,ֻ��ÿһ�����������ʻ������һ�е�ʱ����
				StringBuilder sb=new StringBuilder(words[i]);
				for(int x=i+1;x<j;x++) sb.append(" "+words[x]);
				int len=maxWidth-sb.length();
				while((len--)>0) sb.append(' ');
				ans.add(sb.toString());
				i=j;
				continue;
			}
//��λ���м�ʱ,Ҫ��֤����߿ո�����ұ�,�����Ҫ�Ѷ�Ŀո�������·��䡣
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
