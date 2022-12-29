package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
	@Autowired
	private LogRepository logrepository;
	
	@GetMapping("/getAllLog")
	public List<Log> getAllLog(){
		return logrepository.findAll();
	}
	
	@GetMapping("/getLog")
	public List<Log> getLog(@RequestParam String date){
		return logrepository.findByDate(date);
	}


	@GetMapping("/checkout")
	@ResponseBody
	public String checkOut(@RequestParam String name){
		
		//String year = String.format("%4d", Lo)
		//String date = String.format("%02d/%02d/%02d",LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfYear());
		
		
		String hr=String.format("%02d",LocalTime.now().getHour());  
		String min=String.format("%02d",LocalTime.now().getMinute());  
		String time = hr+":"+min;
		String id = name+" "+time;
		String logtype = "OUT";
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = today.format(dateTimeFormatter);
		
		Log cout = new Log(id,name,logtype,formattedDate,time);
		logrepository.save(cout);
		System.out.println("----------All Data saved into Database--------------");
		//return "[ { id:"+id+", date:"+date+" , time:"+time+", logtype:"+logtype+"  }]";
		return "[{status:inserted}]";
	}
	
	
	@GetMapping("/checkin")
	@ResponseBody
	public String checkIn(@RequestParam String name){
		
		//String year = String.format("%4d", Lo)
		//String date = String.format("%02d/%02d/%02d",LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfYear());
		
		
		String hr=String.format("%02d",LocalTime.now().getHour());  
		String min=String.format("%02d",LocalTime.now().getMinute());  
		String time = hr+":"+min;
		String id = name+" "+time;
		String logtype = "IN";
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = today.format(dateTimeFormatter);
		
		Log cout = new Log(id,name,logtype,formattedDate,time);
		logrepository.save(cout);
		System.out.println("----------All Data saved into Database--------------");
		//return "[ { id:"+id+", date:"+date+" , time:"+time+", logtype:"+logtype+"  }]";
		return "[{status:inserted}]";
	}
	
}