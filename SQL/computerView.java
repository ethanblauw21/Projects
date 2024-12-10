import java.util.ArrayList;
import java.util.Scanner;

public class computerView {
    Scanner kb;

    public computerView() {
        kb = new Scanner(System.in);
    }

    public int getUserInputPrice() {
        System.out.println("Enter the max price that you would like to see: ");
        int price = kb.nextInt();
        kb.nextLine();
        return price;
    }

    public int getUserInputColor() {
        System.out.println("Enter 1 for color printers and 0 for non-color printers that you would like to see: ");
        int color = kb.nextInt();
        return color;
    }

    public Float getUserInputMaxScreen() {
        System.out.println("Enter the max screen size that you would like to see: ");
        Float screen = kb.nextFloat();
        kb.nextLine();
        return screen;
    }

    public Float getUserInputMinScreen() {
        System.out.println("Enter the min screen size that you would like to see: ");
        Float screen = kb.nextFloat();
        kb.nextLine();
        return screen;
    }

    public int getOrderModel() {
        System.out.println("Enter the model no. of the item bought: ");
        int className = kb.nextInt();
        return className;
    }

    public int getOrderPrice() {
        System.out.println("Enter the price of the item bought: ");
        int country = kb.nextInt();
        return country;
    }

    public void displayPC(ArrayList<PC> PC) {
        int numPCs = PC.size();
        for (int i = 0; i < numPCs; i++) {
            PC currPC = PC.get(i);
            System.out.println(i + ": Maker: " + currPC.getMaker() + " Model: " + currPC.getModel() + " Speed: " + currPC.getSpeed() + " RAM: " + currPC.getRam() + " HD: " + currPC.getHd() + " Price: " + currPC.getPrice());
            
        }
        System.out.println("End of data.");
    }

    public void displayPrinter(ArrayList<Printer> Printer) {
        int numPrinters = Printer.size();
        for (int i = 0; i < numPrinters; i++) {
            Printer currPrinter = Printer.get(i);
            System.out.println(i + ": Maker: " + currPrinter.getMaker() + " Model: " + currPrinter.getModel() + " Type: " + currPrinter.getPrinterType() + " Color: " + currPrinter.getColor() + " Price: " + currPrinter.getPrice());
            
        }
        System.out.println("End of data.");
    }

    public void displayLaptop(ArrayList<Laptop> Laptop) {
        int numLaptops = Laptop.size();
        for (int i = 0; i < numLaptops; i++) {
            Laptop currLaptop = Laptop.get(i);
            System.out.println(i + ": Maker: " + currLaptop.getMaker() + " Model: " + currLaptop.getModel() + " Speed: " + currLaptop.getSpeed() + " RAM: " + currLaptop.getRam() + " HD: " + currLaptop.getHd() + " Screen: " + currLaptop.getScreen() + " Price: " + currLaptop.getPrice());
            
        }
        System.out.println("End of data.");
    }
}