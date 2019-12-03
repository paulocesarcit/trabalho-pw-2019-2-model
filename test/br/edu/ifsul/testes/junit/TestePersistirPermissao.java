package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirPermissao {
       
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TestePersistirPermissao() {
        
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
            Permissao p1 = new Permissao();
            p1.setNome("ADMINISTRADOR");
            p1.setDescricao("Administradores do sistema");
            Permissao p2 = new Permissao();
            p2.setNome("USUARIO");
            p2.setDescricao("Usuários do sistema");
            Permissao p3 = new Permissao();
            p3.setNome("CLIENTE");
            p3.setDescricao("Clientes do sistema");
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
