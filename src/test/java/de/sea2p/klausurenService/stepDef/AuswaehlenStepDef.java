package de.sea2p.klausurenService.stepDef;

import de.sea2p.klausurenService.controller.KlausurenController;
import de.sea2p.klausurenService.dao.KlausurenRepository;
import de.sea2p.klausurenService.dao.MongoService;
import de.sea2p.klausurenService.model.Klausur;
import io.cucumber.java.Before;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import io.swagger.v3.oas.models.links.Link;
import org.assertj.core.api.BDDAssertions;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.mockito.BDDMockito.*;

public class AuswaehlenStepDef {


    KlausurenRepository klausurenRepository = Mockito.mock(KlausurenRepository.class);
    MongoService mongoService = new MongoService();
    KlausurenController klausurenController = new KlausurenController();
    LinkedList<Klausur> klausurenListe = new LinkedList<>();
    HashSet<Integer> semester = new HashSet<>();
    LinkedList<Klausur> currentList = new LinkedList<>();

    @Before
    public void setUp(){
        ReflectionTestUtils.setField(mongoService, "klausurenRepository", klausurenRepository);
        ReflectionTestUtils.setField(klausurenController, "mongoService", mongoService);
    }

    @Angenommen("ein Nutzer ist eingeloggt")
    public void ein_nutzer_ist_eingeloggt() {
       //TODO Einloggen
    }

    @Angenommen("es gibt folgende Daten in der Datenbank")
    public void es_gibt_folgende_daten_in_der_datenbank(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        for(int i = 0; i < dataTable.height(); i++){
            klausurenListe.add(Klausur.builder()
                    .title(dataTable.row(i).get(0))
                    .studiengang(dataTable.row(i).get(1))
                    .prof(dataTable.row(i).get(2))
                    .semester(Integer.parseInt(dataTable.row(i).get(3)))
                    .modul(dataTable.row(i).get(4))
                    .jahr(dataTable.row(i).get(5))
                    .build());
            semester.add(Integer.parseInt(dataTable.row(i).get(3)));

        }
    }

    @Wenn("er sein Semester anzeigen möchte")
    public void er_sein_semester_anzeigen_möchte() {
        // Write code here that turns the phrase above into concrete actions
        given(klausurenRepository.findAll()).willReturn(klausurenListe);
    }

    @Dann("bekommt er die Semester <semester> angezeigt")
    public void bekommt_er_die_semester_semester_angezeigt() {
        BDDAssertions.assertThat(klausurenController.getSemester()).isSameAs(semester);
    }

    @Angenommen("hat den Studiengang Wirtschaftsinformatik gewählt")
    public void hat_den_studiengang_wirtschaftsinformatik_gewählt() {
    }

    @Angenommen("das Semester {int} gewählt")
    public void das_semester_gewählt(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Wenn("der Nutzer die Module anfordert")
    public void der_nutzer_die_module_anfordert() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dann("bekommt er die Module <modules_WI_{int}> angezeigt")
    public void bekommt_er_die_module_modules_wi_angezeigt(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Angenommen("das Modul BWL1 gewählt")
    public void das_modul_bwl1_gewählt() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Wenn("der Nutzer die Klausuren anfordert")
    public void der_nutzer_die_klausuren_anfordert() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dann("bekommt er die Klausuren <year> angezeigt")
    public void bekommt_er_die_klausuren_year_angezeigt() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
