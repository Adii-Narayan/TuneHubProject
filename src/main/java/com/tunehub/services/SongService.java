package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.Song;

public interface SongService {
	public String addSongs(Song song);
	
	public boolean songExist(String name);
	
	List<Song> viewSong();
	
	public void updateSong(Song song);
	}
