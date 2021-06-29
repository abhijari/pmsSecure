package entity;

import entity.Technology;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(Userstechnology.class)
public class Userstechnology_ { 

    public static volatile SingularAttribute<Userstechnology, Integer> id;
    public static volatile SingularAttribute<Userstechnology, Technology> technologyId;
    public static volatile SingularAttribute<Userstechnology, User> userId;

}