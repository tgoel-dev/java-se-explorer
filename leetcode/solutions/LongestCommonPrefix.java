package solutions;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		
		String ans = "";
		String temp = "";
		
		main: for(int i = 0; i < strs[0].length(); i++) {
			temp = "" + strs[0].charAt(i);
			for (String s : strs) {
				if(s.charAt(i) != temp.charAt(0)) {
					break main;
				}
			}
			ans += temp;
		}
		
		return ans;
		
	}

}
