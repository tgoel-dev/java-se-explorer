package solutions;

import java.util.Arrays;

public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
		String xx = ((Integer) x).toString();
		int[] straight = new int[xx.length()];
		
		for(int i = 0; i < xx.length(); i++) {
			straight[i] = xx.charAt(i);
		}
		int[] reverse = new int[xx.length()];
		
		for(int i = 0, j = straight.length -1; j >= 0; i++, j--) {
			reverse[i] = straight[j];
		}
		
		System.out.println(Arrays.toString(reverse) + " " + Arrays.toString(straight));
		for(int i = 0; i < xx.length(); i++) {
			if(straight[i] != reverse[i]) return false;
		}
		
		return true;
	}
	
	public static boolean isPalindrome2(int x) {
		
		String xx = ((Integer) x).toString();
		String reversed = "";
		
		for(int i = xx.length() -1; i >= 0; i--) {
			reversed += xx.charAt(i);
		}
		
		if(xx.equals(reversed)) return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
}
