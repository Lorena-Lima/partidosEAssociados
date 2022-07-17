package br.com.compass.avaliacao.entities;

import br.com.compass.avaliacao.entities.dto.PartyDto;
import br.com.compass.avaliacao.entities.enuntypes.IdeologyTypeEnun;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Entity(name = "Partidos")

public class PartyEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome")
    private String nome;
    @NotBlank
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "ideologia")
    @Enumerated(EnumType.STRING)
    private IdeologyTypeEnun ideologia;
    @Column(name = "data_fundacao")
    private LocalDate dataFundacao;

    public PartyEntity(){

    }
    public PartyEntity(Long id, String name, String initials, IdeologyTypeEnun ideologyTypeEnun, LocalDate foudationDate){
        this.id = id;
        this.nome = name;
        this.sigla = initials;
        this.ideologia = ideologyTypeEnun;
        this.dataFundacao = foudationDate;
    }

    public PartyEntity (PartyDto partyDTO){
        this.id = partyDTO.getId();
        this.nome = partyDTO.getNome();
        this.sigla = partyDTO.getSigla();
        this.ideologia = partyDTO.getIdeologia();
        this.dataFundacao = partyDTO.getDataFundacao();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public IdeologyTypeEnun getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(IdeologyTypeEnun ideologia) {
        this.ideologia = ideologia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

}
