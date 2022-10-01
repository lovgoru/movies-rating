package com.example.moviesrating.Movie;


import javax.persistence.*;

@Entity
@Table
public class Movie {

    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    private Long id;
    private String name;
    private Integer year;
    private Integer lengthHours;
    private Integer lengthMinutes;
    private Double rating;
    private Integer voteNum = 0; // oznacava broj glasova
    private Integer voteSum = 0; // oznacava sumu svih ocjena

    public Movie() {
    }

    public Movie(Long id, String name, Integer year, Integer lengthHours, Integer lengthMinutes, Double rating, Integer voteNum, Integer voteSum) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.lengthHours = lengthHours;
        this.lengthMinutes = lengthMinutes;
        this.rating = rating;
        this.voteNum = voteNum;
        this.voteSum = voteSum;
    }

    public Movie(String name, Integer year, Integer lengthHours, Integer lengthMinutes, Double rating, Integer voteNum, Integer voteSum) {
        this.name = name;
        this.year = year;
        this.lengthHours = lengthHours;
        this.lengthMinutes = lengthMinutes;
        this.rating = rating;
        this.voteNum = voteNum;
        this.voteSum = voteSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getLengthHours() {
        return lengthHours;
    }

    public void setLengthHours(Integer lengthHours) {
        this.lengthHours = lengthHours;
    }

    public Integer getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(Integer lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
    }

    public Integer getVoteSum() {
        return voteSum;
    }

    public void setVoteSum(Integer voteSum) {
        this.voteSum = voteSum;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", lengthHours=" + lengthHours +
                ", lengthMinutes=" + lengthMinutes +
                ", rating=" + rating +
                ", voteNum=" + voteNum +
                ", voteSum=" + voteSum +
                '}';
    }
}
