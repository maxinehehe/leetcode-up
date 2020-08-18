# leetcode 79 单词搜索

#### [79. 单词搜索](https://leetcode-cn.com/problems/word-search/)

难度中等344

给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

**示例:**

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
```

 

**提示：**

- `board` 和 `word` 中只包含大写和小写英文字母。
- `1 <= board.length <= 200`
- `1 <= board[i].length <= 200`
- `1 <= word.length <= 10^3`

> 最开始的错误方法 就是 使用 str+='c'  这样会导致很容易栈溢出
>
> 既然比较 不是要求返回路径，而是要求返回 true 或 false 。所以可以考虑 不用记录路径。
>
> 即使用 DFS + 回溯法；下面是两种不同的写法， 但是思路是一样的。

## 使用一维数组 boolean 进行记录 

```java
// package myPackage;
public class Solution {
    // public static void main(String[] args) {
    //     char[][]board ={
    //             {'A','B','C','E'},
    //             {'S','F','C','S'},
    //             {'A','D','E','E'}
    //     };
    //     String word = "ABC";
    //     System.out.println(exist(board,word));
    // }
    public  boolean exist(char[][] board, String word) {
        // [row, col] --[i,j] == [col*i+j]
        int row = board.length, col = board[0].length;
        boolean[] flag = new boolean[row * col];
        if(word.length()>=0){
            // return backTracking(board, 0, word, flag, 0, 0);
            for(int i=0;i<row;i++)
                for(int j=0;j<col;j++)
                {
                    if(backTracking(board, 0, word, flag, i, j)){
                        return true;
                    }
                }
        }
        return false;
    }
    // 更改后的代码 即 只比较单个字符 而不再是整个字符串的进行比较
    /*
    即比如 word="ABCDEF"  之前是比较 ABCDEF 这个字符串
    现在改为一步只比较一个字符， 比如 比较 当前走到的位置 是否和 'A' 相等， 相等就再往下走 去比较 'B', 不相等的话就回溯 去其他方向找
    */
    public boolean backTracking(char[][] board,int pos,String word,boolean[] flag,int i, int j){
		int index = board[0].length * i + j;
        if(i<0||j<0||i>=board.length||j>=board[0].length||flag[index]||board[i][j]!=word.charAt(pos)){// board[i][j]!=word.charAt(pos)这一句也是关键 判断当前的字符 和 目前 pos 位置的字符是否相等 相等则继续往下找 否则 返回false
            return false;
        }

        /*
        if(res.equals(word)){
            return true;
        }
        */
        if(pos == word.length()-1){ // 这个是关键判断 是否正确的
            // 当和这个字符串比到最后就说明这个答案是符合我们要求的。返回true，
            return true;
        }
        
        flag[index] = true; // 使用当前的 [index]
       // 下面是从四个方向 找 走到这里说明当前字符是可以用的，那么接下来就是去四个方向 比较下一个字符 所以 pos+1
        if(backTracking(board, pos+1, word, flag,i+1,j)||backTracking(board, pos+1, word, flag,i,j+1)
                ||backTracking(board, pos+1, word, flag,i-1,j)||backTracking(board, pos+1, word, flag,i,j-1))
            return true;
        flag[index] = false; // [index]回溯
        return false;

    }
}
```

