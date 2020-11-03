package Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
/**
 * 为了防止多次遍历同一个节点，陷入死循环，我们需要用一种数据结构记录已经被克隆过的节点。
 * 算法
 *
 * 使用一个哈希表存储所有已被访问和克隆的节点。哈希表中的 key 是原始图中的节点，value 是克隆图中的对应节点。
 * 从给定节点开始遍历图。如果某个节点已经被访问过，则返回其克隆图中的对应节点。
 * 如果当前访问的节点不在哈希表中，则创建它的克隆节点并存储在哈希表中。
 * 递归调用每个节点的邻接点。每个节点递归调用的次数等于邻接点的数量，每一次调用返回其对应邻接点的克隆节点，最终返回这些克隆邻接点的列表，将其放入对应克隆节点的邻接表中。
 */

public class leetcode133 {
    HashMap<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node){
        if (node == null){
            return node;
        }
        // 如果visited存在node的克隆结点则返回克隆结点
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val,new ArrayList());
        // 设置好cloneNode结点的克隆结点
        visited.put(node,cloneNode);
        for (Node neighbor : node.neighbors){
            // 递归node邻居结点的克隆结点
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}