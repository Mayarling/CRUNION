package com.crunion.gui;

import com.crunion.dominio.Cliente;
import com.crunion.logica.ServicioCliente;
import com.crunion.logica.ServicioTransaccion;
import javax.swing.JOptionPane;

/**
 * Clase para editar un cliente que ya esta registrado.
 * @author Mayarling Martínez 
 */
public class PantallaEditarCliente extends javax.swing.JFrame {
    
    private ServicioCliente servicioCliente;
    private ServicioTransaccion servicioTransaccion;
    private Cliente clienteParaEditar = null;

    /**
     * Constructor por parametro.
     * 
     * @param servicioCliente El servicio cliente.
     * @param servicioTransaccion El servicio transacción.
     */
    public PantallaEditarCliente(ServicioCliente servicioCliente, ServicioTransaccion servicioTransaccion) {
        initComponents();
        this.servicioCliente = servicioCliente;
        this.servicioTransaccion = servicioTransaccion;
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
        etiquetaIdClienete = new javax.swing.JLabel();
        campoIdCliente = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        etiquetaId = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaEdad = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoEdad = new javax.swing.JTextField();
        etiquetaNacionalidad = new javax.swing.JLabel();
        campoNacionalidad = new javax.swing.JTextField();
        etiquetaApellidos = new javax.swing.JLabel();
        campoApellidos = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar datos del cliente");
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        etiquetaTitulo.setText("Editar datos del cliente");

        etiquetaIdClienete.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiquetaIdClienete.setText("ID cliente:");

        campoIdCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoIdCliente.setToolTipText("Dígíte el Id del cliente que desea editar.");

        botonBuscar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setToolTipText("Click para buscar.");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        etiquetaId.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiquetaId.setText("ID:");

        etiquetaNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiquetaNombre.setText("Nombre:");

        etiquetaEdad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiquetaEdad.setText("Edad:");

        campoId.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoId.setToolTipText("Dígite el  nuevo ID.");
        campoId.setEnabled(false);

        campoNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoNombre.setToolTipText("Dígite el nombre.");
        campoNombre.setEnabled(false);

        campoEdad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoEdad.setToolTipText("Dígite la edad.");
        campoEdad.setEnabled(false);

        etiquetaNacionalidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiquetaNacionalidad.setText("Nacionalidad:");

        campoNacionalidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoNacionalidad.setToolTipText("Dígite la nacionalidad");
        campoNacionalidad.setEnabled(false);

        etiquetaApellidos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiquetaApellidos.setText("Apellidos:");

        campoApellidos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        campoApellidos.setToolTipText("Dígite los apellidos");
        campoApellidos.setEnabled(false);

        botonGuardar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setToolTipText("Click para guardar.");
        botonGuardar.setEnabled(false);
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
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaIdClienete)
                    .addComponent(etiquetaId)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetaEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(campoId, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoIdCliente, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoEdad))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNacionalidad)
                            .addComponent(etiquetaApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNacionalidad)
                            .addComponent(campoApellidos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(etiquetaTitulo)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(etiquetaTitulo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiquetaIdClienete)
                        .addComponent(campoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscar))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaId)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNacionalidad)
                    .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaApellidos)
                    .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaEdad)
                    .addComponent(campoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        boolean datosValidos = true;
        int idCliente = 0;
        int edadCliente = 0;

        String textoIdCliente = this.campoId.getText();
        
        if(textoIdCliente == null || textoIdCliente.trim().equals("")){
            JOptionPane.showMessageDialog(this, "El ID del cliente es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else {
            //Verificar que el ID digitado sea numerico.
            try {
                idCliente = Integer.parseInt(textoIdCliente);
                if(idCliente <= 0 || idCliente > 999999999) {
                    JOptionPane.showMessageDialog(this, "El ID del cliente debe ser mayor a cero y menor que 999999999.", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } else {
                    //Verificar que el ID digitado corresponda con un ID valido.
                    if(this.clienteParaEditar.getIdCliente() != idCliente && this.servicioCliente.existeCliente(idCliente)){
                        JOptionPane.showMessageDialog(this, "El ID digitado ya esta registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        datosValidos = false;
                    }
                }
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "El ID del cliente debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        }
        
        //verificamos que el usuario si digito el nombre.
        String textoNombreCliente = this.campoNombre.getText();
        if(textoNombreCliente == null || textoNombreCliente.trim().equals("")){
            JOptionPane.showMessageDialog(this, "El nombre del cliente es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else if(textoNombreCliente.length() > 30) {
            JOptionPane.showMessageDialog(this, "El nombre del cliente no puede ser mayor a 30 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        // verificamos que el usuario si dígito sus apellidos.
        String textoApellidosCliente = this.campoApellidos.getText();
        if(textoApellidosCliente == null || textoApellidosCliente.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Los apellidos del cliente son requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else if(textoApellidosCliente.length() > 50) {
            JOptionPane.showMessageDialog(this, "Los apellidos del cliente no pueden ser mayor a 50 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        // Verificamos que el usuario haya digitado la nacionalidad.
        String textoNacionalidad = this.campoNacionalidad.getText();
        if(textoNacionalidad == null || textoNacionalidad.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Debe digitar su nacionalidad.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else if(textoNacionalidad.length() > 25) {
            JOptionPane.showMessageDialog(this, "La nacionalidad no puede ser mayor a 25 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        // Vereficamos la edad del cliente.
        String textoEdadCliente = this.campoEdad.getText();
        if(textoEdadCliente == null || textoEdadCliente.trim().equals("")){
            JOptionPane.showMessageDialog(this, "La edad del cliente es requerida.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else {
            //Verificar que la edad sea numerico.
            try {
                edadCliente = Integer.parseInt(textoEdadCliente);
                if(edadCliente < 18 || edadCliente > 120) {
                    JOptionPane.showMessageDialog(this, "La edad del cliente debe ser mayor a 18 y menor que 120.", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } 
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "La edad del cliente debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        }
        
        if(datosValidos) {
            if(this.clienteParaEditar.getIdCliente() != idCliente){
                Cliente nuevoCliente = new Cliente(idCliente, textoNombreCliente, textoApellidosCliente, textoNacionalidad, edadCliente);
                try{
                    this.servicioCliente.borrarCliente(this.clienteParaEditar.getIdCliente());
                    this.servicioCliente.agregarCliente(nuevoCliente);
                    this.clienteParaEditar = null;
                    this.limpiarCampos();
                    this.deshabilitarCampos();
                    this.dispose();
                } catch(Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try{
                    this.clienteParaEditar.setNombre(textoNombreCliente);
                    this.clienteParaEditar.setApellidos(textoApellidosCliente);
                    this.clienteParaEditar.setNacionalidad(textoNacionalidad);
                    this.clienteParaEditar.setEdad(edadCliente);
                    this.servicioCliente.editarCliente(this.clienteParaEditar);
                    this.clienteParaEditar = null;
                    this.limpiarCampos();
                    this.deshabilitarCampos();
                    this.dispose();
                } catch(Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        boolean datosValidos = true;
        int idClienteBusqueda = 0;
        String textoIdCliente = this.campoIdCliente.getText();
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
            this.clienteParaEditar = this.servicioCliente.obtenerCliente(idClienteBusqueda);
            
            this.campoId.setText(Integer.toString(this.clienteParaEditar.getIdCliente()));
            if(this.servicioTransaccion.obtenerTransacciones(this.clienteParaEditar).isEmpty()){
                this.campoId.setEnabled(true);
            }
            
            this.campoNombre.setText(this.clienteParaEditar.getNombre());
            this.campoApellidos.setText(this.clienteParaEditar.getApellidos());
            this.campoNacionalidad.setText(this.clienteParaEditar.getNacionalidad());
            this.campoEdad.setText(Integer.toString(this.clienteParaEditar.getEdad()));
            this.habilitarCampos();
        } else {
            this.clienteParaEditar = null;
            this.limpiarCampos();
            this.deshabilitarCampos();
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    /**
     * Método que habilita los campos editables.
     */
    private void habilitarCampos() {
        this.campoNombre.setEnabled(true);
        this.campoApellidos.setEnabled(true);
        this.campoNacionalidad.setEnabled(true);
        this.campoEdad.setEnabled(true);
        this.botonGuardar.setEnabled(true);
    }
    
    /**
     * Método que deshabilita los campos editables.
     */
    private void deshabilitarCampos() {
        this.campoId.setEnabled(false);
        this.campoNombre.setEnabled(false);
        this.campoApellidos.setEnabled(false);
        this.campoNacionalidad.setEnabled(false);
        this.campoEdad.setEnabled(false);
        this.botonGuardar.setEnabled(false);
    }
    
    /**
     * Método que limpia los campos editables.
     */
    private void limpiarCampos() {
        this.campoId.setText("");
        this.campoNombre.setText("");
        this.campoApellidos.setText("");
        this.campoNacionalidad.setText("");
        this.campoEdad.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoEdad;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoIdCliente;
    private javax.swing.JTextField campoNacionalidad;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaEdad;
    private javax.swing.JLabel etiquetaId;
    private javax.swing.JLabel etiquetaIdClienete;
    private javax.swing.JLabel etiquetaNacionalidad;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}
