package org.gulingjingguai.mzp.lesson.hsp;

public class Tree {
    private int node;

    private Tree LNode;

    private Tree RNode;

    public Tree(int node, Tree LNode, Tree RNode) {
        this.node = node;
        this.LNode = LNode;
        this.RNode = RNode;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public Tree getLNode() {
        return LNode;
    }

    public void setLNode(Tree LNode) {
        this.LNode = LNode;
    }

    public Tree getRNode() {
        return RNode;
    }

    public void setRNode(Tree RNode) {
        this.RNode = RNode;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "node=" + node +
                ", LNode=" + LNode +
                ", RNode=" + RNode +
                '}';
    }
}
