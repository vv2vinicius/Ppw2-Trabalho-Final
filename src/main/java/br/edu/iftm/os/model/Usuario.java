package br.edu.iftm.os.model;

import br.edu.iftm.os.util.MD5Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuario")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(name = "data_desativacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDesativacao;
 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="usuario_has_permissao",
            joinColumns= {@JoinColumn(name="usuario_id")},
            inverseJoinColumns= {@JoinColumn(name="permissao_id")}
    )
    private List<Permissao> permissoes = new ArrayList<Permissao>();
   

    public String getEmailHash(){
        return MD5Util.md5Hex(this.email);
    }
}
