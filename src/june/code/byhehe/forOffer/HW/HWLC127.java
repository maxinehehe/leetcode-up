package june.code.byhehe.forOffer.HW;
/*
127. 单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
//import javafx.util.Pair;

//import javafx.util.Pair;

import java.util.*;

public class HWLC127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        LC127 lc127 = new LC127();
        int res = lc127.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);


    }
}
class Pair<K,V>{
    public K Key;
    public V Value;
    public Pair(){}
    public Pair(K Key, V Value){
        this.Key = Key;
        this.Value = Value;
    }

    public void setKey(K key) {
        Key = key;
    }

    public void setValue(V value) {
        Value = value;
    }

    public K getKey() {
        return Key;
    }

    public V getValue() {
        return Value;
    }
}

class LC127{
    // 主调函数
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Pair
        // 构建 图
//        construct_graph(String beginWord, List<String> wordList, Map<String , List<String>> graph)
        Map<String , List<String>> graph = new HashMap<>();
        construct_graph(beginWord,wordList, graph);
        // dfs图
//        bfs_graph(String beginWord, String endWord, Map<String, List<String>> graph){

            return bfs_graph(beginWord, endWord, graph);


    }

    public boolean connect(String word1, String word2){
        int cnt = 0;
        // 两个长度默认是一样的
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i))
                cnt++;
        }
        return cnt == 1;   // 是否只有一个不一样
    }

    public void construct_graph(String beginWord, List<String> wordList, Map<String , List<String>> graph){
        // beginWord 可能不在wordList 所以可以直接把其添加进去 防止。。。？
        wordList.add(beginWord);

        // 开始构件图
        for(int i = 0; i < wordList.size(); i++){
            // 这里 j = i + 1， 主要是 防止重复判断， 比如["hot", "hit", "dot"]
            // 如果前面判断过 hot 一定能找到 hit dot, 后面在判断 dot 的时候没必要在判断
            // 也就是说 wordList[i] 和 wordList[j] 如果相差 1 个字符 直接将他们互相连上就可以了
            for(int j = i+1; j < wordList.size(); j++){
                // 判断一下啊 就是相差一个字符的
                if(connect(wordList.get(i), wordList.get(j))){
                    // 减少循环复杂度 双向添加
//                    graph.put(wordList.get(i), wordList.get(j));
//                    graph.put(wordList.get(j), wordList.get(i));
                    String iKey = wordList.get(i);
                    String jKey = wordList.get(j);
                    if(graph.get(iKey)!=null){
                        graph.get(iKey).add(wordList.get(j));
                    }else {
                        List<String> list = new ArrayList<>();
                        list.add(wordList.get(j));
                        graph.put(iKey, list);
                    }

                    // i ,j
                    if(graph.get(jKey)!=null){
                        graph.get(jKey).add(wordList.get(i));
                    }else {
                        List<String> list = new ArrayList<>();
                        list.add(wordList.get(i));
                        graph.put(jKey, list);
                    }


                }
            }

            // hit 可能不在里面 加入进去 ["hot","dot","dog","lot","log","cog"]
            // ["hot","dot","dog","lot","log","cog","hit"]
            // hot => [dot, dog, hit]
            // dot => [log, dog, hot]
            // dog => [log, cog, dot]
            // lot => [log, hot, dot]
            // log => [cog, lot, dog]
            // cog => ...
            // hit => ...

        }

    }

    public int bfs_graph(String beginWord, String endWord, Map<String, List<String>> graph){

        Queue<Pair<String, Integer>> queue = new LinkedList<>();  // 搜索队列<顶点， 步数>
        Set<String> visit = new HashSet<>(); // 记录已访问的顶点

        queue.add(new Pair<>(beginWord, 1));

        visit.add(beginWord);

        while (!queue.isEmpty()){
            // 获取pair 中的 顶点 和 数值
            String node = queue.peek().getKey();
            int step = queue.peek().getValue();
            // 然后将该顶点出队列
            queue.poll();
            // 判断是否找到了 终点 返回步数
            if(node == endWord){
                return step;
            }

            List<String> stringList = graph.get(node);
            for (int i = 0; i < stringList.size(); i++) {
                if(!visit.contains(stringList.get(i))){
                    queue.add(new Pair<>(stringList.get(i), step+1));
                }
            }

        }
        return 0;
    }

}


