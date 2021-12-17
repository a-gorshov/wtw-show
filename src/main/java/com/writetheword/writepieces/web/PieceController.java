package com.writetheword.writepieces.web;

import com.writetheword.writepieces.service.writing.PieceService;
import com.writetheword.writepieces.service.writing.dto.PieceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Alexander Gorshov
 */
@RestController
@RequestMapping(value = "/pieces")
@RequiredArgsConstructor
public class PieceController {

    private final PieceService pieceService;

    @PostMapping
    public void create(@Valid @RequestBody PieceDto dto) {
        pieceService.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody PieceDto dto, @PathVariable Long id) {
        pieceService.update(dto, id);
    }

    @GetMapping("/{id}")
    public PieceDto getById(@PathVariable Long id) {
        return pieceService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pieceService.deleteById(id);
    }
}
