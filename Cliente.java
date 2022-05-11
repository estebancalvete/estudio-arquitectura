import java.util.ArrayList;
/**
 * La clase Cliente modela los clientes del estudio de arquitectura y hereda
 * de la clase Persona.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Cliente extends Persona
{
    // MARK - Campos
    private final String NUMERO_CLIENTE;
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Certificado> certificados;

    // MARK - Constructores
    /**
     * Constructor for objects of class Cliente
     * 
     * @param name nombre del cliente
     * @param  telefono Teléfono de contacto del cliente
     * 
     */
    public Cliente(String name, int telefono)
    {
        super(name, telefono);
        NUMERO_CLIENTE = GeneradorNumeros.generaNumeroCliente();
        proyectos = new ArrayList<Proyecto>();
        certificados = new ArrayList<Certificado>();
    }
    
    // MARK - Métodos públicos
    /**
     * Getter de número de cliente
     * 
     * @return  Número de cliente
     */
    public String getNumeroCliente()
    {
        return NUMERO_CLIENTE;
    }
    
    /**
     * Función solicitar proyecto residencial
     * 
     * @param  nombre Nombre del proyecto
     * @param  year Año de solicitud del proyecto
     * @param  month Mes de solicitud del proyecto
     * @param  day Día de solicitud del proyecto
     * @param  direccion Dirección de la obra
     * @param  supTerreno Superficie del terreno en m2
     * @param  supEdificio Superficie del edificio en m2
     * @param  noPlantas Número de plantas del edificio
     * @param  noHabitaciones Número de habitaciones
     * @param  noBanos Número de baños
     * @param  esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     */
    public void solicitarProyectoResidencial(String nombre, int year, int month,
                        int day, String direccion, int supTerreno, int supEdificio,
                        int noPlantas, int noHabitaciones, int noBanos,
                        boolean esComunitario)
    {
        if(getActivo() == true){
            Residencial residencial = new Residencial(nombre, year, month, day,
                direccion, supTerreno, supEdificio, noPlantas, noHabitaciones,
                noBanos, esComunitario);
            residencial.setCliente(this);
            proyectos.add(residencial);
            printConfiracionSolicitudProyecto(residencial);
        } else {
            printErrorAlta();
        }
    }
    
    /**
     * Función solicitar proyecto no residencial
     * 
     * @param  nombre Nombre del proyecto
     * @param  year Año de solicitud del proyecto
     * @param  month Mes de solicitud del proyecto
     * @param  day Día de solicitud del proyecto
     * @param  direccion Dirección de la edificación
     * @param  supTerreno Superficie del terreno en m2
     * @param  supEdificio Superficie de la edificación en m2
     * @param  finalidad Finalidad de la edificación
     * @param  esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     */
    public void solicitarProyectoNoResidencial(String nombre, int year, int month,
                    int day, String direccion, int supTerreno, int supEdificio,
                    String finalidad, boolean esComunitario)
    {
        if(getActivo() == true){
            NoResidencial noResidencial = new NoResidencial(nombre, year, month,
               day, direccion, supTerreno, supEdificio, finalidad, esComunitario);
            proyectos.add(noResidencial);
            printConfiracionSolicitudProyecto(noResidencial);
        } else {
            printErrorAlta();
        }
    }
    
    /**
     * Función solicitar proyecto de rehabilitación
     * 
     * @param  nombre Nombre del proyecto
     * @param  year Año de solicitud del proyecto
     * @param  month Mes de solicitud del proyecto
     * @param  day Día de solicitud del proyecto
     * @param  direccion Direccion de realización del proyecto
     * @param  supReformar Superficie a reformar en m2
     * @param  esComunitario Finalidad comunitaria del proyecto: "true" o "false"
     */
    public void solicitarProyectoRehabilitacion(String nombre, int year, int month,
                    int day, String direccion, int supReformar,
                    boolean esComunitario)
    {
        if(getActivo() == true){
            Rehabilitacion rehabilitacion = new Rehabilitacion(nombre, year,
                month, day, direccion, supReformar, esComunitario);
            proyectos.add(rehabilitacion);
            printConfiracionSolicitudProyecto(rehabilitacion);
        } else {
            printErrorAlta();
        }
    }
    
    /**
     * Función solicitar certificado de habitabilidad
     * 
     * @param  year Año de solicitud del certificado
     * @param  month Mes de solicitud del certificado
     * @param  day Día de solicitud del certificado
     * @param  residencial Proyecto residencial asociado al certificado
     */
    public void solicitarCertificadoHabitabilidad(int year, int month,
                        int day, Residencial residencial)
    {
        if(getActivo() == true){
            Habitabilidad habitabilidad = new Habitabilidad(year, month, day,
                residencial);
            habitabilidad.setCliente(this);
            certificados.add(habitabilidad);
            residencial.addCertificado(habitabilidad);
            printConfiracionSolicitudCertificado(habitabilidad);
        } else {
            printErrorAlta();
        }
    }
    
    /**
     * Función solicitar certificado de inspección técnica
     * 
     * @param  year Año de solicitud del certificado
     * @param  month Mes de solicitud del certificado
     * @param  day Día de solicitud del certificado
     * @param  proyecto Proyecto comunitario asociado al certificado
     */
    public void solicitarCertificadoInspeccionTecnica(int year, int month,
                        int day, Proyecto proyecto)
    {
        if(getActivo() == true){
            if(proyecto.getComunitario() == true){
                InspeccionTecnica inspeccionTecnica = new InspeccionTecnica(year,
                    month, day, proyecto);
                inspeccionTecnica.setCliente(this);
                certificados.add(inspeccionTecnica);
                printConfiracionSolicitudCertificado(inspeccionTecnica);
            } else {
                printErrorNoComunitario();
            }
        } else {
            printErrorAlta();
        }
    }
    
    /**
     * Función solicitar certificado de eficiencia energética
     * 
     * @param  year Año de solicitud del certificado
     * @param  month Mes de solicitud del certificado
     * @param  day Día de solicitud del certificado
     * @param  proyecto Proyecto arquitectónico asociado al certificado
     */
    public void solicitarCertificadoEficiencia(int year, int month,
                        int day, Proyecto proyecto)
    {
        if(getActivo() == true){
            Eficiencia eficiencia = new Eficiencia(year,
                    month, day, proyecto);
            eficiencia.setCliente(this);
            certificados.add(eficiencia);
            printConfiracionSolicitudCertificado(eficiencia);
        } else {
            printErrorAlta();
        }
    }
    
    /**
     * Función solicitar informe pericial
     * 
     * @param  year Año de solicitud del certificado
     * @param  month Mes de solicitud del certificado
     * @param  day Día de solicitud del certificado
     * @param  proyecto Proyecto arquitectónico asociado al informe pericial
     */
    public void solicitarInformePericial(int year, int month,
                        int day, Proyecto proyecto)
    {
        if(getActivo() == true){
            InformePericial informePericial = new InformePericial(year,
                    month, day, proyecto);
            informePericial.setCliente(this);
            certificados.add(informePericial);
            printConfiracionSolicitudCertificado(informePericial);
        } else {
            printErrorAlta();
        }
    }
    
    /**
     * Getter del ArrayList de proyectos
     */
    public ArrayList<Proyecto> getProyectos()
    {
        return proyectos;
    }
    
    /**
     * Getter del ArrayList de certificados
     */
    public ArrayList<Certificado> getCertificados()
    {
        return certificados;
    }
    
    // MARK - Métodos privados
    /**
     * Printer de confirmación de solicitud de proyecto
     */
    private void printConfiracionSolicitudProyecto(Proyecto proyecto)
    {
        System.out.println("---------------------------------------------------");
        System.out.println("Se ha procesado correctamente su solicitud con el");
        System.out.println("número de proyecto # " + proyecto.getId());
        System.out.println("Muchas gracias por su confianza");
        System.out.println("---------------------------------------------------");
    }
    
    /**
     * Printer de confirmación de solicitud de certificado
     */
    private void printConfiracionSolicitudCertificado(Certificado certificado)
    {
        System.out.println("---------------------------------------------------");
        System.out.println("Se ha procesado correctamente su solicitud con el");
        System.out.println("número de certificado # " + certificado.getId());
        System.out.println("Muchas gracias por su confianza");
        System.out.println("---------------------------------------------------");
    }
    
    /**
     * Printer de error de cliente no dado de alta en el estudio.
     */
    private void printErrorAlta()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("No se ha podido procesar su solicitud porque");
        System.out.println("usted no está dado de alta en este estudio.");
        System.out.println("Por favor solicite su alta con un administrador.");
        System.out.println("---------------------------------------------------");
    }
    
    /**
     * Printer de error de proyecto no comunitario.
     */
    private void printErrorNoComunitario()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("No se ha podido procesar su solicitud porque");
        System.out.println("este proyecto no es comunitario y por tanto");
        System.out.println("no se le aplica este tipo de certificado.");
        System.out.println("---------------------------------------------------");
    }
}
