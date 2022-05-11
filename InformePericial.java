
/**
 * La clase InformePericial modela los certificados de informes periciales
 * desarrollados por el estudio de arquitectura, hereda de la clase
 * Certificado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class InformePericial extends Certificado
{
    // MARK - Campos
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase InformePericial
     * 
     * @param  year Año de solicitud
     * @param  month Mes de solicitud
     * @param  day Día de solicitud
     * @param  proyecto Proyecto arquitectónico al que se aplica el certificado
     */
    public InformePericial(int year, int month, int day, Proyecto proyecto)
    {
        super(year, month, day, proyecto);
    }
    
    // MARK - Métodos públicos
}
