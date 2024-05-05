package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Playlist;
import com.tunehub.repositories.PlaylistRepository;
@Service
public class PlaylistServiceImplementation  implements PlaylistService{

	@Autowired
	PlaylistRepository prepo;
	@Override
	public String createPlaylist(Playlist plist) {
		prepo.save(plist);
		return "playlist created";
	}
	@Override
	public List<Playlist> fetchPlaylist() {
		List<Playlist> plist=prepo.findAll();
		return plist;
	}

}
