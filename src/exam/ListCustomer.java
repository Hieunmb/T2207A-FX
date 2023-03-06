package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListCustomer {
    private HashMap<String, Customer> list = new HashMap<>();

    public void addCus() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        Customer customer = new Customer(name, phone, email);
        list.put(name, customer);
        System.out.println("Customer added successfully.");
    }
    public void findCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        Customer customer = list.get(name);
        if (customer != null) {
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        } else {
            System.out.println("Not found.");
        }
    }
    public void display() {
        System.out.println("\tCRM");
        System.out.println("Name\tPhone");
        for (Map.Entry<String, Customer> h: list.entrySet()) {
            Customer customer = h.getValue();
            System.out.println(customer.getName()+"\t"+customer.getPhone());
        }
    }
}
