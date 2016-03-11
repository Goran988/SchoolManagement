package org.school.model;

import javax.persistence.Entity;

import org.school.commons.BaseEntity;

@Entity
public class Admin extends BaseEntity {

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", isEnabled()="
				+ isEnabled() + ", getAuthority()=" + getAuthority() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
