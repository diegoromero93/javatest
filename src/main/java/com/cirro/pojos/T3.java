/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cirro.pojos;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.romero
 */
@Getter
@Setter
public class T3 {

    private Double x;
    private Double t1y;
    private Double t2y;

    public T3(Double x, Double t1y, Double t2y) {
        this.x = x;
        this.t1y = t1y;
        this.t2y = t2y;
    }
    
}
