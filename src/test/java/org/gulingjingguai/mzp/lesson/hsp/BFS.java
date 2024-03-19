package org.gulingjingguai.mzp.lesson.hsp;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

        // 广度优先遍历
        bfs(tree);
    }

    /**
     * 广度优先遍历
     * 算法思想：
     * 1. 使用队列
     * 2. 队列特点，先进先出
     * 3. 选择根节点入队列，根节点出队列，判断是否有子节点
     * 4. 先加左节点，后加右节点
     * 5. 直到队列中没有元素
     * @param tree
     */
    private static void bfs(Tree tree) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            Tree tempTree = queue.poll();

            System.out.println(tempTree.getNode());

            if(tempTree.getLNode() != null) {
                queue.add(tempTree.getLNode());
            }

            if(tempTree.getRNode() != null) {
                queue.add(tempTree.getRNode());
            }
        }
    }
}
