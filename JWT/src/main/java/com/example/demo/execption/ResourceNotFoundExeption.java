package com.example.demo.execption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResourceNotFoundExeption extends RuntimeException {
	
	String resourceName;
	String fieldname;
	long fieldvalue;
	public ResourceNotFoundExeption(String resourceName, String fieldname, long fieldvalue) {
		super(String.format("% Not found with %s : %s ",resourceName,fieldname,fieldvalue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	

}
