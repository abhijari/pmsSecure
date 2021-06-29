package entity;

import entity.Userstechnology;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(Technology.class)
public class Technology_ { 

    public static volatile SingularAttribute<Technology, String> name;
    public static volatile ListAttribute<Technology, Userstechnology> userstechnologyList;
    public static volatile SingularAttribute<Technology, Integer> id;

}