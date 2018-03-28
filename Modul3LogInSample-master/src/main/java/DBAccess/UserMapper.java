package DBAccess;

import FunctionLayer.LegoException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
public static List<Order> userOrders(int User_userId) throws LegoException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM odetails WHERE User_userId=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, User_userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                List<Order> userOrders = new ArrayList();
                do {
                    int Order_orderId = rs.getInt(1);
                    int quantity = rs.getInt(2);
                    String legoBlockName = rs.getString(3);

                    Order order = new Order(Order_orderId, quantity, legoBlockName);
                    userOrders.add(order);
                } while (rs.next());
                
                return userOrders;

            }
            else throw new LegoException("try again");
        }
    catch (ClassNotFoundException | SQLException ex) {
        throw new LegoException("try again");
    
}
}

}
