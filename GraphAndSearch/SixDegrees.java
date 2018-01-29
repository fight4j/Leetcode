package Ningbo.GraphAndSearch;

import Ningbo.Util.UndirectedGraphNode;

import java.util.*;

/**
 * Created by zhang on 7/25/16.
 *
 * 图的BFS : 每访问一个节点, 先入队列, 依次访问该节点的邻居节点,如果邻居节点已访问过,则跳过,否则加入队列
 *          该题做了变化, 普通BFS用visited Map存储该节点是否被访问过,此题则直接<UndirectedGraphNode, Integer>来保存到该节点的步数
 *          若未访问过, 则存入step + 1
 *
 *
 * 错误点:   对某点是否已访问过,用Map.containsKe来确认, 而不是queue.contains()来确认,会造成LTE
 *
 */
public class SixDegrees {
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (graph == null || graph.size() == 0) {
            return -1;
        }
        if (s == t) {
            return 0;
        }

        HashMap<UndirectedGraphNode, Integer> visited = new HashMap<UndirectedGraphNode, Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.offer(s);
        visited.put(s, 0);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            int step = visited.get(node);
            for (int i = 0; i < node.neighbors.size(); i++) {
//                if (queue.contains(node.neighbors.get(i))) {
                if (visited.containsKey(node.neighbors.get(i))) {
                    continue;
                }

                queue.offer(node.neighbors.get(i));
                visited.put(node.neighbors.get(i), step + 1);
                if (t == node.neighbors.get(i)) {
                    return step + 1;
                }
            }
        }

        return -1;
    }
}
