package entity;

import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-09T23:12:37")
@StaticMetamodel(Manufacturer.class)
public class Manufacturer_ { 

    public static volatile SingularAttribute<Manufacturer, String> zip;
    public static volatile SingularAttribute<Manufacturer, String> city;
    public static volatile SingularAttribute<Manufacturer, String> phone;
    public static volatile SingularAttribute<Manufacturer, Integer> manufacturerId;
    public static volatile SingularAttribute<Manufacturer, String> name;
    public static volatile SingularAttribute<Manufacturer, String> addressline2;
    public static volatile SingularAttribute<Manufacturer, String> addressline1;
    public static volatile SingularAttribute<Manufacturer, String> state;
    public static volatile SingularAttribute<Manufacturer, String> fax;
    public static volatile SingularAttribute<Manufacturer, String> rep;
    public static volatile SingularAttribute<Manufacturer, String> email;
    public static volatile ListAttribute<Manufacturer, Product> productList;

}