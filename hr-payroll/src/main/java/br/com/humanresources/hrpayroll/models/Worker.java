package br.com.humanresources.hrpayroll.models;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable{
	private static final long serialVersionUID = 4554841320178403659L;
	
	private Long id;
	private String name;
	private Double dailyIncome;
}
