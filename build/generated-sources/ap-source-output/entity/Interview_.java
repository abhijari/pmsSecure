package entity;

import entity.Jobinerviews;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(Interview.class)
public class Interview_ { 

    public static volatile SingularAttribute<Interview, Date> date;
    public static volatile SingularAttribute<Interview, User> companyId;
    public static volatile SingularAttribute<Interview, String> description;
    public static volatile SingularAttribute<Interview, String> location;
    public static volatile ListAttribute<Interview, Jobinerviews> jobinerviewsList;
    public static volatile SingularAttribute<Interview, Integer> id;

}