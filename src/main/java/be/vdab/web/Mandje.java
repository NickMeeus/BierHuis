package be.vdab.web;

import java.math.BigDecimal;
import java.util.Set;

import be.vdab.valueobjects.Bestelbonlijn;

interface Mandje {
	public int getAantalAlInMandje(long bierId);

	public boolean isLeeg();

	public void addBestelbonlijn(long bierId, int aantal);

	public void removeLijn(long wijnId);
	
	public void maakMandjeLeeg();

	public Set<Bestelbonlijn> getbestelbonlijnen();

	public BigDecimal getTotaalprijs();
}
