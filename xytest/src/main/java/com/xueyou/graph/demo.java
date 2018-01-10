package com.xueyou.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxueyou on 2017/12/12.
 */
public class demo {
    public static void main(String[] args) {
        List<node> nodeList = new ArrayList<>();
        node node = new node(1, 2);
        node node2 = new node(1, 6);
        node node3 = new node(2, 4);
        node node4 = new node(2, 5);
        node node7 = new node(4, 3);
        node node1 = new node(1, 4);
        node node8 = new node(5, 7);
        node node9 = new node(6, 7);
        node node6 = new node(3, 7);
        node node5 = new node(3, 2);
        nodeList.add(node);
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);
        nodeList.add(node7);
        nodeList.add(node8);
        nodeList.add(node9);
        List<Integer> ints = new ArrayList<>();
        findpath(nodeList, 1, 7, ints);
    }

    public static void findpath(List<node> nodeList, int source, int target, List<Integer> path) {
        System.out.println(path);
        if (path.indexOf(source) > -1) {
            return;
        }
        path = cleanMutilPath(path);
        for (int i = 0; i < nodeList.size(); i++) {
            node node = nodeList.get(i);
            if (node.getSource() == source) {
                //如果相等则找到路径
                if (node.getTarget() == target) {
                    path.add(node.getSource());
                    path.add(node.getTarget());
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList = cleanMutilPath(path);
                    System.out.println("find path origin:" + path);
                    System.out.println("find path clean:" + tmpList);
                    path.clear();
                    return;
                }
                path.add(node.getSource());
                findpath(nodeList, node.getTarget(), target, path);
            }
        }
    }

    public static List<Integer> cleanMutilPath(List<Integer> path) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer integer : path) {
            if (tmp.indexOf(integer) < 0) {
                tmp.add(integer);
            }
        }
        return tmp;
    }
}
