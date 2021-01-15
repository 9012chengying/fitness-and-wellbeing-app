package uk.ac.cf.nsa.web.phyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class PhytApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhytApplication.class, args);
//
//        String dbURL = "jdbc:mysql://localhost:3306/phyt?useSSL=false";
//        String username = "root";
//        String password = "comsc";
//
//        try {
//
//            Connection conn = DriverManager.getConnection(dbURL, username, password);
//            String sql = "UPDATE pt set first_name = 'f',last_name = 'b',email = 'c' WHERE id = 1";
//            Statement statement = conn.createStatement();
//            int rows = statement.executeUpdate(sql);
//            if (rows > 0) {
//                System.out.println("Connected");
//            }
//            conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//    }

}
    }
