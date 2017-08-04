package com.cpcn.test;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cpcn.util.TimeUtil;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年8月2日      汉诺塔算法解析
 * </pre>
 */
public class TowersOfHanoi {

	private static final Logger logger = LoggerFactory.getLogger(TowersOfHanoi.class);

	public void hanoi(int n, char A, char B, char C) {
		if (n == 1) {
			System.out.printf("Move sheet %d from %c to %c\n", n, A, C);
		} else {
			// 1. 将A柱n-1个盘子从A移动到B
			hanoi(n - 1, A, C, B);
			// 2. 将A柱的第n个盘子移动到C柱
			System.out.printf("Move sheet %d from %c to %c\n", n, A, C);
			// 3. 将B柱的n-1个盘子移动到C柱
			hanoi(n - 1, B, A, C);
		}

	}

	public static void main(String[] args) {
		// A柱上盘子的数量
		int n = 10;
		TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
		String startTime = TimeUtil.getTimeStamp();
		long beginTimeInMillSeconds = new Date().getTime();
		towersOfHanoi.hanoi(n, '1', '2', '3');
		String endTime = TimeUtil.getTimeStamp();
		long endTimeInMillSeconds = new Date().getTime();
		logger.debug("TowersOfHanoi" + " end. From " + startTime + " to " + endTime);
		logger.debug("TowersOfHanoi ProcessTime: (" + (endTimeInMillSeconds - beginTimeInMillSeconds) + ")ms");
	}
}
