package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static ArrayList<Wall> createLegoHouse(int length, int width, int height) throws LegoException {
CalcHouse calchouse = new CalcHouse();  
    return calchouse.legoCalc(length, width, height);
    }

    public static int createOrder(House house) throws LegoException, SQLException, ClassNotFoundException {
OrderMapper om = new OrderMapper();
return om.addOrder(house);
    }
public static List<Order> userOrders(int User_userId) throws LegoException {
        return UserMapper.userOrders(User_userId);

}
}
