
package proyecto_final;

public class Proyecto_Final {

    public static void main(String[] args) {
        
        Ventana view = new Ventana();
        
        Controlador ctrl = new Controlador(view);
        ctrl.iniciar();
        
        
    }
    
}

