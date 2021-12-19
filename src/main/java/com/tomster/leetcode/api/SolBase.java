package com.tomster.leetcode.api;

import java.util.Random;

/**
 * @author meihewang
 * @date 2021/12/19  16:15
 */
public class SolBase {
    public int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
