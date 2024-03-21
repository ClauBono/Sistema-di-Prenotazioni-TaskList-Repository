package StagistiLinks.Sistema.di.Prenotazioni.Controller.ControllerWeb;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagineWebController {

    @GetMapping("/home")
    public String home(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("titoloPagina", "Portale Prenotazioni");
        model.addAttribute("titoloAlCentro", "Benvenuto " + username + ", da qui è possibile visualizzare le tue prenotazioni! ");

        //Per Footer
        model.addAttribute("annoCorrente", java.time.LocalDate.now().getYear());
        model.addAttribute("simboloFooter", "©");
        model.addAttribute("scrittaFooter", "Gestione Prenotazioni");
        //Per Footer

        return "index";
    }

    @GetMapping("/visualizzaTabellaPrenotazioni")
    public String visualizzaTabellaPrenotazioni(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("titoloPagina", "Tabella Prenotazioni");
        model.addAttribute("titoloAggiungiPrenotazione", "Ciao " + username + " da qui è possibile aggiungere una Prenotazione");

        //Per Footer
        model.addAttribute("annoCorrente", java.time.LocalDate.now().getYear());
        model.addAttribute("simboloFooter", "©");
        model.addAttribute("scrittaFooter", "Gestione Prenotazioni");
        //Per Footer

        return "TabellaPrenotazioni";
    }

    @GetMapping("/AggiungiPrenotazione")
    public String AggiungiModificaPrenotazione(Model model) {

        model.addAttribute("titoloPagina", "Inserisci una nuova Prenotazione");
        model.addAttribute("titoloAggiungiPrenotazione", "Riempi tutti i campi della nuova Prenotazione");

        //Per Footer
        model.addAttribute("annoCorrente", java.time.LocalDate.now().getYear());
        model.addAttribute("simboloFooter", "©");
        model.addAttribute("scrittaFooter", "Gestione Prenotazioni");
        //Per Footer

        return "AggiungiPrenotazione";
    }

}
