package entity;

import entity.City;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T02:50:05")
@StaticMetamodel(State.class)
public class State_ { 

    public static volatile SingularAttribute<State, String> name;
    public static volatile SingularAttribute<State, Integer> id;
    public static volatile ListAttribute<State, City> cityList;

}