import java.util.Arrays;

public class BTree {
    private BTreeNode root; // Pointer to the root node
    private int treeDegree;  // Minimum degree

    // Constructor
    public BTree(int treeDegree) {
        this.treeDegree = treeDegree;
        root = new BTreeNode(treeDegree, true);
    }

    // Inserts a new key in the B-Tree
    public void insert(int key) {
        BTreeNode node = root;

        // Case 3: The root of the B-tree is full.
        if (node.numKeys == treeDegree - 1) {
            BTreeNode newRoot = new BTreeNode(treeDegree, false);
            newRoot.children[0] = root;
            splitChild(newRoot, 0, root);
            root = newRoot;
            node = newRoot;
        }

        // Continue down the tree until we reach a leaf
        while (!node.leaf) {
            int i = 0;
            while (i < node.numKeys && key > node.keys[i]) {
                i++;
            }
            // Case 2: The leaf in which a key is to be placed is full.
            if (node.children[i].numKeys == treeDegree - 1) {
                splitChild(node, i, node.children[i]);
                if (key > node.keys[i]) {
                    i++;
                }
            }
            node = node.children[i];
        }

        // Case 1: A key is placed into a leaf that still has room.
        int i = node.numKeys - 1;
        node.numKeys++;
        while (i >= 0 && key < node.keys[i]) {
            node.keys[i + 1] = node.keys[i];
            i--;
        }
        node.keys[i + 1] = key;
    }

    // A utility function to split the child nodeToSplit of this node
    private void splitChild(BTreeNode parentNode, int index, BTreeNode nodeToSplit) {
        BTreeNode newNode = new BTreeNode(nodeToSplit.minDegree, nodeToSplit.leaf);
        newNode.numKeys = treeDegree / 2 - 1;

        // Copy the last (t/2 - 1) keys of nodeToSplit to newNode
        for (int i = 0; i < treeDegree / 2 - 1; i++)
            newNode.keys[i] = nodeToSplit.keys[i + treeDegree / 2];

        // Copy the last t children of nodeToSplit to newNode
        if (!nodeToSplit.leaf) {
            for (int i = 0; i < treeDegree / 2; i++)
                newNode.children[i] = nodeToSplit.children[i + treeDegree / 2];
        }

        // Reduce the number of keys in nodeToSplit
        nodeToSplit.numKeys = treeDegree / 2 - 1;

        // Shift child and key of parentNode right
        for (int i = parentNode.numKeys; i >= index + 1; i--)
            parentNode.children[i + 1] = parentNode.children[i];
        parentNode.children[index + 1] = newNode;

        for (int i = parentNode.numKeys - 1; i >= index; i--)
            parentNode.keys[i + 1] = parentNode.keys[i];

        // Key of newNode becomes key[index] of parentNode
        parentNode.keys[index] = nodeToSplit.keys[treeDegree / 2 - 1];
        parentNode.numKeys = parentNode.numKeys + 1;
    }

    // Function to print the B-Tree
    public void print(BTreeNode node, int depth) {
        System.out.println("Node at depth " + depth + ": " + Arrays.toString(Arrays.copyOfRange(node.keys, 0, node.numKeys)));

        if (!node.leaf) {
            for(int i = 0; i <= node.numKeys; i++) {
                print(node.children[i], depth + 1);
            }
        }
    }

    public static void main(String[] args) {

        // Sample B-Tree
        BTree bTree;
        bTree = new BTree(4);

        bTree.insert(50);
        bTree.insert(60);
        bTree.insert(80);
        bTree.insert(30);
        bTree.insert(35);
        bTree.insert(58);
        bTree.insert(59);
        bTree.insert(63);
        bTree.insert(70);
        bTree.insert(73);
        bTree.insert(100);
        bTree.insert(52);
        bTree.insert(54);
        bTree.insert(61);
        bTree.insert(62);
        bTree.insert(57);
        bTree.insert(55);
        bTree.insert(56);
        bTree.print(bTree.root, 0);
        System.out.println();

        bTree.insert(71);
        bTree.insert(84);

        bTree.print(bTree.root, 0);
    }
}