//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 932 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author: tomster
 * @data: 2021-06-19 23:18:25
 */
public class MinStack {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NyMinStack {
        int min;
        LinkedList<Integer> eleList;

        /**
         * initialize your data structure here.
         */
        public NyMinStack() {
            eleList = new LinkedList<>();
        }

        public void push(int val) {
            if (eleList.isEmpty()) {
                min = val;
            } else {
                if (val < min) {
                    min = val;
                }
            }
            eleList.addLast(val);
        }

        public void pop() {
            eleList.removeLast();
            int minVal = Integer.MAX_VALUE;
            for (Integer integer : eleList) {
                if (integer < minVal) {
                    minVal = integer;
                }
            }
            min = minVal;
        }

        public int top() {
            return eleList.peekLast();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}