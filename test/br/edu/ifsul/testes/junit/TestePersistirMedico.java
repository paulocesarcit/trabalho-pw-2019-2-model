package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Medico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirMedico {
       
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TestePersistirMedico() {
        
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
            Medico m = new Medico();
            m.setCrm("32-222");
            m.setAltura(1.80);
            Especialidade esp = em.find(Especialidade.class, 3);
            m.setEspecialidade(esp);
            m.setHistorico("Saudavel");
            Calendar data = Calendar.getInstance();
            m.setNascimento(data);
            m.setNome("Paulo Medico");
            m.setPeso(65.00);
            m.setSexo("Masculino");
            m.setTelefone("54999999999");
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
