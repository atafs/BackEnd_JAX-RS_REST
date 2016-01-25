package org.americo.lib.my3Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.americo.lib.my3Messenger.database.DatabaseClass;
import org.americo.lib.my3Messenger.model.Profile;

public class ProfileService {
	//ATTRIBUTES
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	//CONSTRUCTOR
	public ProfileService() {
			profiles.put("AmericoT", new Profile(1L, "AnaM", "Ana", "Batalha"));
	}
	
	/** Service: prints all messages to a list MAP */
	public List<Profile> getAllProfiles() {
		//ARRAYLIST IN MAP
		return new ArrayList<Profile>(profiles.values());
	}
	
	/** @GET message*/
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	/** @ADD message*/
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getFirstName(), profile);
		return profile;
	}
	
	/** @UPDATE message */
	public Profile updateMessage(Profile profile) {
		if (profile.getFirstName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	/** @REMOVE message */
	public Profile removeMessage(String profileName) {
		return profiles.remove(profileName);
	}
}