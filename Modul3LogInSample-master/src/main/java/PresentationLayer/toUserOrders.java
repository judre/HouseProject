/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre
 */
public class toUserOrders extends Command {

   @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int User_userId = user.getId();
        List<FunctionLayer.Order> userOrders = LogicFacade.userOrders(User_userId);
        request.setAttribute("userOrders", userOrders);
        return "UserOrders";
    }
    
}


