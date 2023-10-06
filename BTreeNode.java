// Node definition for B-Tree
public class BTreeNode {
    int[] keys;  // An array of keys
    int minDegree;  // Minimum degree (defines the range for number of keys)
    BTreeNode[] children;  // An array of child pointers
    int numKeys;  // Current number of keys
    boolean leaf;  // Is true when node is leaf. Otherwise false

    // Constructor for BTreeNode class
    public BTreeNode(int minDegree, boolean leaf) {
        this.minDegree = minDegree;
        this.leaf = leaf;
        keys = new int[minDegree - 1];
        children = new BTreeNode[minDegree];
        numKeys = 0;
    }
}