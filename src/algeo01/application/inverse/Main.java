package algeo01.application.inverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Available menus
        final String[] menus = new String[]{
                "Metode Adjoin",
                "Metode Matriks Balikan",
                "Kembali"
        };

        // Display menu
        System.out.println("MENU MATRIKS BALIKAN");
        for (int i = 0; i < menus.length; i++){
            System.out.println((i + 1) + ". " + menus[i]);
        }

        // Asking for user input
        int selectedMenu = 0;
        String strSelectedMenu;
        Scanner input = new Scanner(System.in);

        // Input validation
        boolean isInputInteger = false, isInputAvail = false;
        while (!isInputAvail || !isInputInteger) {
            System.out.print("Pilih menu: ");
            strSelectedMenu = input.nextLine();
            // Input must be an integer
            try{
                selectedMenu = Integer.parseInt(strSelectedMenu);
                isInputInteger = true;

                // Input must be available
                isInputAvail = (0 < selectedMenu && selectedMenu <= menus.length) ? true : false;
            } catch(NumberFormatException e) {}
            if(!isInputAvail || !isInputInteger){
                System.out.println("Menu tidak tersedia");
            }
        }

        // Calling Another Application
        switch (selectedMenu) {
            case 1:
                // Call Inverse Adjoin App
                algeo01.application.inverse.inverseAdj.Main.main(null);
                break;
            case 2:
                // Call Inverse OBE App
                algeo01.application.inverse.inverseOBE.Main.main(null);
                break;
            case 3:
                // Back
                algeo01.application.Main.main(null);
                break;
        }
    }
}
