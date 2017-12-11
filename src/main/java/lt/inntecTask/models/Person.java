package lt.inntecTask.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "inntec_person")
public class Person {

    private long id;
    private String name;
    private String surname;
    private Date date;

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SURNAME", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "DATE", nullable = false, length = 10)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
