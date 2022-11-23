package pl.coderslab.finalproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "advertising")
@Data
public class Advertising {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 5)
    @Column(length = 500)
    private String title;

    @NotEmpty
    @Size(max = 1000)
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Size(max = 255)
    private String image;

    @NotNull
    @Min(value = 1)
    private Integer mileage;

    @NotNull
    @Min(value = 1)
    private Integer price;

    @NotNull
    @Min(value = 1900)
    private Integer year_of_production;

    @NotNull
    private Integer phone_number;

    @NotNull
    @ManyToOne
    private Category category;

    @NotNull
    @ManyToOne
    private Brand brand;

    @ManyToOne
    private User user;

    private LocalDate updatedAt;

    @PrePersist
    @PreUpdate
    public void update() {
        LocalDate date = LocalDate.now();
        this.setUpdatedAt(date);
    }
}