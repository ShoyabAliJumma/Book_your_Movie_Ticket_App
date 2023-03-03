package com.example.Book_My_Show.convertors;

import com.example.Book_My_Show.Entities.TicketEntity;
import com.example.Book_My_Show.EntryDtos.TicketEntryDto;

public class TicketConvertor {

    public static TicketEntity convertEntryDtoToEntity(TicketEntryDto ticketEntryDto)
    {
        TicketEntity ticketEntity=new TicketEntity();
        return ticketEntity;
    }
}
