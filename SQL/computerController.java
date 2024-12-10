import java.util.ArrayList;
import java.util.Scanner;
public class computerController {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        boolean exit = false;
        computerView view = new computerView();
        computerModel mod = new computerModel();
        mod.updateOrderNum();
        p("What would you like to look for");
        p("Enter done to exit the searching");
        String answer = input.next();
        while (!exit){
            int listSearch;
            answer = answer.toLowerCase();
            if(answer.equals("laptop")){
                Float minScreen = view.getUserInputMinScreen();
                Float maxScreen = view.getUserInputMaxScreen();
                ArrayList<Laptop> results = mod.queryLaptopScreen(minScreen, maxScreen);
                view.displayLaptop(results);
                p("Please enter the number of the of the item that you would like to add to your cart");
                p("If you do not want to buy anything, enter -1");
                listSearch = input.nextInt();
                if(listSearch != -1){
                    while(listSearch >= results.size()){
                        p("The number you entered is not in the list please select again");
                        view.displayLaptop(results);
                        p("Please enter the number of the of the item that you would like to add to your cart");
                        listSearch = input.nextInt();
                    }
                    mod.insertNewOrder(results.get(listSearch).getModel(), results.get(listSearch).getPrice());
                }
                p("If you want to look for something else, enter what you are looking for");
                p("If not enter done to checkout");
                answer = input.next();
            }
            else if(answer.equals("pc")){
                int maxPrice = view.getUserInputPrice();
                ArrayList<PC> results = mod.queryPCPrice(maxPrice);
                view.displayPC(results);
                p("Please enter the number of the of the item that you would like to add to your cart");
                p("If you do not want to buy anything, enter -1");
                listSearch = input.nextInt();
                if(listSearch != -1){
                    while(listSearch >= results.size()){
                        p("The number you entered is not in the list please select again");
                        view.displayPC(results);
                        p("Please enter the number of the of the item that you would like to add to your cart");
                        listSearch = input.nextInt();
                    }
                    mod.insertNewOrder(results.get(listSearch).getModel(), results.get(listSearch).getPrice());
                }
                p("If you want to look for something else, enter what you are looking for");
                p("If not enter done to checkout");
                answer = input.next();
            }
            else if(answer.equals("printer")){
                int color = view.getUserInputColor();
                ArrayList<Printer> results = mod.queryPrinterColor(color);
                view.displayPrinter(results);
                p("Please enter the number of the of the item that you would like to add to your cart");
                p("If you do not want to buy anything, enter -1");
                listSearch = input.nextInt();
                if(listSearch != -1){
                    while(listSearch >= results.size()){
                        p("The number you entered is not in the list please select again");
                        view.displayPrinter(results);
                        p("Please enter the number of the of the item that you would like to add to your cart");
                        listSearch = input.nextInt();
                    }
                    mod.insertNewOrder(results.get(listSearch).getModel(), results.get(listSearch).getPrice());
                }
                p("If you want to look for something else, enter what you are looking for");
                p("If not enter done to checkout");
                answer = input.next();
            }
            else if(answer.equals("exit")){
                exit = true;
            }
            else if(answer.equals("done")){
                loop = false;
            }
            else{
                p("We do not carry what you entered.");
                p("Please enter, Laptop, Printer, or PC");
                answer = input.next();
            }
            if(!loop){
                if(mod.getOrderNum() == mod.getLargestOrder()){
                    p("Order Summary: ");
                    mod.displayOrder();
                    p("Thank you for your business.");
                    mod.updateProductTable();
                    mod.updateOrderNum();
                    loop = true;
                    p("What would you like to look for");
                    p("Enter done to exit the searching");
                    answer = input.next();
                }
            }
        }
        

       // int model = view.getOrderModel();
        //int price = view.getOrderPrice();
        //p("Inserting " + (mod.getLargestOrder() + 1) + " " + model + " " + price + " " + "Ethan");
       // mod.insertNewOrder(model, price);
        // Example of inserting a new record into the database using the view and model
        //String className = view.getUserInputClass();
        //String countryName = view.getUserInputCountry();
        //System.out.println("Inserting " + className + " " + countryName + ".");
        //mod.insertNewClass(className, countryName);
    }

    public static void p(Object x){
        System.out.println(x);
    }
}