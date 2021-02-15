package com.tomster.leetcode.entity.level;

import java.util.List;

/**
 * @author meihewang
 * @date 2021/02/15  18:29
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
