package org.br;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.br.MyService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class IntegrationTest {

    @Deployment
    public static Archive deploy(){

        return ShrinkWrap.create(WebArchive.class,
                "test.war")
                .addClass(MyService.class)
                .addClass(org.br.Person.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @EJB
    MyService myService;




    @Test
    public void test(){



    }

    @Test
    public void testCustomUsabilityReport(){

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.roll(Calendar.MONTH,-3);
        cal.roll(Calendar.YEAR,-1);
        Date from = cal.getTime();

        cal.roll(Calendar.MONTH,3);
        cal.roll(Calendar.YEAR,1);
        Date to = cal.getTime();

        assertThat(myService.service(from, to), is("1"));
    }

}
