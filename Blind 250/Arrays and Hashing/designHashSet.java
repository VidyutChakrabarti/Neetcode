class TreeNode {
    int key;
    TreeNode left, right;

    TreeNode(int key) {
        this.key = key;
    }
}

class BST {
    private TreeNode root;

    private TreeNode insert(TreeNode node, int key) {
        if (node == null) return new TreeNode(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null) return null;
        if (key < node.key) node.left = delete(node.left, key);
        else if (key > node.key) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode temp = minValueNode(node.right);
            node.key = temp.key;
            node.right = delete(node.right, temp.key);
        }
        return node;
    }

    private TreeNode minValueNode(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private boolean search(TreeNode node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }

    public void add(int key) {
        root = insert(root, key);
    }

    public void remove(int key) {
        root = delete(root, key);
    }

    public boolean contains(int key) {
        return search(root, key);
    }
}

public class MyHashSet {
    private final int size = 10000;
    private BST[] buckets;

    public MyHashSet() {
        buckets = new BST[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new BST();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        int idx = hash(key);
        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
        }
    }

    public void remove(int key) {
        int idx = hash(key);
        buckets[idx].remove(key);
    }

    public boolean contains(int key) {
        int idx = hash(key);
        return buckets[idx].contains(key);
    }
}

/*

Linked List: 

public class MyHashSet {

    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    private final ListNode[] set;

    public MyHashSet() {
        set = new ListNode[10000];
        for (int i = 0; i < set.length; i++) {
            set[i] = new ListNode(0);
        }
    }

    public void add(int key) {
        ListNode cur = set[key % set.length];
        while (cur.next != null) {
            if (cur.next.key == key) {
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key);
    }

    public void remove(int key) {
        ListNode cur = set[key % set.length];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    public boolean contains(int key) {
        ListNode cur = set[key % set.length];
        while (cur.next != null) {
            if (cur.next.key == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}

Boolean Array: 

public class MyHashSet {
    private boolean[] data;

    public MyHashSet() {
        data = new boolean[1000001];
    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    public boolean contains(int key) {
        return data[key];
    }
}

*/