//地铁系统跟踪不同车站之间的乘客出行时间，并使用这一数据来计算从一站到另一站的平均时间。 
//
// 实现 UndergroundSystem 类： 
//
// 
// void checkIn(int id, string stationName, int t)
//
// 
// 通行卡 ID 等于 id 的乘客，在时间 t ，从 stationName 站进入 
// 乘客一次只能从一个站进入 
// 
// 
// void checkOut(int id, string stationName, int t)
// 
// 通行卡 ID 等于 id 的乘客，在时间 t ，从 stationName 站离开 
// 
// 
// double getAverageTime(string startStation, string endStation)
// 
// 返回从 startStation 站到 endStation 站的平均时间 
// 平均时间会根据截至目前所有从 startStation 站 直接 到达 endStation 站的行程进行计算，也就是从 startStation 站进入
//并从 endStation 离开的行程 
// 从 startStation 到 endStation 的行程时间与从 endStation 到 startStation 的行程时间可能不同 
// 在调用 getAverageTime 之前，至少有一名乘客从 startStation 站到达 endStation 站 
// 
// 
// 
//
// 你可以假设对 checkIn 和 checkOut 方法的所有调用都是符合逻辑的。如果一名乘客在时间 t1 进站、时间 t2 出站，那么 t1 < t2 
//。所有时间都按时间顺序发生。 
// 
//
// 示例 1： 
//
// 
//输入
//["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","chec
//kOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","g
//etAverageTime"]
//[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,
//"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"
//],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"
//]]
//
//输出
//[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00
//000]
//
//解释
//UndergroundSystem undergroundSystem = new UndergroundSystem();
//undergroundSystem.checkIn(45, "Leyton", 3);
//undergroundSystem.checkIn(32, "Paradise", 8);
//undergroundSystem.checkIn(27, "Leyton", 10);
//undergroundSystem.checkOut(45, "Waterloo", 15);  // 乘客 45 "Leyton" -> "Waterlo
//o" ，用时 15-3 = 12
//undergroundSystem.checkOut(27, "Waterloo", 20);  // 乘客 27 "Leyton" -> "Waterlo
//o" ，用时 20-10 = 10
//undergroundSystem.checkOut(32, "Cambridge", 22); // 乘客 32 "Paradise" -> "Cambr
//idge" ，用时 22-8 = 14
//undergroundSystem.getAverageTime("Paradise", "Cambridge"); // 返回 14.00000 。只有一
//个 "Paradise" -> "Cambridge" 的行程，(14) / 1 = 14
//undergroundSystem.getAverageTime("Leyton", "Waterloo");    // 返回 11.00000 。有两个
// "Leyton" -> "Waterloo" 的行程，(10 + 12) / 2 = 11
//undergroundSystem.checkIn(10, "Leyton", 24);
//undergroundSystem.getAverageTime("Leyton", "Waterloo");    // 返回 11.00000
//undergroundSystem.checkOut(10, "Waterloo", 38);  // 乘客 10 "Leyton" -> "Waterlo
//o" ，用时 38-24 = 14
//undergroundSystem.getAverageTime("Leyton", "Waterloo");    // 返回 12.00000 。有三个
// "Leyton" -> "Waterloo" 的行程，(10 + 12 + 14) / 3 = 12
// 
//
// 示例 2： 
//
// 
//输入
//["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut
//","getAverageTime","checkIn","checkOut","getAverageTime"]
//[[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5
//,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton
//","Paradise"]]
//
//输出
//[null,null,null,5.00000,null,null,5.50000,null,null,6.66667]
//
//解释
//UndergroundSystem undergroundSystem = new UndergroundSystem();
//undergroundSystem.checkIn(10, "Leyton", 3);
//undergroundSystem.checkOut(10, "Paradise", 8); // 乘客 10 "Leyton" -> "Paradise"
// ，用时 8-3 = 5
//undergroundSystem.getAverageTime("Leyton", "Paradise"); // 返回 5.00000 ，(5) / 1
// = 5
//undergroundSystem.checkIn(5, "Leyton", 10);
//undergroundSystem.checkOut(5, "Paradise", 16); // 乘客 5 "Leyton" -> "Paradise" 
//，用时 16-10 = 6
//undergroundSystem.getAverageTime("Leyton", "Paradise"); // 返回 5.50000 ，(5 + 6)
// / 2 = 5.5
//undergroundSystem.checkIn(2, "Leyton", 21);
//undergroundSystem.checkOut(2, "Paradise", 30); // 乘客 2 "Leyton" -> "Paradise" 
//，用时 30-21 = 9
//undergroundSystem.getAverageTime("Leyton", "Paradise"); // 返回 6.66667 ，(5 + 6 
//+ 9) / 3 = 6.66667
// 
//
// 
//
// 提示： 
//
// 
// 1 <= id, t <= 106 
// 1 <= stationName.length, startStation.length, endStation.length <= 10 次 
// 所有字符串由大小写英文字母与数字组成 
// 总共最多调用 checkIn、checkOut 和 getAverageTime 方法 2 * 104 
// 与标准答案误差在 10-5 以内的结果都被视为正确结果 
// 
// Related Topics 设计 哈希表 字符串 
// 👍 52 👎 0

package com.tomster.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tomster
 * @data: 2022-04-22 18:21:49
 */
public class DesignUndergroundSystem {
    public static void main(String[] args) {
        DesignUndergroundSystem designUndergroundSystem = new DesignUndergroundSystem();
        UndergroundSystem undergroundSystem = designUndergroundSystem.new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);

        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        double d1 = undergroundSystem.getAverageTime("Paradise", "Cambridge");
        double d2 = undergroundSystem.getAverageTime("Leyton", "Waterloo");

        System.out.println(d1);
        System.out.println(d2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class UndergroundSystem {

        class StationGapInfo {
            long num;
            long tsNum;

            public StationGapInfo(long num, long tsNum) {
                this.num = num;
                this.tsNum = tsNum;
            }
        }

        class CheckInInfo {
            String station;
            long ts;

            public CheckInInfo(String station, long ts) {
                this.station = station;
                this.ts = ts;
            }
        }

        //station1-station2, num  tsNum
        Map<String, StationGapInfo> stationGap;


        Map<Integer, CheckInInfo> checkInRecord;

        public UndergroundSystem() {
            stationGap = new HashMap<>();
            checkInRecord = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInRecord.put(id, new CheckInInfo(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            CheckInInfo checkInInfo = checkInRecord.get(id);
            if (checkInInfo == null) {
                return;
            }
            String key = checkInInfo.station + "," + stationName;
            long timeGap = t - checkInInfo.ts;
            StationGapInfo stationGapInfo = stationGap.get(key);
            if (stationGapInfo == null) {
                stationGap.put(key, new StationGapInfo(1, timeGap));
            } else {
                stationGapInfo.num++;
                stationGapInfo.tsNum += timeGap;
                stationGap.put(key, stationGapInfo);
            }
            checkInRecord.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "," + endStation;
            StationGapInfo stationGapInfo = stationGap.get(key);
            if (stationGapInfo == null) {
                return 0.0;
            }
            return 1.0 * stationGapInfo.tsNum / stationGapInfo.num;
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
//leetcode submit region end(Prohibit modification and deletion)

}