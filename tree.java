class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// create addNode, RemoveNode, FindNode by Pankaj Gupta
class Tree {
    TreeNode root;

    public Tree() {
        root = null;
    }

    // Add a node to the tree
    public void addNode(int data) {
        root = addNode(root, data);
    }

    private TreeNode addNode(TreeNode current, int data) {
        if (current == null) {
            return new TreeNode(data);
        }

        if (data < current.data) {
            current.left = addNode(current.left, data);
        } else if (data > current.data) {
            current.right = addNode(current.right, data);
        }

        return current;
    }

    // Remove a node from the tree
    public void removeNode(int data) {
        root = removeNode(root, data);
    }

    private TreeNode removeNode(TreeNode current, int data) {
        if (current == null) {
            return current;
        }

        if (data < current.data) {
            current.left = removeNode(current.left, data);
        } else if (data > current.data) {
            current.right = removeNode(current.right, data);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            current.data = findMinValue(current.right);
            current.right = removeNode(current.right, current.data);
        }

        return current;
    }

    private int findMinValue(TreeNode node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    //create preOrder, postOrder, inOrder treversal by Sandeep Solanki
    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    // Pre-order traversal (Root-Left-Right)
    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    // Post-order traversal (Left-Right-Root)
    public void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

}
