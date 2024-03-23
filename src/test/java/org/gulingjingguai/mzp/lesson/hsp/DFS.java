package org.gulingjingguai.mzp.lesson.hsp;

import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        Tree tree = new Tree(4,null,null);
        Tree tree1 = new Tree(6,null,null);
        Tree tree2 = new Tree(9,null,null);
        Tree tree3 = new Tree(8,null,null);
        Tree tree4 = new Tree(5,null,null);
        tree.setLNode(tree1);
        tree.setRNode(tree2);
        tree1.setLNode(tree3);
        tree1.setRNode(tree4);
        // 递归深度优先

        if(tree == null){
            System.out.println("空树");
        }
        dfsR(tree);

        //非递归
        dfs(tree);
    }

    /**
     * 算法思想：
     * 1. 使用栈
     * 2. 栈的特点，先进后出
     * 3. 选择根节点入栈，根节点出栈并判断是否有子节点
     * 4. 添加出栈节点的右节点和左节点
     * 5. 直到栈中元素为空
     * @param tree
     */
    private static void dfs(Tree tree) {
        Stack<Tree> stack = new Stack();
        stack.push(tree);

        while(!stack.isEmpty()){
            Tree tempTree = stack.pop();

            System.out.println(tempTree.getNode());

            if(tempTree.getRNode() != null){
                stack.push(tempTree.getRNode());
            }

            if(tempTree.getLNode() != null){
                stack.push(tempTree.getLNode());
            }
        }
    }

    /**
     * 递归深度优先遍历
     * @param tree
     */
    private static void dfsR(Tree tree) {
        if(tree != null){
            System.out.println(tree.getNode());
            dfsR(tree.getLNode());
            dfsR(tree.getRNode());
        }
    }
}