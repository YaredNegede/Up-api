package com.sira.dto.common;

import com.sira.model.stateschema.common.Budget;
import com.sira.model.stateschema.common.UserBase;

public class MessageDto extends DTO{

	public String text;
    public UserBase from;
    public UserBase to;
    public Budget budget;
    public Double budgetAmount;
    public Long hjid;
}
