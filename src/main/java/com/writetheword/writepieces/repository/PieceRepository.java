package com.writetheword.writepieces.repository;

import com.writetheword.writepieces.entity.PieceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexander Gorshov
 */
@Repository
public interface PieceRepository extends JpaRepository<PieceEntity, Long> {
}
