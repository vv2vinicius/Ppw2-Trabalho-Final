package br.edu.iftm.os.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cliente")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id; //id
    
    @ToString.Include
    @Column(name="nome_fantasia")
    private String nomeFantasia; //nome_fantasia
    
    @Column(name="sobrenome_razao")
    private String sobrenomeRazao;//sobremenome_razao
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_nascimento")
    private Date dataNascimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_cadastro")
    private Date dataCadastro;
    
    @Column(name="cpf_cnpj")
    private String cpfCnpj;
    
    @Column(name="rg_inscricao")
    private String rgInscricao;
    
    private String email;
    
    private String sexo;

}
