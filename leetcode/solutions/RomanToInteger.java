package solutions;

import java.util.Arrays;
import java.util.HashMap;

public class RomanToInteger {

	public final HashMap<Character, Integer> conversion = new HashMap<>();

	{
		conversion.put('I', 1);
		conversion.put('V', 5);
		conversion.put('X', 10);
		conversion.put('L', 50);
		conversion.put('C', 100);
		conversion.put('D', 500);
		conversion.put('M', 1000);
	}

	@SuppressWarnings("unlikely-arg-type")
	public int romanToInt(String s) {

		if(s.length() == 1 && conversion.containsKey(s)) {
			return conversion.get(s);
		}
		
		int[] ii = new int[s.length()];
		
		for (int in = 0; in < s.length(); in++) {		
			ii[in] = conversion.get(s.charAt(in));
		}
		
		System.out.println(Arrays.toString(ii));
		for(int i = 0; i < ii.length; i++) {
			if(i < ii.length -1  && ii[i] < ii[i+1]) {
				ii[i] = - ii[i];
			}
			
		}
		
		System.out.println(Arrays.toString(ii));
		int ans = 0;
		for(int i : ii) {
			ans += i;
		}
		System.out.println(ans);
		return ans;
	}
	
	
	public static void main(String[] args) {
		RomanToInteger c = new RomanToInteger();
		c.romanToInt("III");
		c.romanToInt("IV");
	}
}
