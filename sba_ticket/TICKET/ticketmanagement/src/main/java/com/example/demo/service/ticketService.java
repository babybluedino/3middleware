package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ticket;
import com.example.demo.repository.ticketRepository;

@Service
public class ticketService implements ticketServices
{
	@Autowired
	ticketRepository tr;

	
	
	
	public List<ticket> getAll()
	{
		return tr.findAll();
	}
	
	
	
	
	public ticket getByid(Long id)
	{
		return tr.findById(id).get();
	}
	
	
	
	
	public ticket add(ticket ti)
	{
		return tr.save(ti);
	}
	
	
	
	
	public ticket update(ticket ti)
	{
		tr.save(ti);
		return ti;
	}
	
	
	
	
	public void delete(Long id)
	{
		tr.deleteById(id);
	}
	
	
	
	
	public List<ticket> findAllByRaisedsBy(String raisedBy)
	{
		return tr.findAllByRaisedBy(raisedBy);
		
	}
}
