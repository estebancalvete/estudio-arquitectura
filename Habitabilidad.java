import java.util.Date;
/**
 * La clase Habitabilidad modela los certificados renovables de habitabilidad,
 * hereda de la clase Certificado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Habitabilidad extends Certificado
{
    // MARK - Campos
    private Date fechaVisitaAparejador;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Habitabilidad
     * 
     * @param year Año de solicitud
     * @param month Mes de solicitud
     * @param day Día de solicitud
     * @param residencial Proyecto residencial al que se aplica el certificado
     */
    public Habitabilidad(int year, int month, int day, Residencial residencial)
    {
        super(year, month, day, residencial, "Habitabilidad");
    }
    
    // MARK - Métodos públicos
    /**
     * Setter de fecha de visita del aparejador
     * 
     * @param year Año de visita del aparejador
     * @param month Mes de visita del aparejador
     * @param day Día de visita del aparejador
     */
    public void setFechaVisitaAparejador(int year, int month, int day)
    {
        fechaVisitaAparejador = new Date(year, month, day);
    }
}
