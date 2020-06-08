package randomazer.domain;

import javax.persistence.*;

@Entity
@Table(name = "random_numbers")
public class Numeric {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="value")
    private Integer value;
    @Column(name="range")
    private String range;


    public Numeric() {
    }

    public Numeric(int value ,String range) {
        this.value = value;
        this.range = range;
    }


    public Integer getId() {
        return id;
    }

    public   void setId(Integer id) {
        this.id = id;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
