package com.inthergroup.internship.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * An entity Benefits composed by two fields (id, name). The Entity
 * annotation indicates that this class is a JPA entity. The Table annotation
 * specifies the name for the table in the db.
 *
 * @author interns
 */
@Entity
@Table(name = "benefit_types")
public class BenefitType {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An autogenerated id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 20)
    private long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
//    @ManyToMany(mappedBy="benefits")
//    private List<User> users;
    
    // TODO change to many-to-many with extra columns
    @ManyToMany(mappedBy="benefits")
    private List<CareerLevel> careerLevels;
    
    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    public BenefitType() {
    }

    public BenefitType(long id) {
        this.id = id;
    }
    
    public BenefitType(String name) {
        this.name = name;
    }

    public BenefitType(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//    
//    public void addUser(User user) {        
//        users.add(user);
//        
//        if (!user.getBenefits().contains(this)) { // warning this may cause performance issues if you have a large data set since this operation is O(n)
//            user.getBenefits().add(this);
//        }
//    }

    public List<CareerLevel> getCareerLevels() {
        return careerLevels;
    }

    public void setCareerLevels(List<CareerLevel> careerLevels) {
        this.careerLevels = careerLevels;
    }
}