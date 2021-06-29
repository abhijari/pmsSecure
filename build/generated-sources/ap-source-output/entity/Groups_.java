package entity;

import entity.Usersgroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, String> name;
    public static volatile ListAttribute<Groups, Usersgroup> usersgroupList;
    public static volatile SingularAttribute<Groups, Integer> id;

}