package com.tomster.leetcode.api;

/**
 * @author meihewang
 * @date 2022/04/18  17:55
 */
public class GuessGame {

    int num;

    public int guess(int num) {
        return this.num == num ? 0 : (this.num - num) / Math.abs(this.num - num);
    }

}
