package com.crunion;

import com.crunion.forex.Conversion;
import com.crunion.forex.Equivalencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * Clase principal y GUI del convertidor de monedas de CRUnion.
 * 
 * @author Mayarling Martinez
 */
public class CRUnion extends JFrame implements ActionListener {
    
    /**
     * Aquí agregamos los atributos que se usaran en esta clase
     */
    private JLabel titulo;
    private JLabel etiquetaOrigen;
    private JLabel etiquetaDestino;
    private JLabel etiquetaMonto;
    private JLabel etiquetaMontoDolares;
    private JLabel etiquetaMontoDestino;
    private JLabel montoDolares;
    private JLabel montodestino;
    private JLabel origenCompra;
    private JLabel destinoCompra;
    private JLabel tipoCambioCompra;
    private JLabel tipoCambioDestino;
    private JComboBox equivalenciasOrigen;
    private JComboBox equivalenciasDestino;
    private JTextField monto;
    private JButton botonConvertir;
    private Conversion convertidor;
    
    
    /**
     * Con este constructor se 
     */
    
    public CRUnion (){
        // Configuramos la ventana
        setTitle("CRUnion");
        setLayout(null);
        convertidor = new Conversion();
        iniciarGUI();
        cargarEquivalencias();
        
    }
    /**
     * Método para iniciar los componentes del GUI.
     */
    private void iniciarGUI(){
        // configuramos la equita del titulo
        titulo = new JLabel("Conversor de monedas");
        titulo.setBounds(100,10,200,30);
        add(titulo);
        
        // Configuramos la equita de la moneda de origen
        etiquetaOrigen = new JLabel("Moneda Origen: ");
        etiquetaOrigen.setBounds(25,50,100,30);
        add(etiquetaOrigen);
        
        //configuramos la equita de moneda destino
        etiquetaDestino = new JLabel("Moneda Destino: ");
        etiquetaDestino.setBounds(25,80,100,30);
        add(etiquetaDestino);
        
        //configuramos la etiqueta del monto
        etiquetaMonto = new JLabel("Monto: ");
        etiquetaMonto.setBounds(25,110,100,30);
        add(etiquetaMonto);
        
        // Configuracion de la etiqueta del monto en dolares.
        etiquetaMontoDolares = new JLabel("Monto en Dólares: ");
        etiquetaMontoDolares.setBounds(25,140,150,30);
        add(etiquetaMontoDolares);
        
        //configuracion de la etiqueta monto destino
        etiquetaMontoDestino = new JLabel("Monto Destino: ");
        etiquetaMontoDestino.setBounds(25,170,100,30);
        add(etiquetaMontoDestino);
        
         //configuracion de la etiqueta que muestra el precio de compra y venta de la moenda de origen.
        origenCompra = new JLabel("Origen Compra: 1.00 | Venta: 1.00");
        origenCompra.setBounds(25,200,250,30);
        add(origenCompra);
        
         //configuracion de la etiqueta que muestra el precio de compra y venta de la moenda de destino.
        destinoCompra = new JLabel("Origen Compra: 1.00 | Venta: 1.00");
        destinoCompra.setBounds(25,230,250,30);
        add(destinoCompra);
        
        //configuracion de la etiqueta con el monto en dolares.
        montoDolares = new JLabel("USD 0");
        montoDolares.setBounds(160,140,150,30);
        add(montoDolares);
        
        // configuracion de la etiqueta con el monto final.
        montodestino = new JLabel("CRC 0");
        montodestino.setBounds(160,170,150,30);
        add(montodestino);
     
        // Configuracion del combo de equivalencia de origen.
        equivalenciasOrigen = new JComboBox();
        equivalenciasOrigen.setBounds(160,50,175,20);
        add(equivalenciasOrigen);
        
        // Configuracion del combo de equivalencia de destino
        equivalenciasDestino = new JComboBox();
        equivalenciasDestino.setBounds(160,80,175,20);
        add(equivalenciasDestino);
        
        // Configuracion del textfield para la etiqueta del monto
        monto = new JTextField();
        monto.setBounds(160,110,100,20);
        add(monto);
        
        // Configuracion del boton.
        botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(100,270,150, 30);
        botonConvertir.addActionListener(this);
        add(botonConvertir);
    }
    
    /**
     * Cargamos las equivalencias de origen y destino
     */
    private void cargarEquivalencias(){
        for(int i = 0; i < Equivalencia.equivalencias.length; i++){
            Equivalencia equivalencia = Equivalencia.equivalencias[i];
            equivalenciasOrigen.addItem(equivalencia.toString());
        }
        for(int i = 0; i < Equivalencia.equivalencias.length; i++){
            Equivalencia equivalencia = Equivalencia.equivalencias[i];
            equivalenciasDestino.addItem(equivalencia.toString());
        }
    }
    
    /**
     * Aquí se captura la accion del click en el boton.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == botonConvertir){
            DecimalFormat formateador = new DecimalFormat("#,##0.00");
            Equivalencia origen = Equivalencia.equivalencias[this.equivalenciasOrigen.getSelectedIndex()];
            Equivalencia destino = Equivalencia.equivalencias[this.equivalenciasDestino.getSelectedIndex()];
            try{
                double monto = Double.parseDouble(this.monto.getText());
                double montoEnDolares = 0;
                if(origen.getCodigo().equals("USD")){
                    montoEnDolares = monto;
                } else{
                    montoEnDolares = convertidor.convertirEquivalenciaADolares(monto, origen);
                }
                double montoConvertido = convertidor.convertirEntreEquivalencias(monto, origen, destino);
                this.montoDolares.setText("USD "+formateador.format(montoEnDolares));
                this.montodestino.setText(destino.getCodigo()+ " "+formateador.format(montoConvertido));
                this.origenCompra.setText("Origen Compra: "+ formateador.format(origen.getPrecioCompra()) 
                        +" | Venta: "+ formateador.format(origen.getPrecioVenta()));
                this.destinoCompra.setText("Destino compra: "+ formateador.format(destino.getPrecioCompra())
                        +" | Venta: "+ formateador.format(destino.getPrecioVenta()));
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El monto debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CRUnion ventana = new CRUnion();
        ventana.setBounds(0,0,380,350);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        
    }

    
    
}
