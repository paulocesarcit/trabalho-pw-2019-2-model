package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    private Calendar data;
    
    @Column(name = "hora", nullable = false, columnDefinition = "time")
    @NotNull(message = "A hora deve ser informada")
    private Calendar hora;
    
    @Column(name = "preconsulta", columnDefinition = "text", nullable = false)
    @NotBlank(message = "A preconsulta deve ser informada")
    private String preconsulta;
    
    @Column(name = "posconsulta", columnDefinition = "text", nullable = false)
    @NotBlank(message = "A posconsulta deve ser informada")
    private String posconsulta;
    
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_medico"))
    @NotNull(message = "O medico deve ser informado")
    private Medico medico;
    
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_paciente"))
    @NotNull(message = "O paciente deve ser informado")
    private Paciente paciente;
    
    @OneToMany(mappedBy = "consulta", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Exame> exames = new ArrayList<>();
    
    @OneToMany(mappedBy = "consulta", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Receituario> receituarios = new ArrayList<>();
    
    public Consulta(){
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(Exame exame) {
        this.exames.add(exame);
    }

    public List<Receituario> getReceituarios() {
        return receituarios;
    }

    public void setReceituarios(Receituario receituario) {
        this.receituarios.add(receituario);
    }
    
    public void removerExames(int index) {
        this.exames.remove(index);
    }
    
    public void removerReceituarios(int index) {
        this.receituarios.remove(index);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
