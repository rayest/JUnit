package cn.rayest.persistence.jdbc;

import java.io.Serializable;

/**
 * Created by lirui on 2017/3/25.
 */
public class Person implements Serializable{

    private static final long serialVersionUID = -1071759460671492073L;
    private String firstName;
    private String lastName;
    private String id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
