
/**
 * La clase Aparejador modela los aparejadores del estudio de arquitectura y
 * hereda de la clase Empleado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Aparejador extends Empleado
{
    // MARK - Campos

    // MARK - Constructores
    /**
     * Constructor para objetos de clase Aparejador
     * 
     * @param  name nombre de la persona
     * @param  telefono Teléfono de contacto
     */
    public Aparejador(String name, int telefono)
    {
        super(name, telefono, "Aparejador");  
    }
    
    // MARK - Métodos públicos
    /**
     * Método de inicición de obra
     * 
     * @param numProyecto Número del proyecto asociado al inicio de obra
     * @param year Año de inicio de obra
     * @param month Mes de inicio de obra
     * @param day Día de inicio de obra
     * @param duracion Duración prevista de obra
     */
    public void iniciarObra(String numProyecto, int year, int month, int day,
                            int duracion)
    {
        if(getEstudio() != null) {
            Proyecto proyecto = getProyecto(numProyecto);
            if(proyecto != null){
                if(proyecto.getAparejador() != this){
                    printErrorAparejadorAsignado();
                } else {
                    if(proyecto.getFechaEntregaProyecto() != null){
                        if(duracion > 0){
                            proyecto.setFechaInicioObra(year, month, day);
                            proyecto.setDuracionPrevista(duracion);
                            printConfirmacion();
                        } else {
                            printErrorDuracion();
                        }
                    } else {
                        printErrorProyectoNoEntregado();
                    }
                }
            } else {
                printErrorProyecto();
            }
        } else {
            printAparejadorNoSistema();
        }
    }
    
    /**
     * Método de entrega de obra
     * 
     * @param numProyecto Número del proyecto asociado a la obra
     * @param year Año de entrega de obra
     * @param month Mes de entrega de obra
     * @param day Día de entrega de obra
     */
    public void entregarObra(String numProyecto, int year, int month, int day)
    {
        if(getEstudio() != null) {
            Proyecto proyecto = getProyecto(numProyecto);
            if(proyecto != null){
                if(proyecto.getAparejador() == this){
                    if(proyecto.getFechaInicioObra() != null){
                        proyecto.setFechaEntregaObra(year, month, day);
                        proyecto.setEstaFinalizado();
                        printConfirmacion();
                    } else {
                        printErrorNoIniciado();
                    }
                } else {
                    printErrorAparejadorAsignado();
                }
            } else {
                printErrorProyecto();
            }
        } else {
            printAparejadorNoSistema();
        }
    }
    
    /**
     * Método de registro de visita para futura expedición de certificado
     * 
     * @param numCertificado Número del certificado al que se refiere la visita
     * @param year Año de visita
     * @param month Mes de visita
     * @param day Día de visita
     */
    public void registrarVisitaParaCertificado(String numCertificado, int year,
                                               int month, int day)
    {
        if(getEstudio() != null) {
            Certificado certificado = getCertificado(numCertificado);
            if(certificado != null){
                if(certificado.getAparejador() == this){
                    certificado.setFechaVisitaAparejador(year, month, day);
                    printConfirmacion();
                } else {
                    printErrorAparejadorAsignado();
                }
            } else {
                printErrorCertificado();
            }
        } else {
            printAparejadorNoSistema();
        }
    }
    
    // MARK - Métodos privados
    /**
     * Función auxiliar de obtención de proyecto a partir del número de proyecto
     * 
     * @param numero String de número de proyecto, por ejemplo "PRO-16"
     * 
     * @return Proyecto correspondiente al número introducido
     */
    private Proyecto getProyecto(String numero)
    {
        Proyecto proyecto = null;
        for(int i=0; i<getEstudio().getClientes().size(); i++){
            Cliente cliente = getEstudio().getClientes().get(i);
            for(int j=0; j<cliente.getProyectos().size(); j++){
                Proyecto proyectoAComparar = cliente.getProyectos().get(j);
                if(proyectoAComparar.getId() == numero){
                    proyecto = proyectoAComparar;
                }
            }
        }
        return proyecto;
    }
    
    /**
     * Función auxiliar de obtención de certificado a partir del número de
     * certificado
     * 
     * @param numero String de número de certificado, por ejemplo "CER-27"
     * 
     * @return Certificado correspondiente al número introducido
     */
    private Certificado getCertificado(String numero)
    {
        Certificado certificado = null;
        for(int i=0; i<getEstudio().getClientes().size(); i++){
            Cliente cliente = getEstudio().getClientes().get(i);
            for(int j=0; j<cliente.getCertificados().size(); j++){
                Certificado certificadoAComparar = cliente.getCertificados().get(j);
                if(certificadoAComparar.getId() == numero){
                    certificado = certificadoAComparar;
                }
            }
        }
        return certificado;
    }
    
    /**
     * Printer de mensaje de error "Aparejador no dado de alta en el sistema"
     */
    private void printAparejadorNoSistema()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no está dado de alta en el sistema.");
    }
    
    /**
     * Printer de error de aparejador no asignado
     */
    private void printErrorAparejadorAsignado()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no es el aparejador asignado.");
    }
    
    /**
     * Printer de error duracion errónea
     */
    private void printErrorDuracion()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("la duración introducida no es válida.");
    }
    
    /**
     * Printer de mensaje de confirmación de gestión realizada
     */
    private void printConfirmacion()
    {
        System.out.println("La gestión solicitada se ha realizado con éxito");
    }
    
    /**
     * Printer de mensaje error proyecto no entregado
     */
    private void printErrorProyectoNoEntregado()
    {
        System.out.println("La obra no se puede iniciar porque el proyecto aún");
        System.out.println("no ha sido entregado por en arquitecto.");
    }
    
    /**
     * Printer de mensaje error proyecto no entregado
     */
    private void printErrorNoIniciado()
    {
        System.out.println("La obra no se puede entregar porque");
        System.out.println("aún no ha sido iniciada.");
    }
    
    /**
     * Printer de error de proyecto no encontrado
     */
    private void printErrorProyecto()
    {
        System.out.println("No se ha encontrado proyecto con el número indicado");
    }
    
    /**
     * Printer de error de certificado no encontrado
     */
    private void printErrorCertificado()
    {
        System.out.println("No se ha encontrado certificado con el num. indicado");
    }
}
