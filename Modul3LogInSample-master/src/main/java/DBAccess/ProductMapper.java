/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Block;
import FunctionLayer.House;
import FunctionLayer.LegoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class ProductMapper {


    public Block getLegoblockbyName(String legoblockName) throws LegoException {
        Block block = null;
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT legoblockName, length FROM legoblock where legoblockName=?";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, legoblockName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                block = new Block(legoblockName, rs.getInt("length"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegoException(ex.getMessage());

        } finally {
            return block;
        }
    }
   
}
