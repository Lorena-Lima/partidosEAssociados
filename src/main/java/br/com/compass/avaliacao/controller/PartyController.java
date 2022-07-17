package br.com.compass.avaliacao.controller;

import br.com.compass.avaliacao.entities.dto.AffiliatedDto;
import br.com.compass.avaliacao.entities.dto.PartyDto;
import br.com.compass.avaliacao.repositories.PartyRespository;
import br.com.compass.avaliacao.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @PostMapping
    public ResponseEntity<PartyDto> post(@RequestBody @Valid PartyDto partyDto){
        PartyDto savedParty = partyService.saveParty(partyDto);
        return ResponseEntity.ok(savedParty);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<PartyDto>> toListPartyById(@PathVariable Long id){
        List<PartyDto> partyDto = partyService.getPartyById(id);
        return ResponseEntity.ok(partyDto);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteParty (@PathVariable Long id){
        partyService.deletePartyById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<PartyDto> updateParty (@PathVariable Long id, @RequestBody PartyDto partyDto){
        return ResponseEntity.ok(partyService.updateParty(id, partyDto));
    }
    /*@PutMapping("/{id}")
    public ResponseEntity<AffiliatedDto> updateAffilliated (@PathVariable Long id, @RequestBody AffiliatedDto affiliatedDto){
        return ResponseEntity.ok(affiliatedService.updateAffiliated(id, affiliatedDto));
    }*/
}
