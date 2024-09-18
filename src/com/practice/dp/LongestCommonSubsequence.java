public class LongestCommonSubsequence {

  private static String findLCS(String config1, String config2) {

    int maxLength = 0;
    int end = 0;
    int m = config1.length();
    int n = config2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= config1.length(); i++) {
      for (int j = 1; j <= config2.length(); j++) {
        if (config1.charAt(i - 1) == config2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          if (dp[i][j] > maxLength) {
            maxLength = dp[i][j];
            end = i;
          }
        } else {
          dp[i][j] = 0;
        }
      }
    }

    System.out.println("DP Matrix:");
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    return config1.substring(end - maxLength, end);
  }


  public static void main(String[] args) {
    String config1 = "abcwxyz123";
    String config2 = "wxyzabc456";

    String lcs = findLCS(config1, config2);
    System.out.println("Longest common substring: " + lcs); // Output: "xyz"
  }

}
