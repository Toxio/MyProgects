package Week3Day1.notebooks.view;

import Week3Day1.notebooks.domain.Notebooks;
import Week3Day1.notebooks.Service;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 2/10/13
 */
public class Menu {
   // public static final Logger log = Logger.getLogger(Menu.class.getName());


      public void start() {
        boolean isInterrupted = false;
        Decision decision = Decision.EXIT;
        try {
        while(!isInterrupted) {
            showMenu();
            decision = getAndValidateInput();
            switch (decision) {
                case EXIT:
                    Service.exit();
                    break;
                case CREATE_NOUT:
                    Notebooks nout = Service.creteNotebook();
                    Service.saveNotebook(nout);
                    break;
                case SHOW_ALL_NOUTS:
                    Service.showNotebooks();
                    break;
                case SHOW_VENDOR:
                    Service.showVendors();
                    break;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Decision getAndValidateInput() {
        Scanner scan = new Scanner(System.in);
        String res = scan.nextLine();
        // TODO validate
        int decision = Integer.valueOf(res);
        return Decision.getByCode(decision);
    }

    private void showMenu() {
        System.out.println("1. Create");
        System.out.println("2. Show nouts");
        System.out.println("3. Show vendor");
        System.out.println("0. Exit");
    }
}
