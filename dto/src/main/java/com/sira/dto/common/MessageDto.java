package com.sira.dto.common;

import com.sira.model.stateschema.model.Budget;
import com.sira.model.stateschema.model.UserBase;

public class MessageDto extends DTO{

	public String text;
    public UserBase from;
    public UserBase to;
    public Budget budget;
    public Double budgetAmount;
    public Long hjid;
}
