package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import be.vdab.entities.Bier;

@Embeddable
public class Bestelbonlijn implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "bierid")
	private Bier bier;

	@NotNull
	@Min(0)
	private long aantal;

	public Bestelbonlijn() {
	}

	public Bestelbonlijn(Bier bier, long aantal) {
		this.bier = bier;
		this.aantal = aantal;
	}

	public Bier getBier() {
		return bier;
	}

	public void setBier(Bier bier) {
		this.bier = bier;
	}

	public long getAantal() {
		return aantal;
	}

	public void setAantal(long aantal) {
		this.aantal = aantal;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(bier).append(aantal).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestelbonlijn other = (Bestelbonlijn) obj;
		return new EqualsBuilder().append(bier, other.bier).append(aantal, other.aantal).isEquals();
	}

}
