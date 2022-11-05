package com.tomster.leetcode.entity.search;

/**
 * @author meihewang
 * @date 2022/09/12  12:00
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

}