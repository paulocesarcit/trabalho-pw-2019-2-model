package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirUsuario {
       
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TestePersistirUsuario() {
        
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
            Usuario obj = new Usuario();
            obj.setEmail("paulocesarcitron15@gmail.com");
            obj.setNome("Paulo Cesar Martins Citron");
            obj.setNomeUsuario("paulocitron");
            obj.setSenha("123456");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
