
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayProducts")
public class DisplayProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        
    throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    try (Connection conn = getConnection()) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM stock");
        out.println("<html><body><h1>Stock List</h1>");
        while (rs.next()) {
            out.println("<p>" + rs.getString("product_name") + ": " + rs.getInt("quantity") + "</p>");
        }
        out.println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h1>Database Error</h1>");
        }
    }

    private Connection getConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/stock_management";
            String username = "root";
            String password = ""; // replace with your database password
            return DriverManager.getConnection(url, username, password);
    }
}