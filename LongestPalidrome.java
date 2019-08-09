

//idea: here we need length of longest palidrome so  we dont have to  return  palidromic string.
//palidromic string contains same characters at both start and end .And unique chacter at the middle.
//therefore we will maintain repeatation count of each character in string if its even then just add in length.
//if odd then by dividing it by 2 ,and multiply it by2  and get its even count to include in length.
//for unique character check if mod 2 is 1 and totallength %2==0. if yes then add1.

//time complexity is (n)
//space complexity is (1) size 128 is fixed

//run on leet code :yes
public class LongestPalidrome {
	
	
	    public int longestPalindrome(String s) {
	        int[] count = new int[128];
	        for (char c: s.toCharArray())
	            count[c]++;

	        int ans = 0;
	        for (int v: count) {
	            ans += v / 2 * 2;
	            if (ans % 2 == 0 && v % 2 == 1)
	                ans++;
	        }
	        return ans;
	    }
	

}
