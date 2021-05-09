package com.dw.dw.utils;

import com.dw.dw.model.centralizat.*;
import com.dw.dw.model.urban.AdresaUrban;
import com.dw.dw.model.urban.ClasaUrban;
import com.dw.dw.model.urban.InstitutieInvatamantUrban;
import com.dw.dw.model.urban.LocalitateUrban;
import com.dw.dw.service.TipInstitutieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class ObjectConverters {

    //@Autowired
    TipInstitutieService tipInstitutieService;

    public static Function<InstitutieInvatamant, InstitutieInvatamantUrban> centralizatToUrban
            = new Function<InstitutieInvatamant, InstitutieInvatamantUrban>() {

        public InstitutieInvatamantUrban apply(InstitutieInvatamant t) {
            InstitutieInvatamantUrban urban = new InstitutieInvatamantUrban();
            urban.setId(t.getId());
            urban.setNume(t.getNume());

            com.dw.dw.model.urban.TipInstitutie tipInstitutie_u = tipInstitutieCentralizatToUrban.apply(t.getTipInstitutie());
            urban.setTipInstitutie(tipInstitutie_u);

            AdresaUrban adresa_u = adresaCentralizatToUrban.apply(t.getAdresa());
            urban.setAdresa(adresa_u);

            return urban;
        }
    };

    public static Function<TipInstitutie, com.dw.dw.model.urban.TipInstitutie> tipInstitutieCentralizatToUrban
            = new Function<TipInstitutie, com.dw.dw.model.urban.TipInstitutie>() {

        public com.dw.dw.model.urban.TipInstitutie apply(TipInstitutie t) {
            com.dw.dw.model.urban.TipInstitutie urban = new com.dw.dw.model.urban.TipInstitutie();
            urban.setId(t.getId());
            urban.setDenumire(t.getDenumire());

            return urban;
        }
    };

    public static Function<Adresa, AdresaUrban> adresaCentralizatToUrban
            = new Function<Adresa, AdresaUrban>() {

        public AdresaUrban apply(Adresa t) {
            AdresaUrban urban = new AdresaUrban();
            urban.setId(t.getId());
            urban.setCodPostal(t.getCodPostal());
            urban.setNumar(t.getNumar());
            urban.setStrada(t.getStrada());

            LocalitateUrban localitate_u = localitateCentralizatToUrban.apply(t.getLocalitate());
            urban.setLocalitate(localitate_u);

            return urban;
        }
    };

    public static Function<Localitate, LocalitateUrban> localitateCentralizatToUrban
            = new Function<Localitate, LocalitateUrban>() {

        public LocalitateUrban apply(Localitate t) {
            LocalitateUrban urban = new LocalitateUrban();
            urban.setId(t.getId());
            urban.setNume(t.getNume());

            com.dw.dw.model.urban.Judet judet_u = judetCentralizatToUrban.apply(t.getJudet());
            urban.setJudet(judet_u);

            com.dw.dw.model.urban.TipZona tipZona_u = tipZonaCentralizatToUrban.apply(t.getTipZona());
            urban.setTipZona(tipZona_u);

            return urban;
        }
    };

    public static Function<Judet, com.dw.dw.model.urban.Judet> judetCentralizatToUrban
            = new Function<Judet, com.dw.dw.model.urban.Judet>() {

        public com.dw.dw.model.urban.Judet apply(Judet t) {
            com.dw.dw.model.urban.Judet urban = new com.dw.dw.model.urban.Judet();
            urban.setId(t.getId());
            urban.setNume(t.getNume());

            com.dw.dw.model.urban.Subregiune subregiune_u = subregiuneCentralizatToUrban.apply(t.getSubregiune());
            urban.setSubregiune(subregiune_u);

            return urban;
        }
    };

    public static Function<Subregiune, com.dw.dw.model.urban.Subregiune> subregiuneCentralizatToUrban
            = new Function<Subregiune, com.dw.dw.model.urban.Subregiune>() {

        public com.dw.dw.model.urban.Subregiune apply(Subregiune t) {
            com.dw.dw.model.urban.Subregiune urban = new com.dw.dw.model.urban.Subregiune();
            urban.setId(t.getId());
            urban.setNume(t.getNume());

            com.dw.dw.model.urban.Regiune regiune_u = regiuneCentralizatToUrban.apply(t.getRegiune());
            urban.setRegiune(regiune_u);

            return urban;
        }
    };

    public static Function<Regiune, com.dw.dw.model.urban.Regiune> regiuneCentralizatToUrban
            = new Function<Regiune, com.dw.dw.model.urban.Regiune>() {

        public com.dw.dw.model.urban.Regiune apply(Regiune t) {
            com.dw.dw.model.urban.Regiune urban = new com.dw.dw.model.urban.Regiune();
            urban.setId(t.getId());
            urban.setNume(t.getNume());

            return urban;
        }
    };

    public static Function<TipZona, com.dw.dw.model.urban.TipZona> tipZonaCentralizatToUrban
            = new Function<TipZona, com.dw.dw.model.urban.TipZona>() {

        public com.dw.dw.model.urban.TipZona apply(TipZona t) {
            com.dw.dw.model.urban.TipZona urban = new com.dw.dw.model.urban.TipZona();
            urban.setId(t.getId());
            urban.setNume(t.getNume());

            return urban;
        }
    };

    public static Function<Clasa, ClasaUrban> clasaCentralizatToUrban
            = new Function<Clasa, ClasaUrban>() {

        public ClasaUrban apply(Clasa t) {
            ClasaUrban urban = new ClasaUrban();
            urban.setId(t.getId());
            urban.setNume(t.getNume());
            urban.setAn(t.getAn());
            urban.setNivel(t.getNivel());

            InstitutieInvatamantUrban institutie_urban = ObjectConverters.centralizatToUrban.apply(t.getInstitutie());
            urban.setInstitutie(institutie_urban);

            com.dw.dw.model.urban.Specializare specializare_urban = ObjectConverters.specializareCentralizatToUrban.apply(t.getSpecializare());
            urban.setSpecializare(specializare_urban);

            return urban;
        }
    };

    public static Function<Specializare, com.dw.dw.model.urban.Specializare> specializareCentralizatToUrban
            = new Function<Specializare, com.dw.dw.model.urban.Specializare>() {

        public com.dw.dw.model.urban.Specializare apply(Specializare t) {
            com.dw.dw.model.urban.Specializare urban = new com.dw.dw.model.urban.Specializare();
            urban.setId(t.getId());
            urban.setDenumire(t.getDenumire());

            com.dw.dw.model.urban.Profil profil_urban = ObjectConverters.profilCentralizatToUrban.apply(t.getProfil());
            urban.setProfil(profil_urban);

            return urban;
        }
    };

    public static Function<Profil, com.dw.dw.model.urban.Profil> profilCentralizatToUrban
            = new Function<Profil, com.dw.dw.model.urban.Profil>() {

        public com.dw.dw.model.urban.Profil apply(Profil t) {
            com.dw.dw.model.urban.Profil urban = new com.dw.dw.model.urban.Profil();
            urban.setId(t.getId());
            urban.setDenumire(t.getDenumire());

            return urban;
        }
    };
}
