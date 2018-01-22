package org.br;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Column
    private String name;
    private String id;

    @JoinTable(name = "business", joinColumns = {
    @JoinColumn(name = "seller", referencedColumnName = "idperson", nullable = false)}, inverseJoinColumns = {
    @JoinColumn(name = "buyer", referencedColumnName = "idperson", nullable = false)})
    @ManyToMany(mappedBy = "friend")
    private Set<Person> friends = new HashSet<>();

    @Column @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column @Temporal(TemporalType.DATE)
    private Date endDate;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name, Date beginDate, Date endDate) {
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }
}
