package br.com.compass.avaliacao.entities;

import br.com.compass.avaliacao.entities.dto.AffiliatedDto;
import br.com.compass.avaliacao.entities.enuntypes.PoliticalOfficeTypeEnun;
import br.com.compass.avaliacao.entities.enuntypes.SexTypeEnun;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity (name = "associados")

public class AffiliatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAssociado;
    @NotBlank
    @Column(name = "nome")
    private String nome;
    @Column(name = "cargo_politico")
    @Enumerated (EnumType.STRING)
    private PoliticalOfficeTypeEnun cargoPolitico;
    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private SexTypeEnun sexo;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    //private long idPartido;

    public AffiliatedEntity(){

    }

    public AffiliatedEntity(long id, String name, PoliticalOfficeTypeEnun politicalOfficeTypeEnun
            , LocalDate birthDate, SexTypeEnun sexTypeEnun /*, long idPartido*/){
        this.idAssociado = id;
        this.nome = name;
        this.cargoPolitico = politicalOfficeTypeEnun;
        this.dataNascimento = birthDate;
        this.sexo = sexTypeEnun;
        //this.idPartido = idPartido;
    }
    public AffiliatedEntity (AffiliatedDto affiliatedDto){
        this.idAssociado = affiliatedDto.getIdAssociado();
        this.nome = affiliatedDto.getNome();
        this.cargoPolitico = affiliatedDto.getCargoPolitico();
        this.sexo = affiliatedDto.getSexo();
        this.dataNascimento = affiliatedDto.getDataNascimento();
        this.sexo = affiliatedDto.getSexo();
        //this.idPartido = affiliatedDto.getIdPartido();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PoliticalOfficeTypeEnun getCargoPolitico() {
        return cargoPolitico;
    }

    public void setCargoPolitico(PoliticalOfficeTypeEnun cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public SexTypeEnun getSexo() {
        return sexo;
    }

    public void setSexo(SexTypeEnun sexo) {
        this.sexo = sexo;
    }
/*
    public long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(long idPartido) {
        this.idPartido = idPartido;
    }*/
}
