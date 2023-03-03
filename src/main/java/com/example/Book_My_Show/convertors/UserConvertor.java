package com.example.Book_My_Show.convertors;

import com.example.Book_My_Show.Entities.UserEntity;
import com.example.Book_My_Show.EntryDtos.UserEntryDto;

public class UserConvertor {

    //static is kept to avoid calling it via objects/instances
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto)
    {
        UserEntity userEntity= UserEntity.builder().age(userEntryDto.getAge()).
                address(userEntryDto.getAddress()).email(userEntryDto.getEmail()).
                mobNo(userEntryDto.getMobNo()).name(userEntryDto.getName()).build();

        return userEntity;
    }
}
