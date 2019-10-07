package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Paciente;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirPaciente {
       
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TestePersistirPaciente() {
        
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
            Paciente m = new Paciente();
            m.setAltura(1.80);
            m.setHistorico("Morrendo");
            Calendar data = Calendar.getInstance();
            m.setNascimento(data);
            m.setNome("Paulo Paciente");
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
