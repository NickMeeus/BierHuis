package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 100)
	private String naam;

	@Valid
	@Embedded
	@NotNull
	private Adres adres;

	private Long omzet;

	@OneToMany(mappedBy = "brouwer")
	@OrderBy("naam")
	Set<Bier> bieren;

	public Brouwer() {
	}

	public Brouwer(String naam, Adres adres, long omzet) {
		this.naam = naam;
		this.adres = adres;
		this.omzet = omzet;
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

	public long getOmzet() {
		return omzet;
	}

	public void setOmzet(long omzet) {
		this.omzet = omzet;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Set<Bier> getBieren() {
		return bieren;
	}

	public void setBieren(Set<Bier> bieren) {
		this.bieren = bieren;
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
		Brouwer other = (Brouwer) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
