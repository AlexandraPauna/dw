package com.dw.dw.utils;

import com.dw.dw.model.centralizat.Curs;
import com.dw.dw.model.centralizat.Judet;
import com.dw.dw.model.centralizat.Profil;
import com.dw.dw.model.centralizat.Regiune;
import com.dw.dw.model.centralizat.Specializare;
import com.dw.dw.model.centralizat.SpecializareDidactica;
import com.dw.dw.model.centralizat.Subregiune;
import com.dw.dw.model.centralizat.TipInstitutie;
import com.dw.dw.model.centralizat.TipZona;
import com.dw.dw.model.centralizat.*;
import com.dw.dw.model.rural.*;
import com.dw.dw.model.rural.AdresaRural;
import com.dw.dw.model.rural.InstitutieInvatamantRural;
import com.dw.dw.model.rural.LocalitateRural;
import com.dw.dw.service.TipInstitutieService;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class ObjectConvertersRural {

    //@Autowired
    TipInstitutieService tipInstitutieService;

    public static Function<InstitutieInvatamant, InstitutieInvatamantRural> centralizatToRural
            = new Function<InstitutieInvatamant, InstitutieInvatamantRural>() {

        public InstitutieInvatamantRural apply(InstitutieInvatamant t) {
            InstitutieInvatamantRural Rural = new InstitutieInvatamantRural();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            com.dw.dw.model.rural.TipInstitutie tipInstitutie_u = tipInstitutieCentralizatToRural.apply(t.getTipInstitutie());
            Rural.setTipInstitutie(tipInstitutie_u);

            AdresaRural adresa_u = adresaCentralizatToRural.apply(t.getAdresa());
            Rural.setAdresa(adresa_u);

            return Rural;
        }
    };

    public static Function<TipInstitutie, com.dw.dw.model.rural.TipInstitutie> tipInstitutieCentralizatToRural
            = new Function<TipInstitutie, com.dw.dw.model.rural.TipInstitutie>() {

        public com.dw.dw.model.rural.TipInstitutie apply(TipInstitutie t) {
            com.dw.dw.model.rural.TipInstitutie Rural = new com.dw.dw.model.rural.TipInstitutie();
            Rural.setId(t.getId());
            Rural.setDenumire(t.getDenumire());

            return Rural;
        }
    };

    public static Function<Adresa, AdresaRural> adresaCentralizatToRural
            = new Function<Adresa, AdresaRural>() {

        public AdresaRural apply(Adresa t) {
            AdresaRural Rural = new AdresaRural();
            Rural.setId(t.getId());
            Rural.setCodPostal(t.getCodPostal());
            Rural.setNumar(t.getNumar());
            Rural.setStrada(t.getStrada());

            LocalitateRural localitate_u = localitateCentralizatToRural.apply(t.getLocalitate());
            Rural.setLocalitate(localitate_u);

            return Rural;
        }
    };

    public static Function<Localitate, LocalitateRural> localitateCentralizatToRural
            = new Function<Localitate, LocalitateRural>() {

        public LocalitateRural apply(Localitate t) {
            LocalitateRural Rural = new LocalitateRural();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            com.dw.dw.model.rural.Judet judet_u = judetCentralizatToRural.apply(t.getJudet());
            Rural.setJudet(judet_u);

            com.dw.dw.model.rural.TipZona tipZona_u = tipZonaCentralizatToRural.apply(t.getTipZona());
            Rural.setTipZona(tipZona_u);

            return Rural;
        }
    };

    public static Function<Judet, com.dw.dw.model.rural.Judet> judetCentralizatToRural
            = new Function<Judet, com.dw.dw.model.rural.Judet>() {

        public com.dw.dw.model.rural.Judet apply(Judet t) {
            com.dw.dw.model.rural.Judet Rural = new com.dw.dw.model.rural.Judet();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            com.dw.dw.model.rural.Subregiune subregiune_u = subregiuneCentralizatToRural.apply(t.getSubregiune());
            Rural.setSubregiune(subregiune_u);

            return Rural;
        }
    };

    public static Function<Subregiune, com.dw.dw.model.rural.Subregiune> subregiuneCentralizatToRural
            = new Function<Subregiune, com.dw.dw.model.rural.Subregiune>() {

        public com.dw.dw.model.rural.Subregiune apply(Subregiune t) {
            com.dw.dw.model.rural.Subregiune Rural = new com.dw.dw.model.rural.Subregiune();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            com.dw.dw.model.rural.Regiune regiune_u = regiuneCentralizatToRural.apply(t.getRegiune());
            Rural.setRegiune(regiune_u);

            return Rural;
        }
    };

    public static Function<Regiune, com.dw.dw.model.rural.Regiune> regiuneCentralizatToRural
            = new Function<Regiune, com.dw.dw.model.rural.Regiune>() {

        public com.dw.dw.model.rural.Regiune apply(Regiune t) {
            com.dw.dw.model.rural.Regiune Rural = new com.dw.dw.model.rural.Regiune();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            return Rural;
        }
    };

    public static Function<TipZona, com.dw.dw.model.rural.TipZona> tipZonaCentralizatToRural
            = new Function<TipZona, com.dw.dw.model.rural.TipZona>() {

        public com.dw.dw.model.rural.TipZona apply(TipZona t) {
            com.dw.dw.model.rural.TipZona Rural = new com.dw.dw.model.rural.TipZona();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            return Rural;
        }
    };

    public static Function<Clasa, ClasaRural> clasaCentralizatToRural
            = new Function<Clasa, ClasaRural>() {

        public ClasaRural apply(Clasa t) {
            ClasaRural Rural = new ClasaRural();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());
            Rural.setAn(t.getAn());
            Rural.setNivel(t.getNivel());

            InstitutieInvatamantRural institutie_Rural = ObjectConvertersRural.centralizatToRural.apply(t.getInstitutie());
            Rural.setInstitutie(institutie_Rural);

            com.dw.dw.model.rural.Specializare specializare_Rural = ObjectConvertersRural.specializareCentralizatToRural.apply(t.getSpecializare());
            Rural.setSpecializare(specializare_Rural);

            return Rural;
        }
    };

    public static Function<Specializare, com.dw.dw.model.rural.Specializare> specializareCentralizatToRural
            = new Function<Specializare, com.dw.dw.model.rural.Specializare>() {

        public com.dw.dw.model.rural.Specializare apply(Specializare t) {
            com.dw.dw.model.rural.Specializare Rural = new com.dw.dw.model.rural.Specializare();
            Rural.setId(t.getId());
            Rural.setDenumire(t.getDenumire());

            com.dw.dw.model.rural.Profil profil_Rural = ObjectConvertersRural.profilCentralizatToRural.apply(t.getProfil());
            Rural.setProfil(profil_Rural);

            return Rural;
        }
    };

    public static Function<Profil, com.dw.dw.model.rural.Profil> profilCentralizatToRural
            = new Function<Profil, com.dw.dw.model.rural.Profil>() {

        public com.dw.dw.model.rural.Profil apply(Profil t) {
            com.dw.dw.model.rural.Profil Rural = new com.dw.dw.model.rural.Profil();
            Rural.setId(t.getId());
            Rural.setDenumire(t.getDenumire());

            return Rural;
        }
    };

    public static Function<Elev, ElevRural> elevCentralizatToRural
            = new Function<Elev, ElevRural>() {

        public ElevRural apply(Elev t) {
            ElevRural Rural = new ElevRural();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());
            Rural.setPrenume(t.getPrenume());
            Rural.setDataNasterii(t.getDataNasterii());
            Rural.setGen(t.getGen());

            ClasaRural clasa_Rural = ObjectConvertersRural.clasaCentralizatToRural.apply(t.getClasa());
            Rural.setClasa(clasa_Rural);

            return Rural;
        }
    };

    public static Function<Nota, NotaRural> notaCentralizatToRural
            = new Function<Nota, NotaRural>() {

        public NotaRural apply(Nota t) {
            NotaRural Rural = new NotaRural();
            Rural.setId(t.getId());
            Rural.setValoare(t.getValoare());
            Rural.setData(t.getData());

            ElevRural elev_Rural = ObjectConvertersRural.elevCentralizatToRural.apply(t.getElev());
            Rural.setElev(elev_Rural);

            com.dw.dw.model.rural.Curs curs_Rural = ObjectConvertersRural.cursCentralizatToRural.apply(t.getCurs());
            Rural.setCurs(curs_Rural);

            return Rural;
        }
    };

    public static Function<Curs, com.dw.dw.model.rural.Curs> cursCentralizatToRural
            = new Function<Curs, com.dw.dw.model.rural.Curs>() {

        public com.dw.dw.model.rural.Curs apply(Curs t) {
            com.dw.dw.model.rural.Curs Rural = new com.dw.dw.model.rural.Curs();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            return Rural;
        }
    };

    public static Function<ClasaCursProfesor, ClasaCursProfesorRural> clasaCursProfesorCentralizatToRural
            = new Function<ClasaCursProfesor, ClasaCursProfesorRural>() {

        public ClasaCursProfesorRural apply(ClasaCursProfesor t) {
            ClasaCursProfesorRural Rural = new ClasaCursProfesorRural();
            Rural.setId(t.getId());

            ClasaRural clasa_Rural = ObjectConvertersRural.clasaCentralizatToRural.apply(t.getClasa());
            Rural.setClasa(clasa_Rural);

            com.dw.dw.model.rural.Curs curs_Rural = ObjectConvertersRural.cursCentralizatToRural.apply(t.getCurs());
            Rural.setCurs(curs_Rural);

            ProfesorRural profesor_Rural = ObjectConvertersRural.profesorCentralizatToRural.apply(t.getProfesor());
            Rural.setProfesor(profesor_Rural);

            return Rural;
        }
    };

    public static Function<Profesor, ProfesorRural> profesorCentralizatToRural
            = new Function<Profesor, ProfesorRural>() {

        public ProfesorRural apply(Profesor t) {
            ProfesorRural Rural = new ProfesorRural();
            Rural.setId(t.getId());
            Rural.setDataNasterii(t.getDataNasterii());
            Rural.setSalariu(t.getSalariu());

            Set<com.dw.dw.model.rural.SpecializareDidactica> specializariD_Rural = new HashSet<com.dw.dw.model.rural.SpecializareDidactica>();
            t.getSpecializari().forEach((sp) ->
            {
                com.dw.dw.model.rural.SpecializareDidactica sp_Rural = ObjectConvertersRural.specializareDidacticaCentralizatToRural.apply(sp);
                specializariD_Rural.add(sp_Rural);
            });
            Rural.setSpecializari(specializariD_Rural);

            return Rural;
        }
    };

    public static Function<SpecializareDidactica, com.dw.dw.model.rural.SpecializareDidactica> specializareDidacticaCentralizatToRural
            = new Function<SpecializareDidactica, com.dw.dw.model.rural.SpecializareDidactica>() {

        public com.dw.dw.model.rural.SpecializareDidactica apply(SpecializareDidactica t) {
            com.dw.dw.model.rural.SpecializareDidactica Rural = new com.dw.dw.model.rural.SpecializareDidactica();
            Rural.setId(t.getId());
            Rural.setNume(t.getNume());

            return Rural;
        }
    };
}
