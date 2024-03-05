package com.crunion.gui;

import com.crunion.dominio.Cliente;
import com.crunion.dominio.Transaccion;
import com.crunion.logica.ServicioCliente;
import com.crunion.logica.ServicioTransaccion;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para el reporte de conversiones realizadas por cliente.
 * @author Mayarling Martínez
 */
public class PantallaConversionesPorCliente extends javax.swing.JFrame {
    
    private ServicioTransaccion servicioTransaccion;
    private ServicioCliente servicioCliente;

    /**
     * Constructor por paramentros.
     * @param servicioTransaccion El servicio transacciónj.
     * @param servicioCliente El servicio cliente.
     */
    public PantallaConversionesPorCliente(ServicioTransaccion servicioTransaccion, ServicioCliente servicioCliente) {
        initComponents();
        this.servicioTransaccion = servicioTransaccion;
        this.servicioCliente = servicioCliente;
        this.reiniciarCampos();
    }
    
    /**
     * Método que reinicia la tabla.
     */
    private void reiniciarCampos(){
        this.tablaConversionesMoneda.setModel(new DefaultTableModel(new String[0][4], new String[]{"Moneda de origen", "Monto", "Moneda de destino", "Monto"}));
        this.campoNombre.setText("");
        this.campoNacionalidad.setText("");
        this.campoEdad.setText("");
    }
    
    /**
     * Este método se encarga de cargar todos los datos correspondientes a las transacciones realizadas por tipo de moneda.
     */
    private void cargarDatosDeTransacciones(Cliente cliente){
        List<Transaccion> transaccionesPorCliente = this.servicioTransaccion.obtenerTransacciones(cliente);
        String[] encabezadosDeLaTabla = {"Moneda de origen", "Monto", "Moneda de destino", "Monto"};
        String[][] datos = new String[transaccionesPorCliente.size()][4];
        int indice = 0;
        DecimalFormat formateador = new DecimalFormat("#,##0.00");
        for(Transaccion transaccion : transaccionesPorCliente){
            datos[indice][0] = "(" + transaccion.getCodigoMonedaOrigen() + ") " + transaccion.getDescripcionMonedaOrigen();
            datos[indice][1] = formateador.format(transaccion.getMontoOrigen());
            datos[indice][2] = "(" + transaccion.getCodigoMonedaDestino()+ ") " + transaccion.getDescripcionMonedaDestino();
            datos[indice][3] = formateador.format(transaccion.getMontoDestino());
            indice ++;
        }
        if(transaccionesPorCliente.isEmpty()){
            JOptionPane.showMessageDialog(this, "El cliente que se busco no tiene conversiones registradas.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        DefaultTableModel modeloDeDatos = new DefaultTableModel(datos, encabezadosDeLaTabla);
        this.tablaConversionesMoneda.setModel(modeloDeDatos);
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
        etiquetaId = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConversionesMoneda = new javax.swing.JTable();
        botonCerrar = new javax.swing.JButton();
        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        etiquetaNacionalidad = new javax.swing.JLabel();
        campoNacionalidad = new javax.swing.JTextField();
        etiquetaEdad = new javax.swing.JLabel();
        campoEdad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conversiones por cliente");
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiquetaTitulo.setText("Reporte de las conversiones por cliente");

        etiquetaId.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiquetaId.setText("ID del cliente:");

        campoId.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoId.setToolTipText("Digite el ID del usuario que desea buscar.");

        botonBuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setToolTipText("Click para buscar.");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaConversionesMoneda.setEnabled(false);
        jScrollPane1.setViewportView(tablaConversionesMoneda);

        botonCerrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        botonCerrar.setForeground(new java.awt.Color(0, 0, 204));
        botonCerrar.setText("Cerrar");
        botonCerrar.setToolTipText("Click para cerrar esta ventana.");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        etiquetaNombre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiquetaNombre.setText("Nombre:");

        campoNombre.setEditable(false);
        campoNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        etiquetaNacionalidad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiquetaNacionalidad.setText("Nacionalidad:");

        campoNacionalidad.setEditable(false);
        campoNacionalidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        etiquetaEdad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiquetaEdad.setText("Edad:");

        campoEdad.setEditable(false);
        campoEdad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(etiquetaTitulo)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNacionalidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaEdad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoEdad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 44, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(etiquetaTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaId)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNacionalidad)
                    .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaEdad)
                    .addComponent(campoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        boolean datosValidos = true;
        int idClienteBusqueda = 0;
        String textoIdCliente = this.campoId.getText();
        if(textoIdCliente == null || textoIdCliente.trim().equals("")){
            JOptionPane.showMessageDialog(this, "El ID de cliente para la busqueda es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else {
            try {
                idClienteBusqueda = Integer.parseInt(textoIdCliente);
                if(idClienteBusqueda <= 0 || idClienteBusqueda > 999999999) {
                    JOptionPane.showMessageDialog(this, "El ID del cliente para la busqueda debe ser mayor a cero y menor que 999999999.", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } else {
                    //Verificar que el ID digitado corresponda con un ID valido.
                    if(!this.servicioCliente.existeCliente(idClienteBusqueda)){
                        JOptionPane.showMessageDialog(this, "El ID digitado no corresponde a ningún cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                        datosValidos = false;
                    }
                }
            } catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "El ID de cliente para la busqueda debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        }
        if(datosValidos) {
            Cliente cliente = this.servicioCliente.obtenerCliente(idClienteBusqueda);
            this.campoNombre.setText(cliente.getNombreCompleto());
            this.campoNacionalidad.setText(cliente.getNacionalidad());
            this.campoEdad.setText(Integer.toString(cliente.getEdad()));
            this.cargarDatosDeTransacciones(cliente);
        } else {
            this.reiniciarCampos();
        }
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JTextField campoEdad;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNacionalidad;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel etiquetaEdad;
    private javax.swing.JLabel etiquetaId;
    private javax.swing.JLabel etiquetaNacionalidad;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaConversionesMoneda;
    // End of variables declaration//GEN-END:variables
}