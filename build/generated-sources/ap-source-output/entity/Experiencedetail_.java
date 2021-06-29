package entity;

import entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(Experiencedetail.class)
public class Experiencedetail_ { 

    public static volatile SingularAttribute<Experiencedetail, User> studentId;
    public static volatile SingularAttribute<Experiencedetail, String> jobTitle;
    public static volatile SingularAttribute<Experiencedetail, String> companyName;
    public static volatile SingularAttribute<Experiencedetail, String> description;
    public static volatile SingularAttribute<Experiencedetail, Integer> id;
    public static volatile SingularAttribute<Experiencedetail, Boolean> isCurrentJob;
    public static volatile SingularAttribute<Experiencedetail, Date> joinedDate;
    public static volatile SingularAttribute<Experiencedetail, Date> leavingDate;

}