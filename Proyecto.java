import java.util.ArrayList;
import java.util.Date;
/**
 * La clase Proyecto modela los proyectos que gestiona el estudio de
 * arquitectura.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Proyecto
{
    // MARK - Campos
    private final String NUMERO_PROYECTO;
    private String nombre;
    private Date fechaSolicitud;
    private Date fechaEntregaProyecto;
    private int duracionPrevista;
    private double presupuesto;
    private double coste;
    private boolean estaContratado;
    private boolean estaFinalizado;
    private Date fechaInicioObra;
    private Date fechaEntregaObra;
    private Cliente cliente;
    private Arquitecto arquitecto;
    private Aparejador aparejador;
    private Contable contable;
    private String direccion;
    private ArrayList<Certificado> certificados;
    private boolean esComunitario;
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Proyecto
     * 
     * @param nombre Nombre del proyecto
     * @param year Año de solicitud del proyecto
     * @param month Mes de solicitud del proyecto
     * @param day Día de solicitud del proyecto
     * @param direccion Dirección del proyecto
     * @param esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     */
    public Proyecto(String nombre, int year, int month, int day, String direccion,
                    boolean esComunitario)
    {
        NUMERO_PROYECTO = GeneradorNumeros.generaNumeroProyecto();
        certificados = new ArrayList<Certificado>();
        this.nombre = nombre;
        this.direccion = direccion;
        fechaSolicitud = new Date(year, month, day);
        estaContratado = false;
        estaFinalizado = false;
        this.esComunitario = esComunitario;
    }
    
    // MARK - Métodos públicos
    /**
     * Setter de empleados que realizarán el proyecto. Se añade la fecha prevista
     * de entrega y el proyecto se considera contratado
     *
     * @param  arquitecto Arquitecto que realizará el proyecto
     * @param  aparejador Aparejador que desarrollará el proyecto
     * @param  contable Contable que gestionará las finanzas
     * @param  year Año de entrega estimada del proyecto
     * @param  month Mes de entrega estimada del proyecto
     * @param  day Dia de entrega estimada del proyecto
     */
    public void setEmpleadosProyecto(Arquitecto arquitecto, Aparejador aparejador,
                                     Contable contable, int year, int month,
                                     int day)
    {
        this.arquitecto = arquitecto;
        this.aparejador = aparejador;
        this.contable = contable;
        fechaEntregaProyecto = new Date(year, month, day);
        estaContratado = true;
        printConfirmacionEmpleados();
    }
    
    /**
     * Getter del número de proyecto
     */
    public String getId()
    {
        return NUMERO_PROYECTO;
    }
    
    /**
     * Getter del tipo de proyecto
     */
    public boolean getComunitario()
    {
        return esComunitario;
    }
    
    /**
     * Getter de fecha de entrega de obra
     */
    public Date getFechaEntregaObra()
    {
        return fechaEntregaObra;
    }
    
    /**
     * Getter del nombre de proyecto
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Getter de arquitecto
     */
    public Arquitecto getArquitecto()
    {
        return arquitecto;
    }
    
    /**
     * Getter de aparejador
     */
    public Aparejador getAparejador()
    {
        return aparejador;
    }
    
    /**
     * Getter del ArrayList de certificados asociados al proyecto
     */
    public ArrayList<Certificado> getCertificados()
    {
        return certificados;
    }
    
    /**
     * Método de adición de certificado al histórico del proyecto
     */
    public void addCertificado(Certificado certificado) {
        certificados.add(certificado);
    }
    
    /**
     * Setter de cliente asociado al proyecto
     * 
     * @param  cliente Cliente asociado al proyecto
     */
    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }
    
    /**
     * Función de finalización de obra
     * 
     * @param  year Año de finalización de la obra
     * @param  month Mes de finalización de la obra
     * @param  day Día de finalización de la obra
     */
    public void finalizarObra(int year, int month, int day)
    {
        fechaEntregaObra = new Date(year, month, day);
        estaFinalizado = true;
    }
    
    /**
     * Función setter de presupuesto de obra
     * 
     * @param  presupuesto Presupuesto para el desarrollo del proyecto
     */
    public void setPresupuesto(double presupuesto)
    {
        this.presupuesto = presupuesto;
    }
    
    /**
     * Función setter de coste de obra
     * 
     * @param  coste Coste de desarrollo del proyecto
     */
    public void setCoste(double coste)
    {
        this.coste = coste;
    }
    
    /**
     * Función setter de duración prevista de obra
     * 
     * @param  duracionPrevista Duración prevista de obra en días
     */
    public void setDuracionPrevista(int duracionPrevista)
    {
        this.duracionPrevista = duracionPrevista;
    }
    
    /**
     * Función setter de fecha de inicio de obra
     * 
     * @param  year Año de inicio de obra
     * @param  month Mes de inicio de obra
     * @param  day Día de inicio de obra
     */
    public void iniciarObra(int year, int month, int day)
    {
        this.fechaInicioObra = new Date(year, month, day);
    }
    
    // MARK - Métodos privados
    /**
     * Método privado de impresión de mensaje de confirmación de adición de
     * empleados al proyecto y su fecha prevista de entrega
     */
    private void printConfirmacionEmpleados()
    {
        System.out.println("El proyecto número #" + NUMERO_PROYECTO);
        System.out.println("Se ha contratado correctamente los siguientes datos");
        System.out.println("Arquitecto: " + arquitecto.getName());
        System.out.println("Aparejador: " + aparejador.getName());
        System.out.println("Contable: " + contable.getName());
        System.out.println("Fecha estimada de entrega:");
        System.out.println(fechaEntregaProyecto.getDay() + "/" +
                           fechaEntregaProyecto.getMonth() + "/" +
                           fechaEntregaProyecto.getYear());
    }
}
