package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ticket;
import com.example.demo.service.ticketService;

@RestController
@CrossOrigin
@RequestMapping("/ticket")
public class ticketController
{
	@Autowired
	ticketService tr;
	
	
	
	
	@GetMapping("/getall")
	public List<ticket> getAll()
	{
		return tr.getAll();
	}
	
	
	
	
	@GetMapping("/get/{id}")
	public ticket getById(@PathVariable("id") Long id)
	{
		return tr.getByid(id);
	}
	
	
	
	
	@PostMapping("/add")
	public ticket add(@RequestBody ticket ti)
	{
		return tr.add(ti);
	}
	
	
	
	
	@PutMapping("/update")
	public ticket update(@RequestBody ticket ti)
	{
		return tr.update(ti);
	}
	
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id)
	{
		tr.delete(id);
	}
	
	
	
	
	@GetMapping("/{field}/{srchValue}")
	public List<ticket> getAllTicket(@PathVariable("field") String filedby,
			@PathVariable("srchValue") String searchValue)
	{
		return tr.findAllByRaisedsBy(searchValue);
	}
}
