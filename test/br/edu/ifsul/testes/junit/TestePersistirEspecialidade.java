package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirEspecialidade {
       
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TestePersistirEspecialidade() {
        
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Trabalho-PW-2019-2-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            Especialidade esp = new Especialidade();
            esp.setDescricao("Cardiologia");
            em.getTransaction().begin();
            em.persist(esp);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
