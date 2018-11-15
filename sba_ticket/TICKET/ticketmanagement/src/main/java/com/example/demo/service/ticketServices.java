package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ticket;

public interface ticketServices
{
	List<ticket> findAllByRaisedsBy(String raisedBy);

}
