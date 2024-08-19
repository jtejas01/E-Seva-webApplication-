package com.app.entity;

import javax.persistence.*;

	@Entity
	public class NgoEntity{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String email;
	    private String password;
	    private String name;
	    private String description;
	    private String contactInfo;
	    private String address;
	    private String beneficiary;
	    private String sectionLicence;
	    private Integer registrationNumber;
	    private String role;
	    
	    public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	 public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		//   private Details details;
		public NgoEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		public NgoEntity(Long id, String name, String description, String contactInfo, String address,
				String beneficiary,String sectionLicence,Integer registrationNumber) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.contactInfo = contactInfo;
			this.address = address;
			this.beneficiary = beneficiary;
			this.sectionLicence = sectionLicence;
			this.registrationNumber = registrationNumber;
		}
		public NgoEntity(String name, String description, String contactInfo, String address, String beneficiary,String sectionLicence,Integer registrationNumber) {
			super();
			this.name = name;
			this.description = description;
			this.contactInfo = contactInfo;
			this.address = address;
			this.beneficiary = beneficiary;
			this.sectionLicence = sectionLicence;
			this.registrationNumber = registrationNumber;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getContactInfo() {
			return contactInfo;
		}
		
		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}
		public String getAddress() {
			return address;
		}
		public String getSectionLicence() {
			return sectionLicence;
		}
		public void setSectionLicence(String sectionLicence) {
			this.sectionLicence = sectionLicence;
		}
		public Integer getRegistrationNumber() {
			return registrationNumber;
		}
		public void setRegistrationNumber(Integer registrationNumber) {
			this.registrationNumber = registrationNumber;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getBeneficiary() {
			return beneficiary;
		}
		public void setBeneficiary(String beneficiary) {
			this.beneficiary = beneficiary;
		}
	}

