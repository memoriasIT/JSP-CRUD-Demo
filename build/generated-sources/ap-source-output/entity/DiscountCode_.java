package entity;

import entity.Customer;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-09T23:12:37")
@StaticMetamodel(DiscountCode.class)
public class DiscountCode_ { 

    public static volatile SingularAttribute<DiscountCode, String> discountCode;
    public static volatile SingularAttribute<DiscountCode, BigDecimal> rate;
    public static volatile ListAttribute<DiscountCode, Customer> customerList;

}