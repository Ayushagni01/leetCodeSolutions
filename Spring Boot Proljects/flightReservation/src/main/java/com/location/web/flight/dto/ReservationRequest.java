package com.location.web.flight.dto;

public class ReservationRequest {

	private Long flightId;
	private String passengerFirstName;
	private String passengerlastName;
	private String email;
	private String phone;

	private String nameOnTheCard;
	private String cardNumber;
	private String expirationDate;
	private String SecurityCode;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerlastName() {
		return passengerlastName;
	}

	public void setPassengerlastName(String passengerlastName) {
		this.passengerlastName = passengerlastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return SecurityCode;
	}

	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", passengerFirstName=" + passengerFirstName
				+ ", passengerlastName=" + passengerlastName + ", email=" + email + ", phone=" + phone
				+ ", nameOnTheCard=" + nameOnTheCard + ", cardNumber=" + cardNumber + ", expirationDate="
				+ expirationDate + ", SecurityCode=" + SecurityCode + "]";
	}

}
