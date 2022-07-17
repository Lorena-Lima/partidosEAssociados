package br.com.compass.avaliacao.entities.dto;

import br.com.compass.avaliacao.entities.PartyEntity;
import br.com.compass.avaliacao.entities.enuntypes.IdeologyTypeEnun;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class PartyDto {

    private long id;
    private String nome;
    private String sigla;
    private IdeologyTypeEnun ideologia;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    public static List<PartyDto> toConvertParty(List<PartyEntity> partyEntity){
        return partyEntity.stream().map(PartyDto::new).collect(Collectors.toList());
    }

    public PartyDto(){

    }

    public PartyDto(Long id, String name, String initials, IdeologyTypeEnun ideologyTypeEnun,  LocalDate foudationDate){
        this.id = id;
        this.nome = name;
        this.sigla = initials;
        this.ideologia = ideologyTypeEnun;
        this.dataFundacao = foudationDate;
    }

    public PartyDto(PartyEntity partyEntity){
        this.id = partyEntity.getId();
        this.nome = partyEntity.getNome();
        this.sigla = partyEntity.getSigla();
        this.ideologia = partyEntity.getIdeologia();
        this.dataFundacao = partyEntity.getDataFundacao();

    }

    public static List<PartyDto> toConvert(Optional<PartyEntity> partyEntity) {
        return partyEntity.stream().map(PartyDto::new).collect(Collectors.toList());
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

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setIdeologia(IdeologyTypeEnun ideologia) {
        this.ideologia = ideologia;
    }
}
