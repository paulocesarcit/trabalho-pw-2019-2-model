package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirPermissaoUsuario {
       
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TestePersistirPermissaoUsuario() {
        
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
            Usuario u = em.find(Usuario.class, "paulocitron");   
            
            Permissao p1 = em.find(Permissao.class,"ADMINISTRADOR");
            
            Permissao p2 = em.find(Permissao.class, "USUARIO");
            
            u.getPermissoes().add(p1);
            u.getPermissoes().add(p2);
            
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
