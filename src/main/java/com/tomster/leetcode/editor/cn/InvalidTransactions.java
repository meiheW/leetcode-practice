//如果出现下述两种情况，交易 可能无效： 
//
// 
// 交易金额超过 ¥1000 
// 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整） 
// 
//
// 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。 
//
// 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
//输出：["alice,20,800,mtv","alice,50,100,beijing"]
//解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。 
//
// 示例 2： 
//
// 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
//输出：["alice,50,1200,mtv"]
// 
//
// 示例 3： 
//
// 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
//输出：["bob,50,1200,mtv"]
// 
//
// 
//
// 提示： 
//
// 
// transactions.length <= 1000 
// 每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录 
// 每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间 
// 每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数 
// 每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数 
// 
// Related Topics 数组 哈希表 字符串 排序 
// 👍 26 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2021-09-25 17:39:41
 */
public class InvalidTransactions {
    public static void main(String[] args) {
        Solution solution = new InvalidTransactions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<String> invalidTransactions(String[] transactions) {
            /*构建map, key:name,value:transaction*/
            Map<String, List<Transaction>> map = new HashMap<>();
            for (String transaction : transactions) {
                Transaction t = new Transaction(transaction);
                map.computeIfAbsent(t.name, e -> new ArrayList<>());
                map.get(t.name).add(t);
            }
            /*遍历数组*/
            List<String> ans = new ArrayList<>();
            for (String transaction : transactions) {
                Transaction cur = new Transaction(transaction);
                List<Transaction> transactionList = map.get(cur.name);
                if (!isValid(cur, transactionList)) {
                    ans.add(transaction);
                }
            }
            return ans;
        }


        private boolean isValid(Transaction t1, List<Transaction> ts) {
            //金额限制
            if (t1.amount > 1000) {
                return false;
            }
            //城市名相同，时间限制
            for (Transaction t2 : ts) {
                if (!t2.city.equals(t1.city) && Math.abs(t2.time - t1.time) <= 60) {
                    return false;
                }
            }
            return true;
        }

        class Transaction {
            String name;
            int time;
            int amount;
            String city;

            public Transaction(String transaction) {
                String[] arr = transaction.split(",");
                this.name = arr[0];
                this.time = Integer.parseInt(arr[1]);
                this.amount = Integer.parseInt(arr[2]);
                this.city = arr[3];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}