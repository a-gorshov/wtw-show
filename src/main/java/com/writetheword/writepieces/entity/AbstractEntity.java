package com.writetheword.writepieces.entity;

import java.time.LocalDateTime;

/**
 * @author Alexander Gorshov
 */
public abstract class AbstractEntity {

    public abstract Long getId();

    public abstract LocalDateTime createAt();
}
