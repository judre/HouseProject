/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.House;
import FunctionLayer.LegoException;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import FunctionLayer.Wall;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre
 */
public class Calculator extends Command {
@Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        if(width < 4 || length <= 0 || height <= 0){
            return "Calculator";
        }
        ArrayList<Wall> legowalls = LogicFacade.createLegoHouse(length, width, height);
        HttpSession session = request.getSession();
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("height", height);
        
        User user = (User) session.getAttribute("user");

        House house = new House(user.getId(), legowalls);
        session.setAttribute("legohouse", house);

        try {
            LogicFacade.createOrder(house);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoException(ex.getMessage());
        }
        return "Order";
    
        }
}
