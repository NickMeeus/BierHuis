package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

@Embeddable
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;

	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String straat;
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String huisNr;
	@NotNull
	@Range(min = 1000, max = 9999)
	private Integer postcode;
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String gemeente;

	public Adres() {
	}

	public Adres(String gemeente, String straat, String huisNr, Integer postcode) {
		this.gemeente = gemeente;
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public String getStraat() {
		return straat;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(gemeente).append(straat).append(huisNr).append(postcode).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adres other = (Adres) obj;
		return new EqualsBuilder().append(gemeente, other.gemeente).append(straat, other.straat)
				.append(huisNr, other.huisNr).append(postcode, other.postcode).isEquals();
	}

}
