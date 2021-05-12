package NationalCodeValidation;

import java.util.ArrayList;

/**
 * Created by aliyari on 17/03/2021.
 */
public class utility {
    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
