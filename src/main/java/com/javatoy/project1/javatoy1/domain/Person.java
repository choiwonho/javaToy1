package com.javatoy.project1.javatoy1.domain;

import org.apache.commons.lang3.StringUtils;
import com.javatoy.project1.javatoy1.controller.dto.PersonDto;
import com.javatoy.project1.javatoy1.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Where(clause = "deleted = false")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private  String job;

    @ToString.Exclude
    private String phoneNumber;

    @ColumnDefault("0")
    private boolean deleted;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Block block;

    public void set(PersonDto personDto) {
        if (personDto.getAge() != 0) {
            this.setAge(personDto.getAge());
        }

        if (!StringUtils.isEmpty(personDto.getHobby())) {
            this.setHobby(personDto.getHobby());
        }

        if (!StringUtils.isEmpty(personDto.getBloodType())) {
            this.setBloodType(personDto.getBloodType());
        }

        if (!StringUtils.isEmpty(personDto.getAddress())) {
            this.setAddress(personDto.getAddress());
        }

        if (!StringUtils.isEmpty(personDto.getJob())) {
            this.setJob(personDto.getJob());
        }

        if (!StringUtils.isEmpty(personDto.getPhoneNumber())) {
            this.setPhoneNumber(personDto.getPhoneNumber());
        }

    }

}
