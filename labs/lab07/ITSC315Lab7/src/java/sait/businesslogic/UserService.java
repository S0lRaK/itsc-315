/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.businesslogic;

import java.util.List;
import sait.dataaccess.UserRepository;
import sait.domainmodel.User;

public class UserService {
    public User get(String userName) throws Exception {
        UserRepository ur = new UserRepository();
        return ur.getUser(userName);
    }
  
    //This method must either handle, or throw SQLException
    public List<User> getAll() throws Exception {
        UserRepository ur = new UserRepository();
        return ur.getAll();
    }
                                                       
    public int update(String userName, String firstName, String lastName, String email, String password) throws Exception {
        UserRepository ur = new UserRepository();
        User user = ur.getUser(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
    	return ur.update(user);
    }
    
    public int delete(String userName) throws Exception {
        UserRepository ur = new UserRepository();
    	User user = ur.getUser(userName);
    	return ur.delete(user);
    }
    
    public int insert(String userName, String firstName, String lastName, String email, String password) throws Exception {
        UserRepository ur = new UserRepository();
    	User user = new User(userName, firstName, lastName, email, password);
    	return ur.insert(user);
    }
}
