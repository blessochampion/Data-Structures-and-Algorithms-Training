/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big4prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azeez
 */
public class H_Index {

    Map<Integer, List<Integer>> notMoreThan = new HashMap<>();
    Map<Integer, List<Integer>> atLeast = new HashMap<>();
    int hIndex;

    public void process(int i, int j, Map<Integer, List<Integer>> map) {
        List<Integer> l = map.get(i);
        if (l != null) {
            l.add(j);
            map.put(i, l);
        } else {
            l = new ArrayList<>();
            l.add(j);
            map.put(i, l);
        }

    }

    public int hIndex(int[] citations) {

        for (int i = 1; i < citations.length; ++i) {

            for (int j = 0; j < citations.length; ++j) {
                if (citations[j] <= i) {
                    process(i, j, notMoreThan);
                }

                if (citations[j] >= i) {
                    process(i, j, atLeast);
                }
            }
        }

        for (int i = citations.length - 1; i > 0; --i) {
            int notMoreThanCount = notMoreThan.get(i) == null ? 0 : notMoreThan.get(i).size();

            int atLeastCount = atLeast.get(i) == null ? 0 : atLeast.get(i).size();
            if (notMoreThanCount == atLeastCount && notMoreThanCount == i) {
                hIndex = i;
                break;
            }

        }

        return hIndex;
    }
}
