```
package greedy;

import java.util.*;

public class Conf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> confs = new HashMap<>();

        for(int i=0; i<n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            confs.put(end, start);
        }

        TreeMap<Integer,Integer> confsMap = new TreeMap<Integer, Integer>(confs);
        Set<Integer> keyset = confsMap.keySet();
        Iterator<Integer> keyiterator = confsMap.keySet( ).iterator( );

        int k;
        int v;

        int confCnt = 0;
        int endTime = 0;

        while(keyiterator.hasNext()) {
            k = (Integer)keyiterator.next();
            v = (Integer)confsMap.get(k);
            if(endTime == 0) {
                confCnt++;
                endTime = k;
            } else {
                if(v >= endTime) {
                    confCnt++;
                    endTime = k;
                }
            }
        }

        System.out.println(confCnt);

    }
}


```

