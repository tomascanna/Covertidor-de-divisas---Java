
package proyecto_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class Controlador implements ActionListener {
    
    private Ventana view;

    public Controlador(Ventana view) {
        this.view = view;
        this.view.btnConvertir.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("Conversor de Peso Argentino a divisas");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.btnConvertir) {
            
            try{
                double venta = view.venta;
            
                double valorCotizacion = Double.parseDouble(view.jTextField1.getText());
                double valorCotizacionEsperada = 0;

                valorCotizacionEsperada = valorCotizacion / venta;
                view.jTextField2.setText(Double.toString(valorCotizacionEsperada));
            }catch(NumberFormatException n){
                showMessageDialog(null, "Por favor ingrese un valor para realizar la conversion.");
            }catch(Exception a){
                showMessageDialog(null, "Hubo un error desconocido: "+a.getMessage()+"\n");
            } 
        }

    }

}
