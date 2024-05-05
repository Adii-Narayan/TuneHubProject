package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.Playlist;

public interface PlaylistService {
	public String createPlaylist(Playlist plist);
	public List<Playlist> fetchPlaylist();
	

}
