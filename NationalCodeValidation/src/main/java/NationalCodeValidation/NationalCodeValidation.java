package NationalCodeValidation;
import java.util.ArrayList;
import static NationalCodeValidation.utility.convertIntegers;

/**
 * Created by aliyari on 16/03/2021.
 */
public class NationalCodeValidation implements NationalCodeInterface {

    private static ArrayList<Integer> allNationalCode = new ArrayList<>();

    private static void addNationalCode(StringBuilder sb) {
        allNationalCode.add(Integer.parseInt(sb.toString()));
    }

    public static int[] getAllNationalCode() {
        return convertIntegers(allNationalCode);
    }

    @Override
    public boolean validation(String codemeli) {
        StringBuilder codeMeli = new StringBuilder(codemeli);
        int j = 0;
        if (codeMeli.length() > 10) return false;
        else {
            while (codeMeli.length() < 10) codeMeli.insert(0, "0");
            NationalCodeValidation.addNationalCode(codeMeli);
            for (int i = 9; i > 1; i--)
                j = j + (10 - i) * Character.getNumericValue(codeMeli.charAt(i));
            j = j / 11;
            j = 2 > j ? j : 11 - j;
            return j == Character.getNumericValue(codeMeli.charAt(codeMeli.length() - 1));
        }
    }
}
