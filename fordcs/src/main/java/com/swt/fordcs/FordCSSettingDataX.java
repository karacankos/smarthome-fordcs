package com.swt.fordcs;

import javax.persistence.Entity;
import javax.persistence.Id;

//
//the new values will be set if the validation method returns true!
//JSON for test: {"deviceId":"CS_FORD_EVSE_RS","connectorType":"SAEJ1772","voltage":220,"frequency":50,"current":30.0,"oTemperature":24.0,"dimensions":"12x12x8","weight":10.0,"cordLength":25.0,"enclosure":"NEMA 4","regulatory":"UL cUL CE CTick"}
//
@Entity
public class FordCSSettingDataX {
	// PRESET
	private String P_deviceId = "CS_FORD_EVSE_RS"; // INVARIANT
	private String P_connectorType = "SAEJ1772"; // INVARIANT
	private Integer P_voltage = 220;		// Charging voltage	integer	208 <= [VAC] =< 240
	private Integer P_frequency = 50;		// Charging frequency	integer	= 50[Hz] OR 60[Hz]
	private float P_current = 30;			// Charging current	Floating point	<= 30 [A]
	private float P_oTemperature = 24;		// Operating Temperature	Floating point	-30 <= [C] =< +70
	private String P_dimensions = "12x12x8";// INVARIANT physical dimension	string	12x12x8 [inchVolume]
	private float P_weight = 10;			// Approximate weight without cable	Floating point	= 10 [lbs]
	private float P_cordLength = 25;		// Approximate cord length	Floating point	<= 25 [inch]
	private String P_enclosure = "NEMA 4";	// INVARIANTCharging plug	string	= â€œNEMA 4â€
	private String P_regulatory = "UL cUL CE CTick";	// Compliance	Certificated international norms	String	â€œUL cUL CE CTickâ€ 
	
	@Id
	private String deviceId ;  		// INVARIANT A unique device ID incorporates  the specification EVSE-RS String[16] = CS_FORD_EVSE_RS
	private String connectorType ;	 // INVARIANT SAEJ1772	String[16]	
	private Integer voltage ;		// Charging voltage	integer	208 <= [VAC] =< 240
	private Integer frequency ;	// Charging frequency	integer	= 50[Hz] OR 60[Hz]
	private float current ;			// Charging current	Floating point	<= 30 [A]
	private float oTemperature ;// Operating Temperature	Floating point	-30 <= [C] =< +70
	private String dimensions ;	// INVARIANT Approximate physical dimension	string	12x12x8 [inchVolume]
	private float weight ;			// Approximate weight without cable	Floating point	= 10 [lbs]
	private float cordLength ;	// Approximate cord length	Floating point	<= 25 [inch]
	private String enclosure ;		// INVARIANT Charging plug	string	= â€œNEMA 4â€
	private String regulatory ;	// Compliance	Certificated international norms	String	â€œUL cUL CE CTickâ€ }

	public FordCSSettingDataX () {
		
	}
	public FordCSSettingDataX (boolean preset) {
		if (preset == true) {
			this.deviceId = P_deviceId;  		// INVARIANT A unique device ID incorporates  the specification EVSE-RS String[16] = CS_FORD_EVSE_RS
			this.connectorType = P_connectorType;	 // INVARIANT SAEJ1772	String[16]	
			this.voltage = P_voltage;		// Charging voltage	integer	208 <= [VAC] =< 240
			this.frequency = P_frequency;	// Charging frequency	integer	= 50[Hz] OR 60[Hz]
			this.current = P_current;			// Charging current	Floating point	<= 30 [A]
			this.oTemperature = P_oTemperature;// Operating Temperature	Floating point	-30 <= [C] =< +70
			this.dimensions = P_dimensions;	// INVARIANT Approximate physical dimension	string	12x12x8 [inchVolume]
			this.weight = P_weight;			// Approximate weight without cable	Floating point	= 10 [lbs]
			this.cordLength = P_cordLength;	// Approximate cord length	Floating point	<= 25 [inch]
			this.enclosure = P_enclosure;		// INVARIANT Charging plug	string	= â€œNEMA 4â€
			this.regulatory = P_regulatory;	// Compliance	Certificated international norms	String	â€œUL cUL CE CTickâ€ }
		}
	}

	// Attributes and getter/setters_
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		// this.deviceId = deviceId;
	}
	public String getConnectorType() {
		return connectorType;
	}
	public void setConnectorType(String connectorType) {
		// this.connectorType = connectorType;
	}
	public Integer getVoltage() {
		return voltage;
	}
	public void setVoltage(Integer voltage) {
		this.voltage = voltage;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public float getCurrent() {
		return current;
	}
	public void setCurrent(float current) {
		this.current = current;
	}
	public float getoTemperature() {
		return oTemperature;
	}
	public void setoTemperature(float oTemperature) {
		this.oTemperature = oTemperature;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getCordLength() {
		return cordLength;
	}
	public void setCordLength(float cordLength) {
		this.cordLength = cordLength;
	}
	public String getEnclosure() {
		return enclosure;
	}
	public void setEnclosure(String enclosure) {
		// this.enclosure = enclosure;
	}
	public String getRegulatory() {
		return regulatory;
	}
	public void setRegulatory(String regulatory) {
		this.regulatory = regulatory;
	}

	// Validation methods
	public boolean validateDeviceId(String deviceId) {
		if ( deviceId.equals(P_deviceId)) return true;
		return false;
	}
	public boolean validateConnectorType(String connectorType) {
		if ( connectorType.equals(P_connectorType)) return true;
		return false;
	}
	public boolean validateVoltage(Integer voltage) {
		if (voltage >= 208 &&  voltage <= 240) return true;
		return false;
	}
	public boolean validateFrequency(Integer frequency) {
		if (frequency == 50 ||  frequency == 60) return true;
		return false;
	}
	public boolean validateCurrent(Integer current) {
		if (current >= 0 &&  current <= 30) return true;
		return false;
	}
	public boolean validateOTemperature(Integer oTemperature) {
		if (oTemperature >= -20 &&  oTemperature <= +70) return true;
		return false;
	}
	public boolean validateDimensions(String dimensions) {
		if (dimensions.equals(P_dimensions)) return true;
		return false;
	}
	public boolean validateCordLength(Integer cordLength) {
		if (cordLength >= 0 &&  cordLength <= 25) return true;
		return false;
	}
	public boolean validateEnclosure(String enclosure) {
		if (enclosure.equals(P_enclosure)) return true;
		return false;
	}
	
	public boolean validateRegulatory(String regulatory) {
		return true;
	}
	
}
