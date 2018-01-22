package org.br;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class MyService {

    @PersistenceContext(unitName = "testPU")
    EntityManager entityManager;

    public String service(){

        entityManager.persist(new Person("asd"));
        return entityManager.find(Person.class, "1").getId();
    }

    public String service(Date from, Date to){

        entityManager.persist(new Person("asd", from, to));
        return entityManager.find(Person.class, "1").getId();
    }
}
