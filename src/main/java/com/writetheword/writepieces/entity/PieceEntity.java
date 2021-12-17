package com.writetheword.writepieces.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Alexander Gorshov
 */
@Entity
@Table(name = "piece")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PieceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;
    @Setter
    @Column(name = "publish_at")
    private LocalDateTime publishAt;
    @Setter
    @Column(name = "text")
    private String text;
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "publish_status")
    private PublishStatus publishStatus;
    @Size(max = 1000)
    @Column(name = "footnote", length = 1000)
    private String footnote;
    @Setter
    @Size(max = 1000)
    @Column(name = "message_to_readers", length = 1000)
    private String messageToReaders;
    @Setter
    @Column(name = "word_counter", nullable = false)
    private Integer wordCounter;
    @Setter
    @Column(name = "version", nullable = false)
    private Long version;

    public PieceEntity(String text, String footnote, String messageToReaders) {
        this.text = text;
        this.footnote = footnote;
        this.messageToReaders = messageToReaders;
        this.createAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceEntity that = (PieceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createAt, that.createAt)
                && Objects.equals(publishAt, that.publishAt) && Objects.equals(text, that.text)
                && publishStatus == that.publishStatus && Objects.equals(footnote, that.footnote)
                && Objects.equals(messageToReaders, that.messageToReaders)
                && Objects.equals(wordCounter, that.wordCounter) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createAt, publishStatus, footnote, messageToReaders, wordCounter, version);
    }
}