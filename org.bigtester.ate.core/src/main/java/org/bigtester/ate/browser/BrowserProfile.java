/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.browser;

import org.eclipse.jdt.annotation.Nullable;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.springframework.util.StringUtils;


// TODO: Auto-generated Javadoc
/**
 * This class ProfileSelector defines ....
 *
 * @author Peidong Hu
 * @param <T> the generic type
 */
public class BrowserProfile<T> {
	//TODO add portable profile feature here, refer to web page, http://stackoverflow.com/questions/7328494/selenium2-firefox-use-the-default-profile
	/** The profile name. */
	final private String profileName;
	
	/** The ff profile. */
	@Nullable
	final private T profile;
	
	/** The persistent class. */
	protected Class<T> profileType;
	
	
	
	/**
	 * @return the profileType
	 */
	public Class<T> getProfileType() {
		return profileType;
	}



	/**
	 * @param profileType the profileType to set
	 */
	public void setProfileType(Class<T> profileType) {
		this.profileType = profileType;
	}



	/**
	 * @return the driverType
	 */
	public Class<T> getDriverType() {
		return profileType;
	}



	/**
	 * @param driverType the driverType to set
	 */
	public void setDriverType(Class<T> profileType) {
		this.profileType = profileType;
	}



	/**
	 * Instantiates a new profile creator.
	 *
	 * @param profileName the profile name
	 */
	@SuppressWarnings("unchecked")
	public BrowserProfile(Class<T> profileType, String profileName) {
		if (StringUtils.isEmpty(profileName)) {
			throw new IllegalArgumentException();
		}
		this.profileName = profileName;
		this.profileType = profileType;
		if (this.profileType == FirefoxProfile.class) {
			
			ProfilesIni profileIni = new ProfilesIni();
			T tmpProfile = (T) profileIni.getProfile(profileName); 
			if (null == tmpProfile) {
				throw new IllegalArgumentException();
			} else {
				this.profile = tmpProfile;
			}
		} else {
			//TODO set default profile type to firefox profile type
			ProfilesIni profileIni = new ProfilesIni();

			T tmpProfile = (T) profileIni.getProfile(profileName); 
			if (null == tmpProfile) {
				throw new IllegalArgumentException();
			} else {
				this.profile = tmpProfile;
			}
		}
	}
	
	
	
	/**
	 * Gets the profile name.
	 *
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	
	/**
	 * Gets the profile.
	 *
	 * @return the profile
	 */
	@Nullable
	public T getProfile() {
		return profile;
	}

	

}
