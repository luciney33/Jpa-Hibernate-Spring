package org.example.jpaspring.dao.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeId implements Serializable {
    private int readerId;
    private JpaNewspaperEntity nPaperId;
}
