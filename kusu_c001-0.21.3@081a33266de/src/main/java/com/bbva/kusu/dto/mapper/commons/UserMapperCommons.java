package com.bbva.kusu.dto.mapper.commons;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.bbva.kusu.dto.users.beans.ContactDetail;
import com.bbva.kusu.dto.users.beans.ContactEmail;
import com.bbva.kusu.dto.users.beans.ContactLandLine;
import com.bbva.kusu.dto.users.beans.ContactMobile;

public class UserMapperCommons {
	protected static final String EMAIL = "EMAIL";

	protected static final String MOBILE = "MOBILE";

	protected static final String LANDLINE = "LANDLINE";

	protected static final String LIVE = "LIVE";
	
	protected static final String PENDING = "PENDING";
	
	protected Date getInitializedDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String initializedDateStr = "1900-01-01 00:00:00";
		return  formatter.parse(initializedDateStr, new ParsePosition(0));
		
	}

	protected ContactEmail validatedContactEmail(ContactDetail contactDetail, ContactEmail contactEmail) {
		return (contactDetail.getContactEmail() == null) ? contactEmail : contactDetail.getContactEmail();
	}

	protected ContactLandLine validatedContactLandLine(ContactDetail contactDetail, ContactLandLine contactLandLine) {
		return (contactDetail.getContactLandLine() == null) ? contactLandLine : contactDetail.getContactLandLine();
	}

	protected ContactMobile validatedContactMobile(ContactDetail contactDetail, ContactMobile contactMobile) {
		return (contactDetail.getContactMobile() == null) ? contactMobile : contactDetail.getContactMobile();
	}

	protected String validatedEmailVeryfiedType(ContactEmail contactEmail) {
		if (!StringUtils.isBlank(contactEmail.getReceivesNotifications()) && "Y".equals(contactEmail.getReceivesNotifications()))
			return "Y"; 
		return "N";
	}

	protected String validatedPhoneType(ContactMobile contactMobile) {
		if (contactMobile != null){
			if("000000000000000".equals(contactMobile.getNumber())){
				return "NOPHONE";
			}
			return "CONMOPHO"; 
		}
		return LANDLINE;
	}

	protected String validatedPrefixPhoneId(ContactLandLine contactLandLine, ContactMobile contactMobile) {
		String prefixPhoneId = " ";
		if (contactLandLine != null && StringUtils.isNotBlank(contactLandLine.getCountryCode()))
			prefixPhoneId = contactLandLine.getCountryCode(); 
		if (contactMobile != null && StringUtils.isNotBlank(contactMobile.getCountryCode()))
			prefixPhoneId = contactMobile.getCountryCode(); 
		return prefixPhoneId;
	}

	protected String validatedExtensionPhoneId(ContactLandLine contactLandLine) {
		if (contactLandLine == null || StringUtils.isBlank(contactLandLine.getExtension()))
			return " "; 
		return contactLandLine.getExtension();
	}

}
