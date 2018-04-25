
package com.sira.dto.employer;

import com.sira.dto.common.DTO;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Addres;

public class EmployerDto  extends DTO{

    public String name;
    public String phone;
    public String contact;
    public String tradename;
    public Addres addres;
    public Account account;

}
