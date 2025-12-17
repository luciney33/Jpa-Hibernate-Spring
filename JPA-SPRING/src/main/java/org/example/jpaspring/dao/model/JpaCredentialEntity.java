package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Credentials")
public class JpaCredentialEntity {
    @Id
    private String username;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "id_reader")
    private JpaReaderEntity readerId;

}
