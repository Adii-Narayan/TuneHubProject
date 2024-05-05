package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Song;
import com.tunehub.repositories.SongRepository;
@Service
public class SongServiceImplementation implements SongService {

	@Autowired
	SongRepository songrepo;
	
	@Override
	public String addSongs(Song song) {
		songrepo.save(song);
		return "song added";
	}

	@Override
	public boolean songExist(String name) {
		Song song=songrepo.findByName(name);
		if(song==null) {
		return false;
		}
		else {
			return true;
		}
	}

	@Override
	public List<Song> viewSong() {
		List<Song>songlist=songrepo.findAll();
		return songlist;
	}

	@Override
	public void updateSong(Song song) {
		songrepo.save(song);
		
	}

	
}
