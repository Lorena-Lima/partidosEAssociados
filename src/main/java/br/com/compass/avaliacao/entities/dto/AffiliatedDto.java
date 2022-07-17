package br.com.compass.avaliacao.entities.dto;

import br.com.compass.avaliacao.entities.AffiliatedEntity;
import br.com.compass.avaliacao.entities.enuntypes.PoliticalOfficeTypeEnun;
import br.com.compass.avaliacao.entities.enuntypes.SexTypeEnun;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class AffiliatedDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAssociado;
    @Column(name = "nome")
    private String nome;
    @Enumerated(EnumType.STRING)
    private PoliticalOfficeTypeEnun cargoPolitico;
    private SexTypeEnun sexo;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    //private long idPartido;

   public AffiliatedDto(){

    }

   public AffiliatedDto(long id, String name, PoliticalOfficeTypeEnun politicalOfficeTypeEnun
           , LocalDate birthDate, SexTypeEnun sexTypeEnun /*, long idPartido*/){
       this.idAssociado = id;
       this.nome = name;
       this.cargoPolitico = politicalOfficeTypeEnun;
       this.dataNascimento = birthDate;
       this.sexo = sexTypeEnun;
       //this.idPartido = idPartido;
   }

   public AffiliatedDto (AffiliatedEntity affiliatedEntity){
       this.idAssociado = affiliatedEntity.getIdAssociado();
       this.nome = affiliatedEntity.getNome();
       this.cargoPolitico = affiliatedEntity.getCargoPolitico();
       this.sexo = affiliatedEntity.getSexo();
       this.dataNascimento = affiliatedEntity.getDataNascimento();
       this.sexo = affiliatedEntity.getSexo();
       //this.idPartido = affiliatedEntity.getIdPartido();
   }

    public static List<AffiliatedDto> toConvert(Optional<AffiliatedEntity> affiliatedEntity){
        return affiliatedEntity.stream().map(AffiliatedDto::new).collect(Collectors.toList());
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

    /*public long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(long idPartido) {
        this.idPartido = idPartido;
    }*/
}
