package br.com.compass.avaliacao.service;

import br.com.compass.avaliacao.entities.PartyEntity;
import br.com.compass.avaliacao.entities.dto.PartyDto;
import br.com.compass.avaliacao.repositories.PartyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyService {

    @Autowired
    private PartyRespository partyRespository;

    public List<PartyDto> getPartyById(long id){
        Optional<PartyEntity> affiliated = partyRespository.findById(id);
        return PartyDto.toConvert(affiliated);
    }

    public PartyDto saveParty(PartyDto partyDto){
        PartyEntity party = partyRespository.save(new PartyEntity(partyDto));
        return new PartyDto(party);
    }

    public void deletePartyById(Long id){
        partyRespository.deleteById(id);
    }

    /*public AffiliatedDto updateAffiliated (Long id, AffiliatedDto affiliatedDto){
        AffiliatedEntity affiliatedEntity = affiliatedRespository.getOne(id);
        affiliatedEntity.setName(affiliatedDto.getName() != null ? affiliatedDto.getName():affiliatedEntity.getName());
        affiliatedEntity.setBirthDate(affiliatedDto.getBirthDate() != null ? affiliatedDto.getBirthDate():affiliatedEntity.getBirthDate());
        affiliatedEntity.setPoliticalOffice(affiliatedDto.getPoliticalOffice() != null ? affiliatedDto.getPoliticalOffice():affiliatedEntity.getPoliticalOffice());
        affiliatedEntity.setSexType(affiliatedDto.getSexType() != null ? affiliatedDto.getSexType():affiliatedEntity.getSexType());

        affiliatedRespository.save(affiliatedEntity);

        return new AffiliatedDto(affiliatedEntity);
    }*/

    public PartyDto updateParty (Long id, PartyDto partyDto){
        PartyEntity partyEntity = partyRespository.getOne(id);
        partyEntity.setNome(partyDto.getNome() != null ? partyDto.getNome():partyEntity.getNome());
        partyEntity.setSigla(partyDto.getSigla() != null ? partyDto.getSigla():partyEntity.getSigla());
        partyEntity.setIdeologia(partyDto.getIdeologia() !=null ? partyDto.getIdeologia():partyEntity.getIdeologia());
        partyEntity.setDataFundacao(partyDto.getDataFundacao() !=null ? partyDto.getDataFundacao():partyEntity.getDataFundacao());

        partyRespository.save(partyEntity);

        return new PartyDto(partyEntity);
    }


}
