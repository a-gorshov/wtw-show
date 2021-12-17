package com.writetheword.writepieces.service.writing;

import com.writetheword.writepieces.entity.PieceEntity;
import com.writetheword.writepieces.entity.PublishStatus;
import com.writetheword.writepieces.repository.PieceRepository;
import com.writetheword.writepieces.service.writing.assembler.PieceAssembler;
import com.writetheword.writepieces.service.writing.dto.PieceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.StringTokenizer;

/**
 * @author Alexander Gorshov
 */
@Service
@RequiredArgsConstructor
public class PieceServiceImpl implements PieceService {

    private final PieceRepository pieceRepository;
    private final PieceAssembler pieceAssembler;

    @Override
    public void create(PieceDto dto) {
        var newWriting = pieceAssembler.assemble(dto);
        countWords(dto, newWriting);
        newWriting.setPublishStatus(PublishStatus.UN_PUBLISH);
        newWriting.setVersion(0L);
        pieceRepository.save(newWriting);
    }

    @Override
    public PieceDto findById(Long id) {
        var entity = findEntityById(id);
        return pieceAssembler.disassemble(entity);
    }

    @Override
    public PieceDto update(PieceDto dto, Long writingId) {
        var entity = findEntityById(writingId);
        entity.setText(dto.text());
        entity.setMessageToReaders(dto.messageToReaders());
        entity.setVersion(entity.getVersion() + 1);
        pieceRepository.save(entity);
        return pieceAssembler.disassemble(entity);
    }

    @Override
    public void deleteById(Long id) {
        var entity = findEntityById(id);
        pieceRepository.delete(entity);
    }

    private PieceEntity findEntityById(Long id) {
        return pieceRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT_FOUND"));
    }

    private void countWords(final PieceDto dto, PieceEntity entity) {
        int wordCounter = 0;
        if (dto.text() != null && !dto.text().isEmpty()) {
            var tokenizer = new StringTokenizer(dto.text());
            wordCounter = tokenizer.countTokens();
        }
        entity.setWordCounter(wordCounter);
    }
}
