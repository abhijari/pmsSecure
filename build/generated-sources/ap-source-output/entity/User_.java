package entity;

import entity.City;
import entity.Interview;
import entity.Jobinerviews;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> image;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, String> websiteLink;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile SingularAttribute<User, Boolean> isVerified;
    public static volatile SingularAttribute<User, String> description;
    public static volatile ListAttribute<User, Jobinerviews> jobinerviewsList;
    public static volatile SingularAttribute<User, City> cityId;
    public static volatile SingularAttribute<User, Boolean> isPlaced;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Date> createdDate;
    public static volatile SingularAttribute<User, String> linkedinLink;
    public static volatile ListAttribute<User, Interview> interviewList;
    public static volatile SingularAttribute<User, String> companyname;
    public static volatile SingularAttribute<User, Date> dob;
    public static volatile SingularAttribute<User, String> contact;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> gitLink;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;
    public static volatile ListAttribute<User, Jobinerviews> jobinerviewsList1;

}