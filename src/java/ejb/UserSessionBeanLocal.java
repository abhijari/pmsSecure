/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abhishek jariwala
 */
@Local
public interface UserSessionBeanLocal {
    public List<State> allStates();
    public List<City> stateCity(int cityId);
    public void registerUser(User u,int groupId);
    public User getSession(String username);
}
