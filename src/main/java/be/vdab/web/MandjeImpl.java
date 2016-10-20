package be.vdab.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import be.vdab.services.BierService;
import be.vdab.valueobjects.Bestelbonlijn;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
class MandjeImpl implements Mandje, Serializable {
	private static final long serialVersionUID = 1L;

	private final BierService bierService;

	Map<Long, Integer> mandje;

	@Autowired
	public MandjeImpl(BierService bierService) {
		mandje = new HashMap<>();
		this.bierService = bierService;
	}

	@Override
	public int getAantalAlInMandje(long bierId) {
		return mandje.containsKey(bierId) ? mandje.get(bierId) : 0;
	}

	@Override
	public boolean isLeeg() {
		return mandje.isEmpty();
	}

	@Override
	public void addBestelbonlijn(long bierId, int aantal) {
		mandje.put(bierId, aantal);
	}

	@Override
	public void removeLijn(long bierId) {
		mandje.remove(bierId);
	}

	@Override
	public void maakMandjeLeeg() {
		mandje = new HashMap<>();
	}

	@Override
	public Set<Bestelbonlijn> getbestelbonlijnen() {
		Set<Bestelbonlijn> bestelbonlijnen = new HashSet<>();
		// for lus aangepast naar Lambda
		mandje.keySet().stream().forEach(
				bierId -> bestelbonlijnen.add(new Bestelbonlijn(bierService.read(bierId), mandje.get(bierId))));
		return bestelbonlijnen;
	}

	@Override
	public BigDecimal getTotaalprijs() {
		final BigDecimal totaalprijs = BigDecimal.ZERO;
		// for lus aangepast naar Lambda
		getbestelbonlijnen().stream().forEach(bestelbonlijn -> totaalprijs.add(bestelbonlijn.getBier().getPrijs().multiply(new BigDecimal(bestelbonlijn.getAantal()))));
		
		return totaalprijs;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(mandje).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MandjeImpl other = (MandjeImpl) obj;
		return new EqualsBuilder().append(mandje, other.mandje).isEquals();
	}
}