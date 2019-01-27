package com.fullbright.medlab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_profile")
public class TestProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "profile_id")
	private long profileId;
	
	@Column(name = "profile_name")
	private String profileName;

	public TestProfile(long profileId, String profileName) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
	}
	
	public TestProfile() {
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
}
