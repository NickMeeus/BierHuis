package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "bieren")
public class Bier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "soortId")
	private Soort soort;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brouwerId")
	private Brouwer brouwer;

	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 100)
	private String naam;

	@NotNull
	@Min(0)
	@Digits(integer = 5, fraction = 2)
	@NumberFormat(style = Style.NUMBER, pattern = "##0.##")
	private BigDecimal alcohol;

	@NotNull
	@Min(0)
	@Digits(integer = 17, fraction = 2)
	@NumberFormat(pattern = "##,##0.##")
	private BigDecimal prijs;

	public Bier() {
	}

	public Bier(String naam, Brouwer brouwer, Soort soort, BigDecimal alcohol, BigDecimal prijs) {
		this.naam = naam;
		this.brouwer = brouwer;
		this.soort = soort;
		this.alcohol = alcohol;
		this.prijs = prijs;
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Brouwer getBrouwer() {
		return brouwer;
	}

	public void setBrouwer(Brouwer brouwer) {
		this.brouwer = brouwer;
	}

	public Soort getSoort() {
		return soort;
	}

	public void setSoort(Soort soort) {
		this.soort = soort;
	}

	public BigDecimal getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(BigDecimal alcohol) {
		this.alcohol = alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bier other = (Bier) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
