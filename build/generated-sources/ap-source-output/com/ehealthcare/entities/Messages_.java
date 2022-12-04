package com.ehealthcare.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-04T08:28:37")
@StaticMetamodel(Messages.class)
public class Messages_ { 

    public static volatile SingularAttribute<Messages, Date> dateTime;
    public static volatile SingularAttribute<Messages, String> sender;
    public static volatile SingularAttribute<Messages, Long> id;
    public static volatile SingularAttribute<Messages, String> message;
    public static volatile SingularAttribute<Messages, String> title;

}