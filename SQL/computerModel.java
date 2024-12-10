import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class computerModel {

    private Connection conn;
    private ArrayList<PC> PC = new ArrayList<PC>();
    private ArrayList<Printer> Printer = new ArrayList<Printer>();
    private ArrayList<Laptop> Laptop = new ArrayList<Laptop>();
    private ArrayList<Object> cart = new ArrayList<Object>();
    private int orderNum;
    

    public computerModel() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:./computers.db");
            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
        
    /*public ArrayList<Laptop> testQuery(){
        try{
            String query = "SELECT * FROM Laptop";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Laptop currTop = new Laptop(rs.getInt("model"), rs.getFloat("speed"), rs.getInt("ram"), rs.getInt("hd"), rs.getFloat("screen"), 0);
                Laptop.add(currTop);
            }
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return Laptop;
    }*/

    public ArrayList<PC> queryPCPrice(int maxPrice) {
        try {
            String query = "SELECT maker, model, speed, ram, hd, price FROM PC NATURAL JOIN Product WHERE price between 0 and ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, maxPrice);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PC currentPC = new PC(rs.getString("maker").charAt(0), rs.getInt("model"), rs.getFloat("speed"), rs.getInt("ram"), rs.getInt("hd"), rs.getInt("price"));
                PC.add(currentPC);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return PC;
    }

    public ArrayList<Printer> queryPrinterColor(int color){
        try{
            String query = "SELECT maker, model, color, printerType, price FROM Printer NATURAL JOIN Product WHERE color = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, color);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Printer currentPrinter = new Printer(rs.getString("maker").charAt(0), rs.getInt("model"), rs.getString("color"), rs.getString("printerType"), rs.getInt("price"));
                Printer.add(currentPrinter);
            }
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return Printer;
    }

    public ArrayList<Laptop> queryLaptopScreen(Float minSize, Float maxSize){
        try{
            String query = "SELECT maker, model, speed, ram, hd, screen, price FROM Laptop NATURAL JOIN Product WHERE screen BETWEEN ? AND ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setFloat(1, minSize);
            statement.setFloat(2, maxSize);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Laptop currLaptop = new Laptop(rs.getString("maker").charAt(0), rs.getInt("model"), rs.getFloat("speed"), rs.getInt("ram"), rs.getInt("hd"), rs.getFloat("screen"), rs.getInt("price"));
                Laptop.add(currLaptop);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return Laptop;
    }


    public void insertNewOrder(int model, int price) {
        try {
            String query = "INSERT INTO Orders VALUES (?, ?, ?, 'Ethan')";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, orderNum);
            statement.setInt(2, model);
            statement.setInt(3, price);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateOrderNum(){
        orderNum = getLargestOrder() + 1;
    }

    public int getLargestOrder(){
        int result = 0;
        try{
            String query = "SELECT MAX(orderNumber) FROM Orders";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            result = rs.getInt("MAX(orderNumber)");
        }catch (SQLException e){
            System.err.println(e.getMessage());
            System.out.println("largest order");
        }
        return result;
    }

    public void displayOrder(){
        try{
            String query = "select model, price from Orders where orderNumber = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, orderNum);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println("Model: " + rs.getInt("model") + " Price: " + rs.getInt("price"));
                System.out.println();
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public int getOrderNum(){
        return orderNum;
    }

    public void updateProductTable(){
        try{
            String query = "update Product set inventory = inventory - 1 where model in (select model from Orders where orderNumber = ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, orderNum);
            statement.executeUpdate();
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.out.println("update product");
        }
    }
    
}