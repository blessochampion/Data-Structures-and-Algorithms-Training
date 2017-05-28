/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big4prep;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author azeez
 */
public class SingleNumber {
     public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        for (int i = 0; i < nums.length; ++i) {

            if (map.get(nums[i]) !=null) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
