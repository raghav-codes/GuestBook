package com.example.guestBook;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuestBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    private String guestName;
    private String guestComment;

    public GuestBookEntity(String guestName, String guestComment) {
        this.guestName = guestName;
        this.guestComment = guestComment;
    }
}

