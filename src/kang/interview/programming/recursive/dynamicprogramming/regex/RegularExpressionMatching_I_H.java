package kang.interview.programming.recursive.dynamicprogramming.regex;

/**
 * Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") ? false
	isMatch("aa","aa") ? true
	isMatch("aaa","aa") ? false
	isMatch("aa", "a*") ? true
	isMatch("aa", ".*") ? true
	isMatch("ab", ".*") ? true
	isMatch("aab", "c*a*b") ? true
	
 * @author yankang
 *
 */
public class RegularExpressionMatching_I_H {
	
	/**
	 *  1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
		2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
		3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
                           
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		// dp[i][j] indicates is the substring from 0 to i matches the subpattern from 0 to j
		dp[0][0] = true;
		
		// more loose than wildcard matching
		// if current position is "*" and the dp of two position ahead is true,
		// dp of current position is true
		for (int i = 2; i < p.length() + 1; i += 2) {
			if (p.charAt(i - 1) == '*' && dp[0][i - 2] == true) {
				dp[0][i] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				if (p.charAt(j - 1) != '*') {
					if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
						dp[i][j] = dp[i - 1][j - 1];
					}
				} else {
					if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
						dp[i][j] = dp[i][j - 2];
					} else {
						dp[i][j] = (dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
