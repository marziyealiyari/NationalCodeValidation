package NationalCodeValidation;

import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        NationalCode nationalCode = new NationalCode();
        System.out.println("لطفا کد ملی را وارد نمایید: ");
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            if (input.hasNextLong())
            {
                String code = (input.nextLine().replaceAll("[^0-9]", ""));
                try {
                    NationalCode.addNationalCode(new NationalCode(nationalCode.validation(String.valueOf(code)), new Date(), Long.parseLong(code)));
                } catch (NumberFormatException e) {
                    System.out.println("لطفا عدد وارد نمایید");
                }
            } else {
                if (input.nextLine().toLowerCase().equals("exit")) {
                    Runtime.getRuntime().addShutdownHook(new Thread() {
                        public void run() {
                            Collections.sort(NationalCode.getAllNationalCode(), NationalCode.NationalCodeComparator);
                            for (NationalCode x : NationalCode.getAllNationalCode()) {
                                System.out.println(" کدملی: " + x.getNationalCodeToString() + "       وضعیت اعتبار: " + x.isValidation() + "       زمان ورود اطلاعات: " + x.getTime());
                            }
                        }
                    });
                    System.exit(0);
                } else System.out.println("لطفا عدد وارد نمایید");
            }
        }
        input.close();
    }
}
