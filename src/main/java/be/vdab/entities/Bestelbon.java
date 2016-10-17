package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.Bestelbonlijn;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String naam;

	@Valid
	@NotNull
	@Embedded
	private Adres adres;

	@ElementCollection // @ManyToMany voor @Embedables ipv @Entity types
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bestelbonid"))
	private Set<Bestelbonlijn> lijnen;

	public Bestelbon() {
	}

	public Bestelbon(String naam, Adres adres, Set<Bestelbonlijn> lijnen) {
		this.naam = naam;
		this.adres = adres;
		this.lijnen = lijnen;
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

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Set<Bestelbonlijn> getLijnen() {
		return lijnen;
	}

	public void setLijnen(Set<Bestelbonlijn> lijnen) {
		this.lijnen = lijnen;
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
		Bestelbon other = (Bestelbon) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
