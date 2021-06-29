package entity;

import entity.Interview;
import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(Jobinerviews.class)
public class Jobinerviews_ { 

    public static volatile SingularAttribute<Jobinerviews, Date> date;
    public static volatile SingularAttribute<Jobinerviews, User> studentId;
    public static volatile SingularAttribute<Jobinerviews, User> companyId;
    public static volatile SingularAttribute<Jobinerviews, Interview> interviewId;
    public static volatile SingularAttribute<Jobinerviews, String> description;
    public static volatile SingularAttribute<Jobinerviews, String> location;
    public static volatile SingularAttribute<Jobinerviews, Integer> id;
    public static volatile SingularAttribute<Jobinerviews, Integer> status;

}