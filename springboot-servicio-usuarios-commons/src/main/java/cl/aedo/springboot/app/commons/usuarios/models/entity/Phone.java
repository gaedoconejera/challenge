package cl.aedo.springboot.app.commons.usuarios.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phone implements Serializable {
	
	private static final long serialVersionUID = -3770019876932212871L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 8)
	private Integer number;
	
	@Column(length = 3)
	private Integer citycode;
	
	@Column(length = 3)
	private String countryCode;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getCitycode() {
		return citycode;
	}
	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
