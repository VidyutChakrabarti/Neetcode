/*
Definition for a Node.
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
*/

class Solution {
    Map<Node, Node> ntn;
    public Node cloneGraph(Node node) {
        ntn = new HashMap<>();
        return dfs(node); 
    }

    Node dfs(Node node){
        if(node == null){
            return null;
        }
        if(ntn.containsKey(node)){
            return ntn.get(node);
        }

        Node curr = new Node(node.val);
        ntn.put(node, curr);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        for(Node n: node.neighbors){
            curr.neighbors.add(dfs(n));
        }
        return curr;
    }
}