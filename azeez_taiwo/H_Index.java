/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big4prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azeez
 */
public class H_Index {

    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            int min = Math.min(citations[i], citations.length - i);
            hIndex = Math.max(hIndex, min);
        }

        return hIndex;
    }
}
