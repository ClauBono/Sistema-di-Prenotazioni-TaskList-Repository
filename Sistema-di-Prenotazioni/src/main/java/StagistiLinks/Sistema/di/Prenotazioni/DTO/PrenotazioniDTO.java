package StagistiLinks.Sistema.di.Prenotazioni.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class PrenotazioniDTO {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPrenotazione;

    private String tipoServizio;


    private ClienteDTO cliente;

    private StatoPrenotazioneDTO statoPrenotazione;

    public PrenotazioniDTO() {
    }

    public PrenotazioniDTO(Long id, LocalDate dataPrenotazione, String tipoServizio, StatoPrenotazioneDTO statoPrenotazione, ClienteDTO cliente) {
        this.id = id;
        this.dataPrenotazione = dataPrenotazione;
        this.tipoServizio = tipoServizio;
        this.statoPrenotazione = statoPrenotazione;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public String getTipoServizio() {
        return tipoServizio;
    }

    public void setTipoServizio(String tipoServizio) {
        this.tipoServizio = tipoServizio;
    }

    public StatoPrenotazioneDTO getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public void setStatoPrenotazione(StatoPrenotazioneDTO statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        return "PrenotazioniDTO{" +
                "id=" + id +
                ", dataPrenotazione=" + dataPrenotazione +
                ", tipoServizio='" + tipoServizio + '\'' +
                ", statoPrenotazione=" + statoPrenotazione +
                ", cliente=" + cliente +
                '}';
    }
}
