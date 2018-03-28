/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LegoException;
import java.sql.SQLException;
import java.util.ArrayList;
import FunctionLayer.Block;
import FunctionLayer.House;
import FunctionLayer.Wall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author andre
 */
public class OrderMapper {

    public int addOrder(House legohouse) throws SQLException, ClassNotFoundException, LegoException {
        Connection con = Connector.connection();
        String sql = "insert into orders (User_userId) values (?);";
        try (
                PreparedStatement statement = con.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);) {
            statement.setInt(1, legohouse.getUserId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new LegoException("Creating order failed");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    legohouse.setOrderId(generatedKeys.getInt(1));
                    addOdetails(legohouse);
                } else {
                    throw new LegoException("no ID obtained.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                throw new LegoException(ex.getMessage());
            }
        }
        return legohouse.getOrderId();
    }

    public void addOdetails(House legohouse) throws ClassNotFoundException, SQLException, LegoException {
        Connection con = Connector.connection();
        PreparedStatement order1 = null;
        String SQLString = "insert into odetails (Order_orderId, quantity, legoblockName, User_userId) values (?,?,?,?)";
        try {
            // con.setAutoCommit(false);
            order1 = con.prepareStatement(SQLString);
            order1.setInt(1, legohouse.getOrderId());
            for (int i = 0; i < legohouse.getWalls().size(); i++) {
                order1.setInt(2, legohouse.getWalls().get(i).getBlockAmount());
                order1.setString(3, legohouse.getWalls().get(i).getBlock().getName());
                order1.setInt(4, legohouse.getUserId());
                order1.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new LegoException(ex.getMessage());
        }
    }
}
