package com.tuk.moviemaker.movie.entity;

import com.tuk.moviemaker.member.entity.Member;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movie")
@Getter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genre")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "Member_ID")
    private Member member;

    @Column(name = "Release_Date")
    private Date releaseDate;

    @Column(name = "End_Date")
    private Date endDate;

    @Column(name = "Showing")
    private boolean showing;

    @Column(name = "Registration_Date", insertable = false, updatable = false)
    private Timestamp registrationDate;

    public Movie(String title, Genre genre, Member member, Date releaseDate, Date endDate, boolean showing) {
        this.title = title;
        this.genre = genre;
        this.member = member;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.showing = showing;
    }
}
