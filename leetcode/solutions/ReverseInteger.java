package solutions;

/**
 * Reverse the integer provided, while maintaining the sign.
 */
public class ReverseInteger {
	
	public int reverseInt(int x) {
		
		int sign = 1; 
		if(x < 0) {
			sign = -1;
		}
		
		x = Math.abs(x);
		
		String xx = ((Integer) x).toString();
		String reversed = "";
		
		for(int i = xx.length() -1; i >= 0; i--) {
			reversed += xx.charAt(i);
		}
		try {
			int reversedInt = Integer.parseInt(reversed) * sign;
			if(reversedInt >= Integer.MAX_VALUE || reversedInt <= Integer.MIN_VALUE) {
				return 0;
			}
			
			return reversedInt;
			
		} catch (Exception out) {
			return 0;
		}
		
	}
	
	public int reverseInt2(int x) {
		int sign = 1; 
		if(x < 0) {
			sign = -1;
		}
		
		x = Math.abs(x);
        
		try {
			int rev = 0;
            while(x != 0) {
                int digit = x % 10;
                rev = rev * 10 + digit;
                x /= 10;
            }
            if(rev >= Integer.MAX_VALUE || rev <= Integer.MIN_VALUE) {
				return 0;
			}
			return rev*sign;
			
		} catch (Exception out) {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
