package com.ehealthcare.entities;

import com.ehealthcare.entities.Address;
import com.ehealthcare.entities.Contact;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-04T08:28:37")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, String> password;
    public static volatile SingularAttribute<Patient, String> id_number;
    public static volatile SingularAttribute<Patient, Address> address;
    public static volatile SingularAttribute<Patient, String> gender;
    public static volatile SingularAttribute<Patient, String> surname;
    public static volatile SingularAttribute<Patient, String> dob;
    public static volatile SingularAttribute<Patient, Contact> contact;
    public static volatile SingularAttribute<Patient, String> name;
    public static volatile SingularAttribute<Patient, String> username;

}