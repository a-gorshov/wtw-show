package com.writetheword.writepieces.service.writing.assembler;

import com.writetheword.writepieces.entity.PieceEntity;
import com.writetheword.writepieces.service.writing.dto.PieceDto;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Gorshov
 */
@Component
public class PieceAssembler {

    public PieceEntity assemble(final PieceDto dto) {
        return new PieceEntity(dto.text(), dto.footnote(), dto.messageToReaders());
    }

    public PieceDto disassemble(final PieceEntity entity) {
        return new PieceDto(entity.getFootnote(), entity.getMessageToReaders(), entity.getText());
    }
}
