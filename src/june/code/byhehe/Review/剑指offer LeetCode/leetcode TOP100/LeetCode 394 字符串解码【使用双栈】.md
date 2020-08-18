LeetCode 394 字符串解码

#### [394. 字符串解码](https://leetcode-cn.com/problems/decode-string/)

难度中等252

给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: `k[encoded_string]`，表示其中方括号内部的 *encoded_string* 正好重复 *k* 次。注意 *k* 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 *k* ，例如不会出现像 `3a` 或 `2[4]` 的输入。

**示例:**

```
s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
```

## 思路

```
这一题的思路可以设计地非常巧妙：
大致思路是： 不断的通过字符进行判断，即逐位进行判断。
然后流程如下：
首先 ，使用两个栈 一个栈用于保存 数字 LinkedList<Integer> stack_multi = new LinkedList<>();
一个栈用于保存 字符串，注意是字符串 LinkedList<String> stack_res = new LinkedList<>();
接下来 对 给定的 s 字符串进行判断，无非四种情况：
	1，判断是 '['的情况， 这个情况 需要考虑 '[' 前后的字符串， 可以使用 stack_res 进行保存， 当碰到 '[' 之前，使用 res 保存，当碰到 '[' 之后，那么可以将 res 当前结果先放入栈中， 然后用 res 变量 继续保存 '[' 到 ']' 之间的内容。
	2. 当碰到 ']' 的时候， 那么 就把 当前 res 的结果 和 stack_multi 中的结果出栈，用一个临时变量 StringBuilder tmp = new StringBuilder(); 添加次数 为 stack_multi 出栈的数字， for() tmp.append(res); 之后， res = new StringBuilder(stack_res.removeLast() + tmp);
	3. 碰到数字， 数字 可能是 1,2,3这样的一个占一个字符，也可能是 23 这样的 > 9 的数字， 因此可以先判断下当前字符， 把它保存进一个数， 将一个字符串数字保存到一个整数的方法如下：举例 239
	multi = 0;
	multi = multi * 10 + Integer.parseInt(c+"");  // 给字符串参数
    当前字符是 '2' ， 那么 multi = 0 * 10 + 2 (转成 数字)； multi = 2
    当前字符是 '3' ， 那么 multi = 2 * 10 + 3 = 23;
    当前字符是 '9'， 那么 multi = 23 * 10 + 9 = 239;
    至此 不用使用 正则表达式，也不用使用 索引的形式进行判断， 直接把每次计算分摊到 便利的过程中。解决数字的保存。
    4. 当前字符 为正常字符 比如 3[abc]cde, 像 cde 这样的字符。
    那么直接 添加进 res, 即 res.append(c);
    
最后 返回 res 即可。
```

## 代码

```java
class Solution {
    public String decodeString(String s) {
        /**
         * 大致思路如下： 使用 两个栈 一个存放数字一个存放 字符
         */
        // 先定义一个 可变字符串 即保存完整字符串 又保存临时字符串 [] 中的
        StringBuilder res = new StringBuilder();
        // 定义一个栈用于保存 数字 1,2或者 24 这样的
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 定义一个 栈 用于保存 [ 之前的临时结果
        LinkedList<String> stack_res = new LinkedList<>();
        //定义一个整数 保存 乘数（倍数）
        int multi = 0;
        for(Character c:s.toCharArray()){
            // 下面进行判断
            /*
            1. 为 '[' 的情况
            2. 为 ']' 的情况
            3. 为数字的情况
            4. 为字符法情况  这里需要使用临时或者完整的进行区分
             */
            if(c=='['){
                // 把 res和multi都 保存进 各自栈中 ，重新置这两个参数
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // 重新初始化
                multi = 0;
                res = new StringBuilder();
            }else if(c==']'){
                // 说明栈中已经有满足条件的计算状况了 可以进行计算
                int cur_multi = stack_multi.removeLast();  // 尾进尾出
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < cur_multi; i++)
                    tmp.append(res); // [ 之前的已经被保存进 栈中 这里的res知识 [] 中的
                // 然后 将 比如 3[ac] -> acacac 放入总的情况中去 这时 res 可以代表到这个 ] 的所有字符了
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }else if(c>='0' && c <= '9'){
                // 这里为什么 *10 这是因为 有可能 不是单个的字符 1 2 3 有可能是 23 目前只来到了 2 那么如果是 3 就需要 *10 ，
                // 即 2*10 + 3 = 23
                multi = multi * 10 + Integer.parseInt(c+"");   // 这里 c+"" 是将字符变成字符串 因为参数需要传入字符串
            }else{
                res.append(c); // res 的角色真的很奇妙 又可以做 整个结果 又可以做暂时的结果
            }
        }
        return res.toString();
    }
}
```

