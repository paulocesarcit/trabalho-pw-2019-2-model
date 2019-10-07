package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Receituario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirConsulta {
       
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TestePersistirConsulta() {
        
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
            Calendar data = Calendar.getInstance();
            Consulta c = new Consulta();
            c.setData(data);
            c.setHora(data);
            c.setPreconsulta("Preconsulta");
            c.setPosconsulta("Posconsulta");
            Medico m = em.find(Medico.class, 9);
            c.setMedico(m);
            Paciente p = em.find(Paciente.class, 10);
            c.setPaciente(p);
            Exame ex = em.find(Exame.class, 1);
            c.setExames(ex);
            Receituario r = em.find(Receituario.class, 1);
            c.setReceituarios(r);
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
