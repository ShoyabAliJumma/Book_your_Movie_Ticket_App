package com.example.Book_My_Show.Repostories;

import com.example.Book_My_Show.Entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
