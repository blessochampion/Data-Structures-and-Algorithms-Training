package Potential;

import java.util.HashMap;

/**
@QuestionUrl: https://leetcode.com/problems/single-number/#/description
 * Created by blessochampion on 5/21/17.
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.print(singleNumber(new int[]{3,3,1}));
    }

  public   static int singleNumber(int[] nums) {
        int result;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else {
                map.put(nums[i], 1);
            }
        }

        return (int) map.keySet().toArray()[0];
    }

    
}
