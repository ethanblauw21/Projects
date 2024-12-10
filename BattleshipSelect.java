import java.sql.*;

public class BattleshipSelect {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Use the SQLite driver to establish a connection
            conn = DriverManager.getConnection("jdbc:sqlite:./computers.db");
            System.out.println("Successfully connected using the driver!");

            // Then, use that connection object to create a Statement
            Statement statement = conn.createStatement();
            System.out.println("Used the connection to create a statement object.");

            // Finally, use the Statement object to execute an SQL query and get a ResultSet
            ResultSet rs = statement.executeQuery("select * from Printer");
            System.out.println("Used the statement object to execute a query.");
            System.out.println("Received result set back from the query.");

            // Once we have the result set, we can traverse it and access the data stored inside
            System.out.println("Here are all of the records from the Ships table:");
            while (rs.next()) {
                System.out.println("Name = " + rs.getString("model") + " Year Launched: " + rs.getInt("color"));
            }
        } 
        // If there is a syntax error in our SQL, or other problem, this exception will be thrown.
        // Catch it and deal with it (as simply as possible, in this case).
        catch (SQLException e) {
            System.err.println(e.getMessage());
        } 
        // The finally block will execute regardless of whether we come from the "try" or the "catch"
        // This is good, because we want to clean close the database connection no matter what.
        finally {
            // The act of closing the connection could potentially throw another SQL Exception.
            // So, we need to deal with that possibility here, too.
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}