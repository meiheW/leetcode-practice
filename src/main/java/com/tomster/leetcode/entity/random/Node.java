package com.tomster.leetcode.entity.random;

/**
 * @author meihewang
 * @date 2022/09/12  11:47
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
