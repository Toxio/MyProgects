package Week3Day1;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 09.02.13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
public class JdbcEx {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
         Class.forName("oracle.jdbc.driver.OracleDriver") ;   //загружаем драйвер
         //открываем соединение
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            System.out.println(conn);
            if(conn == null) {
                throw new NullPointerException("Connection not found");
            }
            stmt = conn.createStatement();
            if(stmt == null) {
                throw new NullPointerException("Statement not found");
            }
            rs = stmt.executeQuery("SELECT first_name, hire_date, salary " +
                    "FROM employees");
            while(rs.next()) {
                System.out.println(rs.getString(1) + '\t'
                        + rs.getDate(2) + '\t'
                        + rs.getInt(3));
            }


        } catch(Exception e){
           e.printStackTrace();
          }finally {  //закрытие соединения
            if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException e) { }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch(SQLException e) { }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) { }
            }
        }

    }
}
