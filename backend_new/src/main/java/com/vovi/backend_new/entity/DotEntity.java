package com.vovi.backend_new.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double x;

    @Column(nullable = false)
    private long y;

    @Column(nullable = false)
    private double r;

    @Column(nullable = false)
    private boolean inside;

    public Boolean getInside() {
        return this.inside;
    }
}
