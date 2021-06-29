package entity;

import entity.Catagory;
import entity.Company;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(Mobile.class)
public class Mobile_ { 

    public static volatile SingularAttribute<Mobile, Company> comapnyid;
    public static volatile SingularAttribute<Mobile, Float> memory;
    public static volatile SingularAttribute<Mobile, Float> size;
    public static volatile SingularAttribute<Mobile, Integer> year;
    public static volatile SingularAttribute<Mobile, String> name;
    public static volatile SingularAttribute<Mobile, Integer> id;
    public static volatile SingularAttribute<Mobile, Catagory> catagoryid;
    public static volatile SingularAttribute<Mobile, Float> camera;

}