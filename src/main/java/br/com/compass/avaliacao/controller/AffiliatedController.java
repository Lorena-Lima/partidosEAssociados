package br.com.compass.avaliacao.controller;

import br.com.compass.avaliacao.entities.dto.AffiliatedDto;
import br.com.compass.avaliacao.service.AffiliatedService;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/associados")
public class AffiliatedController {

    @Autowired
    private AffiliatedService affiliatedService;

    @PostMapping
    public ResponseEntity<AffiliatedDto> post(@RequestBody @Valid AffiliatedDto affiliatedDto) {
        AffiliatedDto saveAffiliated = affiliatedService.saveAffiliated(affiliatedDto);
        return ResponseEntity.ok(saveAffiliated);

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AffiliatedDto>> toListAffiliatedById(@PathVariable Long id) {
        List<AffiliatedDto> affiliatedDto = affiliatedService.getAffiliatedById(id);

        return ResponseEntity.ok(affiliatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffiliated(@PathVariable Long id) {
        affiliatedService.deleteAffiliatedById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffiliatedDto> updateAffilliated(@PathVariable Long id, @RequestBody AffiliatedDto affiliatedDto) {
        return ResponseEntity.ok(affiliatedService.updateAffiliated(id, affiliatedDto));
    }

   /* Tentativa de realizar o endpoint Post vinculando um associado a um partido:

   @PostMapping @RequestMapping("/associados/partidos")

    public ResponseEntity<AffiliatedDto> connectToParty(@RequestBody Long id){
        return ResponseEntity.ok(affiliatedService.connect(id));

    }*/

}
