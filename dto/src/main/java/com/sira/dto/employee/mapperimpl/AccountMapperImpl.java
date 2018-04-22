package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.AccountDto;
import com.sira.dto.mappers.AccountMapper;
import com.sira.model.stateschema.model.Account;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntity(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setHjid( accountDto.id );
        account.setType( accountDto.type );
        account.setNumber( accountDto.number );

        return account;
    }

    @Override
    public AccountDto fromEntity(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.id = account.getHjid();
        accountDto.type = account.getType();
        accountDto.number = account.getNumber();
        accountDto.hjid = account.getHjid();

        return accountDto;
    }
}
