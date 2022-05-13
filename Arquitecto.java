
/**
 * La clase Arquitecto modela los arquitectos del estudio de arquitectura y hereda
 * de la clase Empleado.
 *
 * @author Esteban Calvete Iglesias
 * @version 1.0
 */
public class Arquitecto extends Empleado
{
    // MARK - Campos
    
    // MARK - Constructores
    /**
     * Constructor para objetos de clase Arquitecto
     * 
     * @param  name nombre de la persona
     * @param  telefono Teléfono de contacto
     */
    public Arquitecto(String name, int telefono)
    {
        super(name, telefono, "Arquitecto");
    }

    // MARK - Métodos públicos
    /**
     * Método de entrega de proyecto
     * 
     * @param numProyecto Número del proyecto a entregar
     * @param year Año de entrega del proyecto
     * @param month Mes de entrega del proyecto
     * @param day Día de entrega del proyecto
     */
    public void entregarProyecto(String numProyecto, int year, int month, int day)
    {
        if(getEstudio() != null) {
            Proyecto proyecto = getProyecto(numProyecto);
            if(proyecto != null){
                if(proyecto.getArquitecto() != this){
                    printErrorArquitectoAsignado();
                } else {
                    proyecto.setFechaEntregaProyecto(year, month, day);
                    printConfirmacion();
                }
            } else {
                printErrorProyecto();
            }
        } else {
            printArquitectoNoSistema();
        }
    }
    
    /**
     * Método de emisión de certificados de
     *          - Habitabilidad
     *          - Inspección técnica
     *          - Informe pericial
     * 
     * @param numCertificado Número del certificado a emitir
     * @param year Año de emisión del certificado
     * @param month Mes de emisión del certificado
     * @param day Día de emisión del certificado
     */
    public void emitirCetificadoNoEficiencia(String numCertificado, int year,
                                             int month, int day)
    {
        if(getEstudio() != null) {
            Certificado certificado = getCertificado(numCertificado);
            if(certificado != null){
                if(certificado.getArquitecto() == this){
                    if(certificado.getTipo() != "Eficiencia"){
                        certificado.emitirCertificado(year, month, day);
                        printConfirmacionEmision(certificado);
                    } else {
                        printErrorTipoCertificado();
                    }
                } else {
                    printErrorArquitectoAsignado();
                }
            } else {
                printErrorCertificado();
            }
        } else {
            printArquitectoNoSistema();
        }
    }
    
    /**
     * Método de emisión de certificados de eficiencia energética
     * 
     * @param numCertificado Número del certificado a emitir
     * @param year Año de emisión del certificado
     * @param month Mes de emisión del certificado
     * @param day Día de emisión del certificado
     * @param categoria Categoría del certificado: ('A','B','C','D','E','F' o 'G')
     */
    public void emitirCetificadoEficiencia(String numCertificado, int year,
                                           int month, int day, Character categoria)
    {
        if(getEstudio() != null) {
            Certificado certificado = getCertificado(numCertificado);
            if(certificado != null){
                if(certificado.getArquitecto() == this){
                    if(certificado.getTipo() == "Eficiencia"){
                        certificado.emitirCertificado(year, month, day);
                        certificado.setCategoria(categoria);
                        printConfirmacionEmisionEficiencia(certificado);
                    } else {
                        printErrorTipoCertificado();
                    }
                } else {
                    printErrorArquitectoAsignado();
                }
            } else {
                printErrorCertificado();
            }
        } else {
            printArquitectoNoSistema();
        }
    }
    
    /**
     * Visualización de datos clientes asignados
     */
    public void printClientesAsignados()
    {
        //
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
     * Printer de mensaje de error "Arquitecto no dado de alta en el sistema"
     */
    private void printArquitectoNoSistema()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no está dado de alta en el sistema.");
    }
    
    /**
     * Printer de error de arquitecto no asignado
     */
    private void printErrorArquitectoAsignado()
    {
        System.out.println("No se ha podido realizar la gestión porque");
        System.out.println("usted no es el arquitecto asignado.");
    }
    
    /**
     * Printer de mensaje de confirmación de gestión realizada
     */
    private void printConfirmacion()
    {
        System.out.println("La gestión solicitada se ha realizado con éxito");
    }
    
    /**
     * Printer de mensaje de confirmación de emisión del certificado
     */
    private void printConfirmacionEmision(Certificado certificado)
    {
        System.out.println("El certificado número # " + certificado.getId());
        System.out.println("se ha emitido con éxito");
    }
    
    /**
     * Printer de mensaje de confirmación de gestión realizada
     */
    private void printConfirmacionEmisionEficiencia(Certificado certificado)
    {
        System.out.println("El certificado número # " + certificado.getId());
        System.out.println("y categoría # " + certificado.getCategoria());
        System.out.println("se ha emitido con éxito");
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
    
    /**
     * Printer de error de tipo de certificado
     */
    private void printErrorTipoCertificado()
    {
        System.out.println("No se ha podido realizar la gestión porque el");
        System.out.println("certificado indicado no es del tipo adecuado.");
    }
}
