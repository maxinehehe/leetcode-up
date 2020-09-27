package june.code.byhehe.Review.leetcodeByHuaWei;

public class LeetCode7 {
}

// int -2^31——2^31-1
class lc7{
    public int reverse(int x) {
        int res = 0;
        while (x!=0){
            // 123   123/10 = 12   123%10 = 3
            int carry = x % 10;
            // 处理溢出
            if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE && carry > 7) return 0;
            if(res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE && carry < - 8) return 0;
            x /= 10;
            res = res*10 + carry;
        }
        return res;
    }
}
