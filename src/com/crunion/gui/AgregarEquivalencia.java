package com.crunion.gui;

import com.crunion.dominio.Equivalencia;
import com.crunion.dominio.Equivalencias_Nuevas;
import javax.swing.JOptionPane;

/**
 * Clase para agregar nueva equivalencia.
 * @author Mayarling Martinez
 */
public class AgregarEquivalencia extends javax.swing.JFrame {
    
    private CRUnion ventanaPrincial;

    /**
     * Creates new form AgregarEquivalencia
     * @param ventanaPrincipal La ventana Principal.
     */
    public AgregarEquivalencia(CRUnion ventanaPrincipal) {
        initComponents();
        this.ventanaPrincial = ventanaPrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaCodigo = new javax.swing.JLabel();
        etiquetaDescripcion = new javax.swing.JLabel();
        etiquetaPrecioCompra = new javax.swing.JLabel();
        etiquetaPrecioVenta = new javax.swing.JLabel();
        campoTextoCodigo = new javax.swing.JTextField();
        campoTextoDescripcion = new javax.swing.JTextField();
        campoTextoCompra = new javax.swing.JTextField();
        campoTextoVenta = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar nueva equivalencia");
        setAlwaysOnTop(true);
        setName("FrameAgregarEquivalencia"); // NOI18N
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiquetaTitulo.setText("Agregar una nueva equivalencia");

        etiquetaCodigo.setText("Código de moneda:");

        etiquetaDescripcion.setText("Descripción de moneda:");

        etiquetaPrecioCompra.setText("Precio de compra:");

        etiquetaPrecioVenta.setText("Precio de venta:");

        campoTextoCodigo.setToolTipText("Indique el código ISO de la moneda");

        campoTextoDescripcion.setToolTipText("Indique la descripción de la moneda");

        campoTextoCompra.setToolTipText("Indique el precio de compra");

        campoTextoVenta.setToolTipText("Indique el precio de venta");

        botonGuardar.setText("Guardar Moneda");
        botonGuardar.setToolTipText("Click para guardar la moneda");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCodigo)
                                .addGap(33, 33, 33)
                                .addComponent(campoTextoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaDescripcion)
                                    .addComponent(etiquetaPrecioCompra)
                                    .addComponent(etiquetaPrecioVenta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTextoDescripcion)
                                    .addComponent(campoTextoCompra)
                                    .addComponent(campoTextoVenta)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(etiquetaTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(botonGuardar)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCodigo)
                    .addComponent(campoTextoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDescripcion)
                    .addComponent(campoTextoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPrecioCompra)
                    .addComponent(campoTextoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPrecioVenta)
                    .addComponent(campoTextoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // Bandera para saber si los datos son validos, se asume por defecto que es true
        // y si se encuentra 1 dato invalido se actualiza el valor a false
        boolean datosValidos = true;
        
        // Obtenemos y validamos el codigo de moneda
        String codigoMoneda = this.campoTextoCodigo.getText();
        if(codigoMoneda == null || codigoMoneda.equals("")){
            JOptionPane.showMessageDialog(this, "El código de la moneda es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else if(codigoMoneda.length() != 3) {
            JOptionPane.showMessageDialog(this, "El código de la moneda debe ser de 3 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Obtenemos y validamos la descripcion de la moneda
        String descripcion = this.campoTextoDescripcion.getText();
        if(descripcion == null || descripcion.equals("")){
            JOptionPane.showMessageDialog(this, "La descripción de la moneda es requerida.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else if(descripcion.length() > 20) {
            JOptionPane.showMessageDialog(this, "La descripción de la moneda debe ser menor o igual a 20 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Obtenemos y validamos el precio de compra
        String textoPrecioCompra = this.campoTextoCompra.getText();
        double precioCompra = 0;
        try{
            precioCompra = Double.parseDouble(textoPrecioCompra);
            if(precioCompra <= 0) {
                JOptionPane.showMessageDialog(this, "El precio de compra no puede ser menor o igual a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            } else if (precioCompra > 100_000) {
                JOptionPane.showMessageDialog(this, "El precio de compra no puede ser mayor a 100,000.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "El precio de compra debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Obtenemos y validamos el precio de venta
        String textoPrecioVenta = this.campoTextoVenta.getText();
        double precioVenta = 0;
        try{
            precioVenta = Double.parseDouble(textoPrecioVenta);
            if(precioVenta <= 0) {
                JOptionPane.showMessageDialog(this, "El precio de venta no puede ser menor o igual a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            } else if (precioVenta > 100_000) {
                JOptionPane.showMessageDialog(this, "El precio de venta no puede ser mayor a 100,000.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "El precio de venta debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Si los datos son validos, intentamos guardar.
        if(datosValidos) {
            Equivalencia nuevaEquivalencia = new Equivalencia(descripcion, precioCompra, precioVenta, codigoMoneda.toUpperCase());
            try {
                Equivalencias_Nuevas objetoEquivalencias = new Equivalencias_Nuevas();
                objetoEquivalencias.Agregar_Nueva_Equivalencia(nuevaEquivalencia);
                this.ventanaPrincial.cargarEquivalencias();
                this.dispose();
            } catch(Exception exception) {
                JOptionPane.showMessageDialog(this, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField campoTextoCodigo;
    private javax.swing.JTextField campoTextoCompra;
    private javax.swing.JTextField campoTextoDescripcion;
    private javax.swing.JTextField campoTextoVenta;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaPrecioCompra;
    private javax.swing.JLabel etiquetaPrecioVenta;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}
