package com.ehealthcare.entities;

import com.ehealthcare.entities.Address;
import com.ehealthcare.entities.Contact;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-04T08:28:37")
@StaticMetamodel(Doctor.class)
public class Doctor_ { 

    public static volatile SingularAttribute<Doctor, String> password;
    public static volatile SingularAttribute<Doctor, String> id_number;
    public static volatile SingularAttribute<Doctor, Address> address;
    public static volatile SingularAttribute<Doctor, String> gender;
    public static volatile SingularAttribute<Doctor, String> surname;
    public static volatile SingularAttribute<Doctor, String> dob;
    public static volatile SingularAttribute<Doctor, Contact> contact;
    public static volatile SingularAttribute<Doctor, String> name;
    public static volatile SingularAttribute<Doctor, String> specialization;
    public static volatile SingularAttribute<Doctor, String> username;
    public static volatile SingularAttribute<Doctor, String> license_number;

}