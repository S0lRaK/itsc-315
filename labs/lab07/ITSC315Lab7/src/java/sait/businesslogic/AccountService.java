/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.businesslogic;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sait.dataaccess.UserRepository;
import sait.domainmodel.User;

/**
 *
 * @author awarsyle
 */
public class AccountService {
    public boolean login(HttpServletRequest request, String username, String password) throws Exception {
        HttpSession session = request.getSession();
        
        if (username == null || password == null) {
            session.invalidate();
            return false;
        }
        
        UserRepository ur = new UserRepository();
        User user = ur.getUser(username);
        if (user == null) {
            session.invalidate();
            return false;
        }
        
        if (!user.getPassword().equals(password)) {
            session.invalidate();
            return false;
        }
        
        session.setAttribute("currentUser", user);
        Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "user logged in: " + username);
        
        return true;
    }
    
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
