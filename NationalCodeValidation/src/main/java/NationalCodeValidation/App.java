package NationalCodeValidation;

import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        NationalCodeValidation nationalCode= new NationalCodeValidation();
        System.out.println("لطفا کد ملی را وارد نمایید: ");
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            if (input.hasNextLong())
                System.out.println("validation: " + nationalCode.validation((input.nextLine().replace(" ", ""))) + "\nat time: " + new Date());
            else {
                if (input.nextLine().toLowerCase().equals("exit")) {
                    Runtime.getRuntime().addShutdownHook(new Thread() {
                        public void run() {
                            sortNationalCode.sortArray(NationalCodeValidation.getAllNationalCode());
                        }
                    });
                    System.exit(0);
                } else System.out.println("لطفا عدد وارد نمایید");
            }
        }
        input.close();
    }
}
