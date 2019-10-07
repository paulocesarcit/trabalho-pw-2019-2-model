package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "paciente")
public class Paciente implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome", length = 50, nullable = false)
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
    
    @Column(name = "nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento deve ser informado")
    private Calendar nascimento;
    
    @Column(name = "telefone", length = 14, nullable = false)
    @NotBlank(message = "O telefone deve ser informado")
    @Length(max = 14, message = "O telefone não pode ter mais que {max} caracteres")
    private String telefone;
    
    @Column(name = "sexo", length = 9, nullable = false)
    @NotBlank(message = "O sexo deve ser informado")
    @Length(max = 9, message = "O sexo não pode ter mais que {max} caracteres")
    private String sexo;
    
    @Column(name = "historico", columnDefinition = "text", nullable = false)
    @NotBlank(message = "O historico deve ser informado")
    private String historico;
    
    @Column(name = "peso", nullable = false)
    @NotNull(message = "O peso deve ser informado")
    private Double peso;
    
    @Column(name = "altura", nullable = false)
    @NotNull(message = "A altura deve ser informado")
    private Double altura;
    
    public Paciente(){
    
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
