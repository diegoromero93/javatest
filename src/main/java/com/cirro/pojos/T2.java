package com.cirro.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.romero
 */
@Getter
@Setter
@JsonIgnoreProperties({"_id","zz"})
public class T2 {
    private Double _id;
    private Double y;
    private Double z;
    private String zz;
    
    @JsonCreator
    public T2( @JsonProperty("y") Double y,@JsonProperty("z") Double z){
        this.y = y;
        this.z = z;
    }
}
