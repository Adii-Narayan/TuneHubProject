package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.Playlist;
import com.tunehub.entities.Song;
import com.tunehub.services.PlaylistService;
import com.tunehub.services.SongService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService pserv;
	@Autowired
	SongService sserv;
	
	@GetMapping("/admin-createplaylist")
	public String createPlaylist(Model model) {
		List<Song> songslist=sserv.viewSong();
		model.addAttribute("songslist",songslist);
		return "createplaylist";	
	}
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist ) {
		
		pserv.createPlaylist(playlist);
		//update song table
		List<Song> songslist=playlist.getSong();
		for(Song song: songslist) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		
		return"playlistcreated";
	}
	
	@GetMapping("/admin-viewplaylist")
	public String viewPlaylist(Model model) {
		List<Playlist>plist=pserv.fetchPlaylist();
		model.addAttribute("playlist",plist);
		return "viewplaylist";
	}
	
	
	

}
