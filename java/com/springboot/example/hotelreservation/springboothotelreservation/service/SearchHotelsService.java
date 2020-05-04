package com.springboot.example.hotelreservation.springboothotelreservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Hotel;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Room;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Search;
import com.springboot.example.hotelreservation.springboothotelreservation.repository.SearchRepository;

@Service
public class SearchHotelsService implements SearchRepository {
	
	/*public List<Search> fetchSearch(){
		List<Search> searchlist=search.fetchSearch();
		return searchlist;
	}*/

	@Override
	public List<Search> searchhotel(List<Hotel> hotels, List<Room> rooms) {
		 
		List<Search> searchlist=new ArrayList<>();
		for(Hotel h:hotels){
			
			Search search=new Search();
			 search.setCity(h.getCity());
			 search.setHotelname(h.getHotelname());
			 search.setHotelId(h.getHotelid());
			 search.setRating(h.getRating());
			 int count=1;
			 for(Room r:rooms){
				 if(r.getHotelId()==search.getHotelId()){
					 search.setRoomType(r.getRoomType());
					 search.setTotalrooms(count++);
					 //System.out.println(search.getTotalrooms());
				 }
			 }
			searchlist.add(search) ;
		}
		return searchlist;
	}

	
}
