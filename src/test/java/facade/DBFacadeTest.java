package facade;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DBFacadeTest {
    Connection con = null;

    @BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");
        try {
            con = DBconnector.connection();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            con.prepareStatement("DELETE FROM `startcode_test`.`usertable`").executeUpdate();

            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5, "Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    public void testFirstName() throws SQLException {
        System.out.println("testing database connection, to see first name of a user");
        String sql = "SELECT fname FROM startcode_test.usertable";
        try (ResultSet set = con.prepareStatement(sql).executeQuery()) {
            set.next();
            String actual = set.getString("fname");
            assertEquals("Hans", actual);
        }
    }

    @Test
    public void testUserDetails() throws SQLException {
        System.out.println("testing database connection, to see details of a user");
        String sql = "SELECT fname, lname, pw, phone, address FROM startcode_test.usertable";
        try (ResultSet set = con.prepareStatement(sql).executeQuery()) {
            set.next();
            String fname = set.getString("fname");
            String lname = set.getString("lname");
            String pw = set.getString("pw");
            String phone = set.getString("phone");
            String address = set.getString("address");
            assertEquals("Hans", fname);
            assertEquals("Hansen", lname);
            assertEquals("Hemmelig123", pw);
            assertEquals("40404040", phone);
            assertEquals("Rolighedsvej 3", address);
        }
    }

}