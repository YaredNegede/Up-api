
package com.sira.dto.employer;

import com.sira.dto.common.DTO;

public class EmployerDto  extends DTO{

	public String name;
    public String phone;
    public String contact;
    public String tradename;
    public String id;
    
	@Override
	public String toString() {
		 
		return "We have found {\"name\":"+name+"}";
		
	}

}
