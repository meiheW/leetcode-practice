package com.tomster.leetcode.entity.flatten;

/**
 * @author meihewang
 * @date 2022/11/05  21:10
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val){
        this.val = val;
    }
};
