package com.writetheword.writepieces.service.writing;

import com.writetheword.writepieces.service.writing.dto.PieceDto;

/**
 * @author Alexander Gorshov
 */
public interface PieceService {

    void create(PieceDto dto);

    PieceDto findById(Long id);

    PieceDto update(PieceDto dto, Long writingId);

    void deleteById(Long id);
}
