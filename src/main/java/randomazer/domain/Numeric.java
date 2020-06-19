package randomazer.domain;

import javax.persistence.*;

@Entity
@Table(name = "random_numbers")
public class Numeric {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="numbers_value")
    private Integer value;
    @Column(name="numbers_range")
    private String range;

    public Long getId() {
        return id;
    }

    public   void setId(Long id) {
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
