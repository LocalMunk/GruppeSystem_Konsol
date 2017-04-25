package brugerautorisation.transport.soap;

import brugerautorisation.data.Diverse;
import brugerautorisation.data.BrugerJa;
import brugerautorisation.server.Brugerdatabase;
import javax.jws.WebService;

@WebService(endpointInterface = "brugerautorisation.transport.soap.Brugeradmin")
public class BrugeradminImpl implements Brugeradmin {
	Brugerdatabase db;

	@Override
	public BrugerJa hentBruger(String brugernavn, String adgangskode) {
		return db.hentBruger(brugernavn, adgangskode);
	}

	@Override
	public BrugerJa ændrAdgangskode(String brugernavn, String adgangskode, String nyAdgangskode) {
		BrugerJa b = db.hentBruger(brugernavn, adgangskode);
		b.adgangskode = nyAdgangskode;
		db.gemTilFil(false);
		return b;
	}

	@Override
	public void sendEmail(String brugernavn, String adgangskode, String emne, String tekst) {
		BrugerJa b = db.hentBruger(brugernavn, adgangskode);
		try {
			//SendMail.sendMail("DIST: "+emne, tekst, b.email);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("fejl", ex);
		}
	}

	@Override
	public void sendGlemtAdgangskodeEmail(String brugernavn, String supplerendeTekst) {
		BrugerJa b = db.brugernavnTilBruger.get(brugernavn);
		try {
			//SendMail.sendMail("DIST: Din adgangskode ",
			//		"Kære "+b.fornavn+",\n\nDit brugernavn er "+b.brugernavn+" og din adgangskode er: "+b.adgangskode
			//		+(b.sidstAktiv>0?"":"\n\nDu skal skifte adgangskoden for at bekræfte at du følger kurset.\nSe hvordan på https://goo.gl/26pBG9 \n")
			//		+"\n"+supplerendeTekst,
			//		b.email);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("fejl", ex);
		}
	}

	@Override
	public Object getEkstraFelt(String brugernavn, String adgangskode, String feltnavn) {
		return db.hentBruger(brugernavn, adgangskode).ekstraFelter.get(feltnavn);
	}

	@Override
	public void setEkstraFelt(String brugernavn, String adgangskode, String feltnavn, Object værdi) {
		db.hentBruger(brugernavn, adgangskode).ekstraFelter.put(feltnavn, værdi);
		db.gemTilFil(false);
	}
}
