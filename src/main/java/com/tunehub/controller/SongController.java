package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.Song;
import com.tunehub.services.SongService;

@Controller
public class SongController {


	@Autowired
	SongService songserv;

	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song) {
		boolean status=songserv.songExist(song.getName());
		if(status==false) {
			songserv.addSongs(song);
			return "addsongsuccess";
		}
		else {
			return "addsongfail";
		}
	}
	
	@GetMapping("/map-viewsong")
	public String viewSong(Model model) {
		List<Song> slist = songserv.viewSong(); 
		model.addAttribute("songs", slist);
		return "viewSong";
	}
	
	@GetMapping("/customer-viewsong")
	public String CusViewSong(Model model) {
	 boolean primeStatus=false;
	if(primeStatus==true) {
		List<Song> slist = songserv.viewSong(); 
		model.addAttribute("songs", slist);
		return "viewSong";
	}
	else {
		return "makepayment";
	}
	}
}
