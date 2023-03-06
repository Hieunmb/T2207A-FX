package exam;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListCustomer cus = new ListCustomer();
        Scanner sc = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("-------------");
            System.out.println("MENU");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("0. Exit");
            select=sc.nextInt();
            switch (select) {
                case 1:
                    cus.addCus();
                    break;
                case 2:
                    cus.findCustomer();
                    break;
                case 3:
                    cus.display();
                    break;
            }
        }while (select!=0);
    }
}