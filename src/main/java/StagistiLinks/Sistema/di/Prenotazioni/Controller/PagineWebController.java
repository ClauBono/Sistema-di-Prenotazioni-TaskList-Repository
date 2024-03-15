package StagistiLinks.Sistema.di.Prenotazioni.Controller;
import StagistiLinks.Sistema.di.Prenotazioni.Entities.PrenotazioniEntity;
import StagistiLinks.Sistema.di.Prenotazioni.Repositories.PrenotazioniRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PagineWebController {

    private final PrenotazioniRepository prenotazioniRepository;

    public PagineWebController(PrenotazioniRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("titoloPagina", "Portale Prenotazioni");
        model.addAttribute("titoloAlCentro", "Benvenuti da qui è possibile visualizzare le prenotazioni!");

        //Per Footer
        model.addAttribute("annoCorrente", java.time.LocalDate.now().getYear());
        model.addAttribute("simboloFooter", "©");
        model.addAttribute("scrittaFooter", "Prenotazioni");
        //Per Footer

        return "index";
    }

    @GetMapping("/visualizzaTabellaPrenotazioni")
    public String visualizzaTabellaPrenotazioni(Model model) {
        model.addAttribute("titoloPagina", "Tabella Prenotazioni");

        //Per Footer
        model.addAttribute("annoCorrente", java.time.LocalDate.now().getYear());
        model.addAttribute("simboloFooter", "©");
        model.addAttribute("scrittaFooter", "Prenotazioni");
        //Per Footer

        return "TabellaPrenotazioni";
    }

    @GetMapping("/AggiungiPrenotazione")
    public String AggiungiModificaPrenotazione(Model model) {

        model.addAttribute("mode", "INSERIMENTO");
        model.addAttribute("titoloPagina", "Inserisci una nuova Prenotazione");
        model.addAttribute("titoloAggiungiPrenotazione", "Riempi tutti i campi della nuova Prenotazione");

        //Per Footer
        model.addAttribute("annoCorrente", java.time.LocalDate.now().getYear());
        model.addAttribute("simboloFooter", "©");
        model.addAttribute("scrittaFooter", "Prenotazioni");
        //Per Footer

        return "AggiungiModificaPrenotazione";
    }


    @GetMapping("/ModificaPrenotazione/{id}")
    public String PatchRigaTabellaConfigurazione(@PathVariable Long id, Model model) {
        PrenotazioniEntity prenotazioniEntity = prenotazioniRepository.findById(id).orElse(null);

        model.addAttribute("mode", "MODIFICA");
        model.addAttribute("tabellaPrenotazioni", prenotazioniEntity);
        model.addAttribute("titoloPagina", "Modifica Prenotazione selezionata");
        model.addAttribute("titoloModificaPrenotazione", "Riempi i campi per modificare la prenotazione: " + id);

        //Per Footer
        model.addAttribute("annoCorrente", java.time.LocalDate.now().getYear());
        model.addAttribute("simboloFooter", "©");
        model.addAttribute("scrittaFooter", "Prenotazioni");
        //Per Footer

        return "AggiungiModificaPrenotazione";

    }
}
