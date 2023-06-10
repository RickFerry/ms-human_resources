package br.com.humanresources.hrpayroll.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable{
    private static final long serialVersionUID = 547290745125431L;
    
    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal(){
        return this.dailyIncome * this.days;
    }
}
