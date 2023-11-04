//GFG https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1

class palindromicPartitioning {
    int palindromicPartition(String str) {
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];

        // Initialize a table to store whether substrings are palindromes.
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // Calculate whether substrings are palindromes and fill the table.
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                if (str.charAt(i) == str.charAt(j) && len == 2) {
                    isPalindrome[i][j] = true;
                } else if (str.charAt(i) == str.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        int[] minCuts = new int[n];

        for (int i = 0; i < n; i++) {
            int minCut = i; // Maximum possible cuts
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    minCut = (j == 0) ? 0 : Math.min(minCut, minCuts[j - 1] + 1);
                }
            }
            minCuts[i] = minCut;
        }

        return minCuts[n - 1];
    }
}