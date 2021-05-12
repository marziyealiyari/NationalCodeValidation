package NationalCodeValidation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class NationalCode implements NationalCodeInterface {
    static Comparator<NationalCode> NationalCodeComparator = new Comparator<NationalCode>() {
        public int compare(NationalCode s1, NationalCode s2) {
            if (s1.getNationalCode() > s2.getNationalCode()) {
                return 1;
            } else if (s1.getNationalCode() == s2.getNationalCode()) {
                return 0;
            } else {
                return -1;
            }
        }
    };
    private static ArrayList<NationalCode> allNationalCode = new ArrayList<>();
    private boolean validation;
    private Date time;
    private long nationalCode;

    NationalCode() {
    }

    NationalCode(boolean validation, Date time, long nationalCode) {
        this.validation = validation;
        this.time = time;
        this.nationalCode = nationalCode;
    }

    static void addNationalCode(NationalCode nc) {
        allNationalCode.add(nc);
    }

    static ArrayList<NationalCode> getAllNationalCode() {
        return (allNationalCode);
    }


    Date getTime() {
        return time;
    }

    StringBuilder getNationalCodeToString() {
        StringBuilder nationalCode1 = new StringBuilder(String.valueOf(nationalCode));
        while (nationalCode1.length() < 10) nationalCode1.insert(0, "0");
        return nationalCode1;
    }

    private long getNationalCode() {
        return nationalCode;
    }

    @Override
    public boolean validation(String codemeli) {
        StringBuilder codeMeli = new StringBuilder(codemeli);
        int j = 0;
        if (codeMeli.length() > 10) return false;
        else {
            while (codeMeli.length() < 10) codeMeli.insert(0, "0");
            for (int i = 9; i > 0; i--)
                j = j + ((11 - i) * Character.getNumericValue(codeMeli.charAt(i - 1)));
            j = (j % 11);
            j = 2 >= j ? j : 11 - j;
            //
            int counter = 0;
            int x = 0;
            while (counter < codeMeli.length()) {
                if (codeMeli.charAt(counter) == codeMeli.charAt(0)) x++;
                counter++;
            }
            return x != codeMeli.length() && j == Character.getNumericValue(codeMeli.charAt(codeMeli.length() - 1));
        }
    }

     boolean isValidation() {
        return validation;
    }


}
