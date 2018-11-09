
package Base_de_Datos;


import Manejadora.PRINCIPAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Ingresos {
    conexionBD cone = new conexionBD();
    Connection cne = cone.conexion();
     Cliente cl = new Cliente();
     public void ingresoClt(String cod,String ec){
        try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_clientes (IdCliente,Apellido1_clt,Apellido2_clt,ApellidoCasada"
                        + "_clt,Nombre1_clt,Nombre2_clt,Nombre3_clt,EstadoCivil_clt,Dpi_clt,FechaNac_clt,Edad_clt,Profesion_clt,DirDomicilio_clt,"
                +" DirCobro_clt,Nit_clt,TelCasa_clt,TelOficina_clt,TelCelular_clt) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pps.setString(1, cod);
                pps.setString(2, Manejadora.CLIENTES.ICApellido1Txt2.getText());
                pps.setString(3, Manejadora.CLIENTES.ICApellido2Txt2.getText());
                pps.setString(4, Manejadora.CLIENTES.ICApellidoCasTxt2.getText());
                pps.setString(5, Manejadora.CLIENTES.ICNombre1Txt2.getText());
                pps.setString(6, Manejadora.CLIENTES.ICNombre2Txt2.getText());
                 pps.setString(7, Manejadora.CLIENTES.ICNombre3Txt2.getText());
                pps.setString(8, ec);
                pps.setString(9,  Manejadora.CLIENTES.ICNoDpiTxt2.getText());
                pps.setString(10, Manejadora.CLIENTES.ICFNacTxt2.getText());
                pps.setString(11, Manejadora.CLIENTES.ICEdadTxt2.getText());
                pps.setString(12, Manejadora.CLIENTES.ICProfesionTxt2.getText());
                pps.setString(13, Manejadora.CLIENTES. ICDirDomTxt2.getText());
                pps.setString(14, Manejadora.CLIENTES.ICDirCobroTxt2.getText());
                pps.setString(15, Manejadora.CLIENTES.ICNitTxt2.getText());
                pps.setString(16, Manejadora.CLIENTES.ICTelefonoCasTxt2.getText());
                pps.setString(17, Manejadora.CLIENTES.ICTelOficinaTxt2.getText());
                pps.setString(18, Manejadora.CLIENTES.ICTelCelTxt2.getText());
                
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     ///////////////////////////////////////////////////
     public void ingresoGastosMed(String id, String Cobertura,String tipo,String PD)
      {
           try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_gastos_medicos(IdAseguradora_gm,IdCliente_gm,NoPoliza_gm,NoCertificado_gm,"
                +"NombrePlan_gm,Cobertura_gm,DescripcionCobertura_gm,TipoPoliza_gm,FechaEfectivaInicio_gm,FechaEfectivaFin_gm,MaximoVitalicio_gm,SumaVida_gm,PlanDental_gm,EstadoPoliza_gm) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pps.setString(1, Manejadora.GASTOS_MEDICOS.IGMAseguradoraTxt.getText());
                pps.setString(2, id);
                pps.setString(3, Manejadora.GASTOS_MEDICOS.IGMNoPolizaTxt.getText());
                pps.setString(4, Manejadora.GASTOS_MEDICOS.IGMNoCertificadoTxt.getText());
                pps.setString(5, Manejadora.GASTOS_MEDICOS.IGMNomPlanTxt.getText());
                pps.setString(6, Cobertura);
                pps.setString(7, Manejadora.GASTOS_MEDICOS.IIGM1DescTxt.getText());
                pps.setString(8, tipo);
                pps.setString(9, Manejadora.GASTOS_MEDICOS.IGMfechaEfecTxt.getText());
                pps.setString(10, Manejadora.GASTOS_MEDICOS.IGMfechaEfecTxt1.getText());
                pps.setString(11, Manejadora.GASTOS_MEDICOS.IGMMaxVitaTxt.getText());
                pps.setString(12,Manejadora.GASTOS_MEDICOS.IGmSumaAvidaTxt.getText());
                pps.setString(13, PD);
                pps.setString(14,Manejadora.GASTOS_MEDICOS.IGmEstadoPolTxt.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        /////////////////////////////////////////////////
      public void ingresoVehiculos(String cod,String t_vehiculo,String cobertura,String CM,String Cm){
    try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_vehiculos`(`IdAseguradora_vhl`, `IdPolizaVhl`, "
                        +"`NoPoliza_vhl`, `NoCertificado_vhl`, `VigenciaInicio_vhl`, `VigeciaFin_vhl`, `Contratante_vhl`, "
                        +"`IdCliente_vhl`, `Asegurado_vhl`,`Direccion_vhl`, `Nit_vhl`, `Marca_vhl`, `Linea_vhl`, `Modelo_vhl`, `Placa_vhl`,"
                        +" `Color_vhl`, `NoChasis_vhl`, `NoMotor_vhl`, `Pasajeros_vhl`, `Tipo_vhl`, `Cobertura_vhl`, "
                        +"`DescripcionCobertura_vhl`, `SumaVehiculo_vhl`, `SumaRC_vhl`, `DeducibleCañosPropios_vhl`,"
                        +" `DeducibleRobo_vhl`, `ConductoresMenores_vhl`, `ConductoresMayores_vhl`, `Tarifa_vhl`, "
                        +"`EstadoPoliza_vhl`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pps.setString(1, Manejadora.VEHICULOS.IVAseguradoraTxt.getText());
                pps.setString(2, Manejadora.VEHICULOS.IVNoPolizaTxt.getText()+"1");
                pps.setString(3, Manejadora.VEHICULOS.IVNoPolizaTxt.getText());
                pps.setString(4, Manejadora.VEHICULOS.IVNoCertificadoTxt.getText());
                pps.setString(5, Manejadora.VEHICULOS.IVVigenciaTxt.getText());
                pps.setString(6, Manejadora.VEHICULOS.IVVigenciaTxt1.getText());
                pps.setString(7, Manejadora.VEHICULOS.IVContratanteTxt.getText());
                pps.setString(8,cod );
                pps.setString(9,   cl.datosClt(cod));
                pps.setString(10,  cl.datosClt2(cod));
                pps.setString(11,  cl.datosClt3(cod));
                pps.setString(12, Manejadora.VEHICULOS.IVMarcaTxt.getText());
                pps.setString(13, Manejadora.VEHICULOS.IVLineaTxt.getText());
                pps.setString(14, Manejadora.VEHICULOS.IVModeloTxt.getText());
                pps.setString(15, Manejadora.VEHICULOS.IVPlacaTxt.getText());
                pps.setString(16, Manejadora.VEHICULOS.IVColorTxt.getText());
                pps.setString(17, Manejadora.VEHICULOS.IVChasisNoTxt.getText());
                pps.setString(18, Manejadora.VEHICULOS.IVMotorNoTxt.getText());
                pps.setString(19, Manejadora.VEHICULOS.IVPasajerosTxt.getText());
                pps.setString(20, t_vehiculo);
                pps.setString(21, cobertura);
                pps.setString(22, Manejadora.VEHICULOS.IV2Desc.getText());
                pps.setString(23, Manejadora.VEHICULOS.IV2SumaAVehiculoTxt.getText());
                pps.setString(24, Manejadora.VEHICULOS.IV2SumaARCTxt.getText());
                pps.setString(25, Manejadora.VEHICULOS.IV2DeducibleDañoPTxt.getText());
                pps.setString(26, Manejadora.VEHICULOS.IV2DeducibleRoboTxt.getText());
                pps.setString(27, CM);
                pps.setString(28, Cm);
                pps.setString(29, Manejadora.VEHICULOS.IV2TarifaTxt.getText());     
                pps.setString(30, Manejadora.VEHICULOS.IV2EstadoPloTxt.getText());    
                
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      ////////////////////////////////////////////////////////////////

      public void ingresoCobrosV(int i,String id, String NP, String idpol){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_cobros_vhl`(`IdCliente_cbrvhl`,"
                +" `IdPolizaVhl_cbrvhl`, `NoPoliza_cbr`, `NoRequerimiento_cbrvhl`, `FPago_cbrvhl`, `Prima_cbrvhl`, "
                +"`NoPago_cbrvhl`, `EstadoPago_cbrvhl`) VALUES(?,?,?,?,?,?,?,?)");
                pps.setString(1, id);
                pps.setString(2, idpol);
                pps.setString(3, NP);
                pps.setString(4,  Manejadora.COBROS.REQ_COBRO.getText());
                pps.setString(5,  Manejadora.COBROS.FECHA_COBRO.getText());
                pps.setString(6,  Manejadora.COBROS.PRIMA_COBRO.getText());
                pps.setString(7, ""+String.valueOf(i));
                pps.setString(8,  Manejadora.COBROS.ESTADO_COBRO.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////

      public void ingresoCobrosGM(int i,String id, String NP){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_cobros_gm`(`IdCliente_cbrgm`,"
                +"`NoPoliza_cbrgm`, `NoRequerimiento_cbrgm`, `FechaPago_cbrgm`, `Prima_cbrgm`, `NoPago_cbrgm`,"
                +" `EstadoPago_cbrgm`) VALUES(?,?,?,?,?,?,?)");
                pps.setString(1, id);
                pps.setString(2, NP);
                pps.setString(3,  Manejadora.COBROS.REQ_COBRO.getText());
                pps.setString(4,  Manejadora.COBROS.FECHA_COBRO.getText());
                pps.setString(5,  Manejadora.COBROS.PRIMA_COBRO.getText());
                pps.setString(6, ""+String.valueOf(i));
                pps.setString(7,  Manejadora.COBROS.ESTADO_COBRO.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      public void ingresoCobrosvd(int i,String id, String NP){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_cobros_vd`(`IdCliente_cbrvd`,"
                +"`NoPoliza_cbrvd`, `NoRequerimiento_cbrvd`, `FechaPago_cbrvd`, `Prima_cbrvd`, `NoPago_cbrvd`,"
                +" `EstadoPago_cbrvd`) VALUES(?,?,?,?,?,?,?)");
                pps.setString(1, id);
                pps.setString(2, NP);
                pps.setString(3,  Manejadora.COBROS.REQ_COBRO.getText());
                pps.setString(4,  Manejadora.COBROS.FECHA_COBRO.getText());
                pps.setString(5,  Manejadora.COBROS.PRIMA_COBRO.getText());
                pps.setString(6, ""+String.valueOf(i));
                pps.setString(7,  Manejadora.COBROS.ESTADO_COBRO.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      public void ingresoCobrosee(int i,String id, String NP){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_cobros_ee`(`IdCliente_cbree`,"
                +"`NoPoliza_cbree`, `NoRequerimiento_cbree`, `FechaPago_cbree`, `Prima_cbree`, `NoPago_cbree`,"
                +" `EstadoPago_cbree`) VALUES(?,?,?,?,?,?,?)");
                pps.setString(1, id);
                pps.setString(2, NP);
                pps.setString(3,  Manejadora.COBROS.REQ_COBRO.getText());
                pps.setString(4,  Manejadora.COBROS.FECHA_COBRO.getText());
                pps.setString(5,  Manejadora.COBROS.PRIMA_COBRO.getText());
                pps.setString(6, ""+String.valueOf(i));
                pps.setString(7,  Manejadora.COBROS.ESTADO_COBRO.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      //////////////////////////////////////////////////////////////////////////
      public void IngresosFam(String id , String Npol ){
           try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_familiares (IdCliente_fm,NoPoliza_fm,FEfectivaInicio_fm,"
                +"FEfectivaFin_fm,Nombre1_fm,Nombre2_fm,Apellido1_fm,Apellido2_fm,FechaNac_fm,Edad_fm,Parentesco_fm) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                pps.setString(1, id);
                pps.setString(2, Npol);
                pps.setString(3, Manejadora.GASTOS_MEDICOS.IGM2NoReqTxt1.getText());
                pps.setString(4, Manejadora.GASTOS_MEDICOS.IGM2NoReqTxt2.getText());
                pps.setString(5, Manejadora.GASTOS_MEDICOS.IGMfechaPTxt1.getText());
                pps.setString(6, Manejadora.GASTOS_MEDICOS.IGMfechaPTxt3.getText());
                pps.setString(7, Manejadora.GASTOS_MEDICOS.IGM2PrimaTxt1.getText());
                pps.setString(8, Manejadora.GASTOS_MEDICOS.IGMfechaPTxt4.getText());
                pps.setString(9, Manejadora.GASTOS_MEDICOS.IGMfechaPTxt2.getText());
                pps.setString(10, Manejadora.GASTOS_MEDICOS.IGM2PrimaTxt2.getText());
                pps.setString(11, Manejadora.GASTOS_MEDICOS.IGM2PrimaTxt3.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
      //////////////////////////////////////////////////////////////////////////////
      public void IngresosContacto( ){
           try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_contacto_aseguradora (NombreCompleto_Cas,Telefonos_Cas,Cargo_cas"
                 +") VALUES(?,?,?)");
               
                pps.setString(1, Manejadora.CONTACTO.NOMBRE_CTO.getText());
                pps.setString(2, Manejadora.CONTACTO.TEL_CTO.getText());
                pps.setString(3, Manejadora.CONTACTO.CARGO_CTO.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
      //////////////////////////////////////////////////////////////////////////////////
      public void IngresosAseguradora( ){
           try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_aseguradora (Nombre_as,Nit_as,Direccion_as,Telefonos_as"
                 +") VALUES(?,?,?,?)");
               
                pps.setString(1, Manejadora.ASEGURADORA.NOMBRE_AS.getText());
                pps.setString(2, Manejadora.ASEGURADORA.NIT_AS.getText());
                pps.setString(3, Manejadora.ASEGURADORA.DIRECCION_AS.getText());
                pps.setString(4, Manejadora.ASEGURADORA.TEL_AS.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
      /////////////////////////////////////////////////////////////////////////////////////
      public void ingresoVida(String id, String IdAs)
      {
           try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_vida(IdCliente_vd,IdAseguradora_vd,NoPoliza_vd,FechaInicio_vd,FechaFin_vd,"
                +"SumaAsegurada_vd,Coberturas_vd,DescripcionCobertura_vd,Prima_vd,EstadoPoliza_vd) VALUES(?,?,?,?,?,?,?,?,?,?)");
                pps.setString(1, id);
                pps.setString(2, IdAs);
                pps.setString(3, Manejadora.VIDA.NOPOL_VD.getText());
                pps.setString(4, Manejadora.VIDA.FI_VD.getText());
                pps.setString(5, Manejadora.VIDA.FF_VD.getText());
                pps.setString(6, Manejadora.VIDA.SUMAAS_VD.getText());
                pps.setString(7, Manejadora.VIDA.COBERTURA_VD.getText());
                pps.setString(8, Manejadora.VIDA.DESCCOBRETURAS_VD.getText());
                pps.setString(9, Manejadora.VIDA.PRIMA_VD.getText());
                pps.setString(10, Manejadora.VIDA.ESTADO_VD.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      public void ingresoBeneficiarios(String NoPol)
      {
           try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_beneficiarios(NoPolizaVd_bfs,Nombre_bfs,FechaNac_bfs,Dpi_bfs,"
                +"Parentesco_bfs) VALUES(?,?,?,?,?)");
                pps.setString(1, NoPol);
                pps.setString(2, Manejadora.VIDA.NOMBRE_BFO.getText());
                pps.setString(3, Manejadora.VIDA.FNAC_BFO.getText());
                pps.setString(4, Manejadora.VIDA.DPI_BFO.getText());
                pps.setString(5, Manejadora.VIDA.PARENTESCO_BFO.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      
      public void ingresoEE(String cod,String CB){
        try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO tbl_equipo_electronico (IdAseguradora_ee,"
                 + "NoPoliza_ee,IdCliente_ee,NoCertificado_ee,VigenciaInicio_ee,VigenciaFin_ee,Cobertura_ee,DescripcionCobertura_ee,"
                + "NoFactura_ee,NoSerie_ee,SumaAsegurada_ee,DeducibleRobo_ee,EstadoPoliza_ee) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
               
                pps.setString(1, Manejadora.EQUIPO_E.IDAS_EE.getText());
                pps.setString(2, Manejadora.EQUIPO_E.NOPOL_EE.getText());
                pps.setString(3, cod);
                pps.setString(4, Manejadora.EQUIPO_E.CERTIFICADO_EE.getText());
                pps.setString(5, Manejadora.EQUIPO_E.FINICIO_EE.getText());
                pps.setString(6, Manejadora.EQUIPO_E.FFIN_EE.getText());
                 pps.setString(7, CB);
                pps.setString(8,  Manejadora.EQUIPO_E.DESC_EE.getText());
                pps.setString(9,  Manejadora.EQUIPO_E.FACT_EE.getText());
                pps.setString(10, Manejadora.EQUIPO_E.SERIE_EE.getText());
                pps.setString(11,  Manejadora.EQUIPO_E.SUMAAS_EE.getText());
                pps.setString(12, Manejadora.EQUIPO_E.DEDUCIBLE_EE.getText());
                pps.setString(13, Manejadora.EQUIPO_E.ESTADO__EE.getText());
                
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
            ////////////////////////////////////////////////////////////////
      public void ingresoReclamosV(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_vhl`("
                +" `IdPolizaRcl_vhl`,`FechaRcl_vhl`, `ClienteRcl_vhl`, "
                +"`TipoPolizaRcl_vhl`, `DescripcionRcl_vhl`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
            public void ingresoReclamosGM(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_gm`("
                +" `IdPolizaRcl_gm`,`FechaRcl_gm`, `ClienteRcl_gm`, "
                +"`TipoPolizaRcl_gm`, `DescripcionRcl_gm`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
                  public void ingresoReclamosEE(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_ee`("
                +" `IdPolizaRcl_ee`,`FechaRcl_ee`, `ClienteRcl_ee`, "
                +"`TipoPolizaRcl_ee`, `DescripcionRcl_ee`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
      public void ingresoReclamosVD(String NP, String clt, String tipo){
      try {
                PreparedStatement pps = cne.prepareStatement("INSERT INTO `tbl_Reclamos_vd`("
                +" `IdPolizaRcl_vd`,`FechaRcl_vd`, `ClienteRcl_vd`, "
                +"`TipoPolizaRcl_vd`, `DescripcionRcl_vd`) VALUES(?,?,?,?,?)");
                pps.setString(1, NP);
                pps.setString(2, Manejadora.RECLAMOS.FECHA_COBRO.getText());
                pps.setString(3, clt);
                pps.setString(4, tipo);
                pps.setString(5,  Manejadora.RECLAMOS.TEL_CTO1.getText());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Guardado");

            } catch (SQLException ex) {
                Logger.getLogger(PRINCIPAL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      /////////////////////////////////////////////////////////////////
       
}
