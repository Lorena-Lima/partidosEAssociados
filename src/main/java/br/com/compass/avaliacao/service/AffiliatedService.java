package br.com.compass.avaliacao.service;

import br.com.compass.avaliacao.entities.AffiliatedEntity;
import br.com.compass.avaliacao.entities.dto.AffiliatedDto;
import br.com.compass.avaliacao.entities.dto.PartyDto;
import br.com.compass.avaliacao.repositories.AffiliatedRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffiliatedService {

    @Autowired
    private AffiliatedRespository affiliatedRespository;
    //@Autowired
    //private ModelMapper modelMapper;

    public List<AffiliatedDto> getAffiliatedById(long id) {
        Optional<AffiliatedEntity> affiliated = affiliatedRespository.findById(id);
        return AffiliatedDto.toConvert(affiliated);
    }


    public AffiliatedDto saveAffiliated(AffiliatedDto affiliatedDto) {
        AffiliatedEntity affiliated = affiliatedRespository.save(new AffiliatedEntity(affiliatedDto));
        return new AffiliatedDto(affiliated);
    }

    public void deleteAffiliatedById(Long id) {
        affiliatedRespository.deleteById(id);
    }

    public AffiliatedDto updateAffiliated(Long id, AffiliatedDto affiliatedDto) {
        AffiliatedEntity affiliatedEntity = affiliatedRespository.getOne(id);
        affiliatedEntity.setNome(affiliatedDto.getNome() != null ? affiliatedDto.getNome() : affiliatedEntity.getNome());
        affiliatedEntity.setDataNascimento(affiliatedDto.getDataNascimento() != null ? affiliatedDto.getDataNascimento() : affiliatedEntity.getDataNascimento());
        affiliatedEntity.setCargoPolitico(affiliatedDto.getCargoPolitico() != null ? affiliatedDto.getCargoPolitico() : affiliatedEntity.getCargoPolitico());
        affiliatedEntity.setSexo(affiliatedDto.getSexo() != null ? affiliatedDto.getSexo() : affiliatedEntity.getSexo());

        affiliatedRespository.save(affiliatedEntity);

        return new AffiliatedDto(affiliatedEntity);
    }

    /* Tentativa de realizar o endpoint Post vinculando um associado a um partido:


    public AffiliatedDto addAPartyToAAffiliated(Long id, AffiliatedDto affiliatedDto){
        AffiliatedEntity affiliatedEntity = affiliatedRespository.getById(id);
        affiliatedDto.setIdPartido((List<PartyDto>) affiliatedEntity);
        affiliatedRespository.save(affiliatedEntity);
        return new AffiliatedDto(affiliatedEntity);
    }*/

}