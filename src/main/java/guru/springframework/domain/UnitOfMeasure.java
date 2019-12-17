package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    @Id
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
