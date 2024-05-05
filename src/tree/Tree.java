package tree;

public class Tree {
    TreeNode rootNode;

    public Tree() {
        this.rootNode = null;
    }

    public Tree(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    public Tree(int data, Tree leftTree, Tree rightTree) {
        this.rootNode = new TreeNode(data);
        if (leftTree != null) {
            this.rootNode.leftNode = leftTree.rootNode;
        } else {
            this.rootNode.leftNode = null;
        }

        if (rightTree != null) {
            this.rootNode.rightNode = rightTree.rootNode;
        } else {
            this.rootNode.rightNode = null;
        }
    }

    public boolean isLeafNode(TreeNode node) {
        if (node == null) return true;
        return node.leftNode == null && node.rightNode == null;
    }

    public TreeNode search(int key) {
        TreeNode currentNode = this.rootNode;
        if (currentNode == null) {
            return new TreeNode(Integer.MIN_VALUE);
        }
        while (currentNode.data != key) {
            if (key < currentNode.data) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
            if (currentNode == null) {
                return new TreeNode(Integer.MIN_VALUE);
            }
        }
        return currentNode;
    }

    public void traverseTreeInOrder(TreeNode rootNode) {
        if (rootNode != null) {
            traverseTreeInOrder(rootNode.leftNode);
            System.out.println(rootNode.data);
            traverseTreeInOrder(rootNode.rightNode);
        }
    }

    public void traverseTreePreOrder(TreeNode rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.data);
            traverseTreePreOrder(rootNode.leftNode);
            traverseTreePreOrder(rootNode.rightNode);
        }
    }

    public void traverseTreePostOrder(TreeNode rootNode) {
        if (rootNode != null) {
            traverseTreePostOrder(rootNode.leftNode);
            traverseTreePostOrder(rootNode.rightNode);
            System.out.println(rootNode.data);
        }
    }

    public TreeNode findMinimumNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode currentNode = root;
        while (currentNode.leftNode != null) {
            currentNode = currentNode.leftNode;
        }
        return currentNode;
    }

    public TreeNode findMaximumNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode currentNode = root;
        while (currentNode.rightNode != null) {
            currentNode = currentNode.rightNode;
        }
        return currentNode;
    }

    public void insertNode(int data) {
        TreeNode node = new TreeNode(data);
        if (rootNode == null) {
            rootNode = node;
        } else {
            TreeNode currentNode = rootNode;
            TreeNode parentNode;

            while (true) {
                parentNode = currentNode;
                if (data < currentNode.data) {
                    currentNode = currentNode.leftNode;
                    if (currentNode == null) {
                        parentNode.leftNode = node;
                        return;
                    }
                } else {
                    currentNode = currentNode.rightNode;
                    if (currentNode == null) {
                        parentNode.rightNode = node;
                        return;
                    }
                }
            }
        }
    }

    public void deleteNode(int data) {
        TreeNode currentNode = this.rootNode;
        TreeNode parentNode = null;

        while (currentNode != null && currentNode.data != data) {
            parentNode = currentNode;
            if (data < currentNode.data) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }

        if (currentNode == null) {
            return;
        }

        // if delete node id leaf node
        if (isLeafNode(currentNode)) {
            if (parentNode == null) {
                this.rootNode = null;
            } else if (parentNode.leftNode == currentNode) {
                parentNode.leftNode = null;
            } else {
                parentNode.rightNode = null;
            }
        }

        // if only right child present
        else if (currentNode.leftNode == null) {
            if (parentNode == null) {
                this.rootNode = currentNode.rightNode;
            } else if (parentNode.leftNode == currentNode) {
                parentNode.leftNode = currentNode.rightNode;
            } else {
                parentNode.rightNode = currentNode.rightNode;
            }
        }

        // if only left child present
        else if (currentNode.rightNode == null) {
            if (parentNode == null) {
                this.rootNode = currentNode.leftNode;
            } else if (parentNode.leftNode == currentNode) {
                parentNode.leftNode = currentNode.leftNode;
            } else {
                parentNode.rightNode = currentNode.leftNode;
            }
        }

        // if both child present
        else {
            if (currentNode.rightNode.leftNode == null) {
                int successorKey = currentNode.rightNode.data;
                deleteNode(successorKey);
                currentNode.data = successorKey;
            } else {
                TreeNode temp = currentNode.rightNode;
                TreeNode tempParent = null;
                while (temp.leftNode != null) {
                    tempParent = temp;
                    temp = temp.leftNode;
                }

                currentNode.data = temp.data;
                tempParent.leftNode = temp.rightNode;
            }
        }
    }
}
