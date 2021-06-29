package entity;

import entity.State;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile ListAttribute<City, User> userList;
    public static volatile SingularAttribute<City, State> stateId;
    public static volatile SingularAttribute<City, String> name;
    public static volatile SingularAttribute<City, Integer> id;

}