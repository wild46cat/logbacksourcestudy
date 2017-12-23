package com.xueyou.graph;

/**
 * Created by wuxueyou on 2017/12/12.
 */
public class node {
    private int source;
    private int target;

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public node() {
    }

    public node(int source, int target) {
        this.source = source;
        this.target = target;
    }
}
