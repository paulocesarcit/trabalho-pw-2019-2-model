package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "medico")
public class Medico extends Paciente implements Serializable {
    
    @Column(name = "crm", length = 6, nullable = false)
    @NotBlank(message = "O CRM deve ser informado")
    @Length(max = 6, message = "O CRM não pode ter mais que {max} caracteres")
    private String crm;
    
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_medico_especialidade"))
    @NotNull(message = "A especialidade deve ser informada")
    private Especialidade especialidade;
    
    public Medico(){
    
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
