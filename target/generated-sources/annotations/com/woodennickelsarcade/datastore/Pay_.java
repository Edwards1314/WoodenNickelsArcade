package com.woodennickelsarcade.datastore;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-06T13:39:13")
@StaticMetamodel(Pay.class)
public class Pay_ { 

    public static volatile SingularAttribute<Pay, Double> amount;
    public static volatile SingularAttribute<Pay, String> name;
    public static volatile SingularAttribute<Pay, Integer> id;
    public static volatile SingularAttribute<Pay, BigInteger> cardnumber;
    public static volatile SingularAttribute<Pay, String> cardtype;

}