import java.util.Arrays;

class LongestCommonSequence {
    String topDown(String s1, String s2) {
        int[][] arr = new int[s1.length()+1][s2.length()+1];
        Arrays.fill(arr[0], 0);
        for (int i = 1; i < arr.length; i++)
            arr[i][0] = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    arr[i][j] = 1 + arr[i-1][j-1];
                else
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++)
                System.out.print(arr[i][j]+", ");
            System.out.println();
        }

        String ans = "";
        int i = arr.length-1, j = arr[0].length-1, tmp = arr[i][j];
        j--;
        while(i > 0) {
            while (j > 0) {
                if (arr[i][j] != tmp) {
                    ans += s1.charAt(--i);
                    tmp = arr[i][j];
                }
                j--;
            }
            i--;
        }
        StringBuilder sb=new StringBuilder(ans);
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        LongestCommonSequence l = new LongestCommonSequence();
        String s1 = "longest", s2 = "stone";
        String ans = l.topDown(s2, s1);
        System.out.println(ans);
    }
}
