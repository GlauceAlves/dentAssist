 package com.widesys.DentAssist.domain.model;

import java.util.List;

import com.widesys.DentAssist.domain.model.valueobjects.EnderecoFuncionario;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;  

    private String cpf;  
    private String nome;  
    private String telefoneMensagem;
    private String chavePix;
    private String email;  
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "funcionario_telefones", joinColumns = @JoinColumn(name = "funcionario_id"))
    @Column(name = "telefone_mensagem")
    private List<String> outrosTelefones;  

    @Embedded
    private EnderecoFuncionario endereco;  

    @ManyToOne
    @JoinColumn(name = "idFuncao")
    private FuncaoFuncionario idFuncao;  

    @ManyToMany
    @JoinTable(
        name = "funcionarios_especialidades_odonto",
        joinColumns = @JoinColumn(name = "idFuncionario"),
        inverseJoinColumns = @JoinColumn(name = "idEspecialidade")
    )
//    @JsonIgnore 
    private List<EspecialidadeOdonto> especialidadesOdonto;   
}
