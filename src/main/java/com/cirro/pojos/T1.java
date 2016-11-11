package com.cirro.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.romero
 */
@Getter
@Setter
@JsonIgnoreProperties({"_id"})
public class T1 {
    private Double _id;
    private Double x;
    private Double  y;
    private Double z;
    
    @JsonCreator
    public T1( @JsonProperty("x") Double x,@JsonProperty("y") Double y,@JsonProperty("z") Double z){
        this.x = x;
        this.y = y;
        this.z = z;
    
    }
    
}
