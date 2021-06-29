/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import entity.*;
import java.util.List;
/**
 *
 * @author abhishek jariwala
 */
@Local
public interface CatagorySessionBeanLocal {
    public List<Catagory> allCatagory();
    public void edit(int catId);
    public void delete(int catId);
    public void add(Catagory data);
}


