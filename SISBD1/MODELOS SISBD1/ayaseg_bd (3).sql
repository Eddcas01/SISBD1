-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2018 a las 04:28:49
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ayaseg_bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correos`
--

CREATE TABLE `correos` (
  `NoRegistro_email` int(5) NOT NULL,
  `Nombre_email` varchar(50) NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direcciones`
--

CREATE TABLE `direcciones` (
  `NoRegistro_dir` int(5) NOT NULL,
  `Nombre_dir` varchar(50) NOT NULL,
  `Direccion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_aseguradora`
--

CREATE TABLE `tbl_aseguradora` (
  `IdAseguradora` int(20) NOT NULL,
  `Nombre_as` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Nit_as` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Direccion_as` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Telefonos_as` text COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_aseguradora`
--

INSERT INTO `tbl_aseguradora` (`IdAseguradora`, `Nombre_as`, `Nit_as`, `Direccion_as`, `Telefonos_as`) VALUES
(1, '5', '5', '5', '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_beneficiarios`
--

CREATE TABLE `tbl_beneficiarios` (
  `NoPolizaVd_bfs` int(20) NOT NULL,
  `IdBeneficiario_bfs` int(20) NOT NULL,
  `Nombre_bfs` varchar(300) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Dpi_bfs` int(13) NOT NULL,
  `FechaNac_bfs` date NOT NULL,
  `Parentesco_bfs` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_beneficiarios`
--

INSERT INTO `tbl_beneficiarios` (`NoPolizaVd_bfs`, `IdBeneficiario_bfs`, `Nombre_bfs`, `Dpi_bfs`, `FechaNac_bfs`, `Parentesco_bfs`) VALUES
(5, 1, 'Gustavo', 1010, '1998-08-08', 'Ninguno'),
(632, 2, 'Gustavo', 10156, '1998-08-08', 'hijo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_clientes`
--

CREATE TABLE `tbl_clientes` (
  `IdCliente` int(20) NOT NULL,
  `Apellido1_clt` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Apellido2_clt` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `ApellidoCasada_clt` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `Nombre1_clt` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Nombre2_clt` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `Nombre3_clt` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `EstadoCivil_clt` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Dpi_clt` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `FechaNac_clt` date NOT NULL,
  `Edad_clt` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Profesion_clt` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DirDomicilio_clt` text COLLATE utf8mb4_spanish_ci,
  `DirCobro_clt` text COLLATE utf8mb4_spanish_ci,
  `Nit_clt` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `TelCasa_clt` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `TelOficina_clt` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `TelCelular_clt` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_clientes`
--

INSERT INTO `tbl_clientes` (`IdCliente`, `Apellido1_clt`, `Apellido2_clt`, `ApellidoCasada_clt`, `Nombre1_clt`, `Nombre2_clt`, `Nombre3_clt`, `EstadoCivil_clt`, `Dpi_clt`, `FechaNac_clt`, `Edad_clt`, `Profesion_clt`, `DirDomicilio_clt`, `DirCobro_clt`, `Nit_clt`, `TelCasa_clt`, `TelOficina_clt`, `TelCelular_clt`) VALUES
(138, 'a', 'a', 'a', 'a', 'a', 'a', 'Soltero', '1', '1998-08-08', '5', 'e', '2', '2', '2', '2', '2', '2'),
(139, 'a', 'a', 'a', 'a', 'a', 'a', 'Soltero', '1', '1998-08-08', '15', '5', '3', '3', '3', '3', '3', '3'),
(140, 'bbbb', 'b', 'bb', 'b', 'b', 'b', 'Soltero', '5', '1998-08-08', '15', 'f', '5', '5', '5', '55', '55', '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cobros_ee`
--

CREATE TABLE `tbl_cobros_ee` (
  `IdCliente_cbree` int(20) NOT NULL,
  `NoPoliza_cbree` int(20) NOT NULL,
  `NoRequerimiento_cbree` int(20) NOT NULL,
  `FechaPago_cbree` date NOT NULL,
  `Prima_cbree` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoPago_cbree` int(20) NOT NULL,
  `EstadoPago_cbree` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_cobros_ee`
--

INSERT INTO `tbl_cobros_ee` (`IdCliente_cbree`, `NoPoliza_cbree`, `NoRequerimiento_cbree`, `FechaPago_cbree`, `Prima_cbree`, `NoPago_cbree`, `EstadoPago_cbree`) VALUES
(138, 5, 9, '1999-08-08', '5', 1, 'pagado'),
(138, 5, 12, '1998-08-08', '65', 1, 'Pendiente'),
(140, 6321, 1649, '1987-08-08', '3000', 2, 'pp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cobros_gm`
--

CREATE TABLE `tbl_cobros_gm` (
  `IdCliente_cbrgm` int(20) NOT NULL,
  `NoPoliza_cbrgm` int(20) NOT NULL,
  `NoRequerimiento_cbrgm` int(20) NOT NULL,
  `FechaPago_cbrgm` date NOT NULL,
  `Prima_cbrgm` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoPago_cbrgm` int(20) NOT NULL,
  `EstadoPago_cbrgm` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_cobros_gm`
--

INSERT INTO `tbl_cobros_gm` (`IdCliente_cbrgm`, `NoPoliza_cbrgm`, `NoRequerimiento_cbrgm`, `FechaPago_cbrgm`, `Prima_cbrgm`, `NoPago_cbrgm`, `EstadoPago_cbrgm`) VALUES
(140, 458, 1649, '1987-08-08', '3000', 1, 'pp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cobros_vd`
--

CREATE TABLE `tbl_cobros_vd` (
  `IdCliente_cbrvd` int(20) NOT NULL,
  `NoPoliza_cbrvd` int(20) NOT NULL,
  `NoRequerimiento_cbrvd` int(20) NOT NULL,
  `FechaPago_cbrvd` date NOT NULL,
  `Prima_cbrvd` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoPago_cbrvd` int(20) NOT NULL,
  `EstadoPago_cbrvd` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_cobros_vd`
--

INSERT INTO `tbl_cobros_vd` (`IdCliente_cbrvd`, `NoPoliza_cbrvd`, `NoRequerimiento_cbrvd`, `FechaPago_cbrvd`, `Prima_cbrvd`, `NoPago_cbrvd`, `EstadoPago_cbrvd`) VALUES
(138, 5, 9, '1998-08-08', '5000', 1, 'Pagado'),
(140, 632, 1649, '1987-08-08', '3000', 3, 'pp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cobros_vhl`
--

CREATE TABLE `tbl_cobros_vhl` (
  `IdCliente_cbrvhl` int(20) NOT NULL,
  `IdPolizaVhl_cbrvhl` int(20) NOT NULL,
  `NoPoliza_cbr` int(50) NOT NULL,
  `NoRequerimiento_cbrvhl` int(20) NOT NULL,
  `FPago_cbrvhl` date NOT NULL,
  `Prima_cbrvhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoPago_cbrvhl` int(20) NOT NULL,
  `EstadoPago_cbrvhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_cobros_vhl`
--

INSERT INTO `tbl_cobros_vhl` (`IdCliente_cbrvhl`, `IdPolizaVhl_cbrvhl`, `NoPoliza_cbr`, `NoRequerimiento_cbrvhl`, `FPago_cbrvhl`, `Prima_cbrvhl`, `NoPago_cbrvhl`, `EstadoPago_cbrvhl`) VALUES
(140, 56, 65489, 84, '2018-11-01', '52656', 7, 'pp'),
(140, 654891, 65489, 7456, '1999-08-08', '6000', 1, 'Pagado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_contacto_aseguradora`
--

CREATE TABLE `tbl_contacto_aseguradora` (
  `Idcontacto` int(20) NOT NULL,
  `NombreCompleto_cas` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Telefonos_cas` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Cargo_cas` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_contacto_aseguradora`
--

INSERT INTO `tbl_contacto_aseguradora` (`Idcontacto`, `NombreCompleto_cas`, `Telefonos_cas`, `Cargo_cas`) VALUES
(2, 'Yo2', 'jaaaaaaaaaaaaaaaaaa\nisjaoiajsoijsoias\naskjdapsdkjpo', 'm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_ee`
--

CREATE TABLE `tbl_ee` (
  `IdSeguro_ee` int(4) NOT NULL,
  `IdAseguradora_ee` int(3) NOT NULL,
  `Coberturas_ee` text NOT NULL,
  `Cuotas_ee` text NOT NULL,
  `Requisitos_ee` text NOT NULL,
  `Descripcion_ee` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_equipo_electronico`
--

CREATE TABLE `tbl_equipo_electronico` (
  `IdAseguradora_ee` int(20) NOT NULL,
  `NoPoliza_ee` int(20) NOT NULL,
  `IdCliente_ee` int(20) NOT NULL,
  `NoCertificado_ee` int(50) NOT NULL,
  `VigenciaInicio_ee` date NOT NULL,
  `VigenciaFin_ee` date NOT NULL,
  `Cobertura_ee` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `DescripcionCobertura_ee` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoFactura_ee` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoSerie_ee` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `SumaAsegurada_ee` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DeducibleRobo_ee` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `EstadoPoliza_ee` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_equipo_electronico`
--

INSERT INTO `tbl_equipo_electronico` (`IdAseguradora_ee`, `NoPoliza_ee`, `IdCliente_ee`, `NoCertificado_ee`, `VigenciaInicio_ee`, `VigenciaFin_ee`, `Cobertura_ee`, `DescripcionCobertura_ee`, `NoFactura_ee`, `NoSerie_ee`, `SumaAsegurada_ee`, `DeducibleRobo_ee`, `EstadoPoliza_ee`) VALUES
(1, 5, 138, 5, '1998-08-08', '1998-08-08', 'C.A', '		', '5555', '5555', '55', '55', '5'),
(1, 6321, 140, 9874, '1998-08-08', '1999-08-08', 'C.A', '', '698745', '3214A', '3000', '15000', 'Activa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_familiares`
--

CREATE TABLE `tbl_familiares` (
  `IdCliente_fm` int(50) NOT NULL,
  `IdFamiliar` int(20) NOT NULL,
  `NoPoliza_fm` int(50) NOT NULL,
  `FEfectivaInicio_fm` date NOT NULL,
  `FEfectivaFin_fm` date NOT NULL,
  `Nombre1_fm` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Nombre2_fm` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Apellido1_fm` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Apellido2_fm` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `FechaNac_fm` date NOT NULL,
  `Edad_fm` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Parentesco_fm` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_familiares`
--

INSERT INTO `tbl_familiares` (`IdCliente_fm`, `IdFamiliar`, `NoPoliza_fm`, `FEfectivaInicio_fm`, `FEfectivaFin_fm`, `Nombre1_fm`, `Nombre2_fm`, `Apellido1_fm`, `Apellido2_fm`, `FechaNac_fm`, `Edad_fm`, `Parentesco_fm`) VALUES
(138, 1, 6, '1998-08-08', '1999-08-08', 'G', 'g', 'g', 'g', '1998-08-08', '20', 'ninguno'),
(140, 2, 458, '1998-08-08', '1999-08-08', 'g', 'g', 'g', 'g', '1997-07-07', '20', 'ninguno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_gastos_medicos`
--

CREATE TABLE `tbl_gastos_medicos` (
  `IdAseguradora_gm` int(20) NOT NULL,
  `IdCliente_gm` int(20) NOT NULL,
  `NoPoliza_gm` int(20) NOT NULL,
  `NoCertificado_gm` int(10) NOT NULL,
  `NombrePlan_gm` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Cobertura_gm` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DescripcionCobertura_gm` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `TipoPoliza_gm` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `FechaEfectivaInicio_gm` date NOT NULL,
  `FechaEfectivaFin_gm` date NOT NULL,
  `MaximoVitalicio_gm` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `SumaVida_gm` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `PlanDental_gm` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `EstadoPoliza_gm` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_gastos_medicos`
--

INSERT INTO `tbl_gastos_medicos` (`IdAseguradora_gm`, `IdCliente_gm`, `NoPoliza_gm`, `NoCertificado_gm`, `NombrePlan_gm`, `Cobertura_gm`, `DescripcionCobertura_gm`, `TipoPoliza_gm`, `FechaEfectivaInicio_gm`, `FechaEfectivaFin_gm`, `MaximoVitalicio_gm`, `SumaVida_gm`, `PlanDental_gm`, `EstadoPoliza_gm`) VALUES
(1, 138, 6, 6, '6', 'C.A.', '', 'Individual', '1998-08-08', '1998-08-08', '5000', '5', 'Inclido', 'Activa'),
(1, 140, 458, 741, 'si', 'C.A.', 'holaaaaa', 'Individual', '1998-08-08', '1998-08-08', '50000', '23000', 'No Incluido', 'Activa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_gm`
--

CREATE TABLE `tbl_gm` (
  `IdSeguro_gm` int(4) NOT NULL,
  `IdAseguradora_gm` int(3) NOT NULL,
  `Coberturas_gm` text NOT NULL,
  `Cuotas_gm` text NOT NULL,
  `Requisitos_gm` text NOT NULL,
  `Descripcion_gm` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_ee`
--

CREATE TABLE `tbl_reclamos_ee` (
  `IdReclamo_ee` int(20) NOT NULL,
  `IdPolizaRcl_ee` int(20) NOT NULL,
  `FechaRcl_ee` date NOT NULL,
  `ClienteRcl_ee` varchar(200) NOT NULL,
  `TipoPolizaRcl_ee` varchar(20) NOT NULL,
  `DescripcionRcl_ee` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_reclamos_ee`
--

INSERT INTO `tbl_reclamos_ee` (`IdReclamo_ee`, `IdPolizaRcl_ee`, `FechaRcl_ee`, `ClienteRcl_ee`, `TipoPolizaRcl_ee`, `DescripcionRcl_ee`) VALUES
(1, 5, '1998-08-08', '138', 'Equipo Electronico', 'lk'),
(2, 6321, '1998-08-08', '140', 'Equipo Electronico', 'hola');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_gm`
--

CREATE TABLE `tbl_reclamos_gm` (
  `IdReclamo_gm` int(20) NOT NULL,
  `IdPolizaRcl_gm` int(20) NOT NULL,
  `FechaRcl_gm` date NOT NULL,
  `ClienteRcl_gm` varchar(200) NOT NULL,
  `TipoPolizaRcl_gm` varchar(20) NOT NULL,
  `DescripcionRcl_gm` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_reclamos_gm`
--

INSERT INTO `tbl_reclamos_gm` (`IdReclamo_gm`, `IdPolizaRcl_gm`, `FechaRcl_gm`, `ClienteRcl_gm`, `TipoPolizaRcl_gm`, `DescripcionRcl_gm`) VALUES
(3, 6, '1999-08-08', '138', 'Gastos Medicos', ''),
(4, 458, '1998-08-08', '140', 'Gastos Medicos', 'hola');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_vd`
--

CREATE TABLE `tbl_reclamos_vd` (
  `IdReclamo_vd` int(20) NOT NULL,
  `IdPolizaRcl_vd` int(20) NOT NULL,
  `FechaRcl_vd` date NOT NULL,
  `ClienteRcl_vd` varchar(200) NOT NULL,
  `TipoPolizaRcl_vd` varchar(20) NOT NULL,
  `DescripcionRcl_vd` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_reclamos_vd`
--

INSERT INTO `tbl_reclamos_vd` (`IdReclamo_vd`, `IdPolizaRcl_vd`, `FechaRcl_vd`, `ClienteRcl_vd`, `TipoPolizaRcl_vd`, `DescripcionRcl_vd`) VALUES
(2, 5, '1998-08-08', '138', 'Vida', 'kk'),
(3, 632, '1998-08-08', '140', 'Vida', 'hola');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_vhl`
--

CREATE TABLE `tbl_reclamos_vhl` (
  `IdReclamo_vhl` int(20) NOT NULL,
  `IdPolizaRcl_vhl` int(20) NOT NULL,
  `FechaRcl_vhl` date NOT NULL,
  `ClienteRcl_vhl` varchar(200) NOT NULL,
  `TipoPolizaRcl_vhl` varchar(20) NOT NULL,
  `DescripcionRcl_vhl` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_reclamos_vhl`
--

INSERT INTO `tbl_reclamos_vhl` (`IdReclamo_vhl`, `IdPolizaRcl_vhl`, `FechaRcl_vhl`, `ClienteRcl_vhl`, `TipoPolizaRcl_vhl`, `DescripcionRcl_vhl`) VALUES
(1, 5, '1998-08-08', '138', 'Vehiculos', 'Hola'),
(2, 65489, '1998-08-08', '140', 'Vehiculos', 'hola');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_telefonos`
--

CREATE TABLE `tbl_telefonos` (
  `NoRegistro_tel` int(5) NOT NULL,
  `Nombre_tel` varchar(50) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_vd`
--

CREATE TABLE `tbl_vd` (
  `IdSeguro_vd` int(4) NOT NULL,
  `IdAseguradora_vd` int(3) NOT NULL,
  `Coberturas_vd` text NOT NULL,
  `Cuotas_vd` text NOT NULL,
  `Requisitos_vd` text NOT NULL,
  `Descripcion_vd` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_vehiculos`
--

CREATE TABLE `tbl_vehiculos` (
  `IdAseguradora_vhl` int(20) NOT NULL,
  `IdPolizaVhl` int(50) NOT NULL,
  `NoPoliza_vhl` int(50) NOT NULL,
  `NoCertificado_vhl` int(20) NOT NULL,
  `VigenciaInicio_vhl` date NOT NULL,
  `VigeciaFin_vhl` date NOT NULL,
  `Contratante_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `IdCliente_vhl` int(20) NOT NULL,
  `Asegurado_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Direccion_vhl` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Nit_vhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Marca_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Linea_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Modelo_vhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Placa_vhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Color_vhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoChasis_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NoMotor_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Pasajeros_vhl` int(10) NOT NULL,
  `Tipo_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Cobertura_vhl` varchar(25) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DescripcionCobertura_vhl` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `SumaVehiculo_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `SumaRC_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DeducibleCañosPropios_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DeducibleRobo_vhl` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ConductoresMenores_vhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ConductoresMayores_vhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Tarifa_vhl` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `EstadoPoliza_vhl` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_vehiculos`
--

INSERT INTO `tbl_vehiculos` (`IdAseguradora_vhl`, `IdPolizaVhl`, `NoPoliza_vhl`, `NoCertificado_vhl`, `VigenciaInicio_vhl`, `VigeciaFin_vhl`, `Contratante_vhl`, `IdCliente_vhl`, `Asegurado_vhl`, `Direccion_vhl`, `Nit_vhl`, `Marca_vhl`, `Linea_vhl`, `Modelo_vhl`, `Placa_vhl`, `Color_vhl`, `NoChasis_vhl`, `NoMotor_vhl`, `Pasajeros_vhl`, `Tipo_vhl`, `Cobertura_vhl`, `DescripcionCobertura_vhl`, `SumaVehiculo_vhl`, `SumaRC_vhl`, `DeducibleCañosPropios_vhl`, `DeducibleRobo_vhl`, `ConductoresMenores_vhl`, `ConductoresMayores_vhl`, `Tarifa_vhl`, `EstadoPoliza_vhl`) VALUES
(1, 51, 5, 5, '1998-08-08', '1998-08-08', 'f', 138, 'a a a a', '1', '2', 't', '5', '5', '5', '5', '5', '5', 5, 'Automovil', 'Completo', '	5						', '5', '5', '5', '5', 'Incluido', 'Incluido', '4', 'Activa'),
(1, 654891, 65489, 564, '1998-08-08', '1999-09-09', 'g', 140, 'b b b b', '5', '5', 'T', 'f', '1998', '555', 'a', '54789', '5698', 6, 'Cabezal', 'Completo', '', '50000', '45', '5000', '3000', 'Incluido', 'Incluido', '150', 'Activa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_vhl`
--

CREATE TABLE `tbl_vhl` (
  `IdSeguro_vhl` int(4) NOT NULL,
  `IdAseguradora_vhl` int(3) NOT NULL,
  `Coberturas_vhl` text NOT NULL,
  `Cuotas_vhl` text NOT NULL,
  `Requisitos_vhl` text NOT NULL,
  `Descripcion_vhl` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_vida`
--

CREATE TABLE `tbl_vida` (
  `idCLiente_vd` int(20) NOT NULL,
  `IdAseguradora_vd` int(20) NOT NULL,
  `NoPoliza_vd` int(20) NOT NULL,
  `FechaInicio_vd` date NOT NULL,
  `FechaFin_vd` date NOT NULL,
  `SumaAsegurada_vd` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Coberturas_vd` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `DescripcionCobertura_vd` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Prima_vd` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `EstadoPoliza_vd` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbl_vida`
--

INSERT INTO `tbl_vida` (`idCLiente_vd`, `IdAseguradora_vd`, `NoPoliza_vd`, `FechaInicio_vd`, `FechaFin_vd`, `SumaAsegurada_vd`, `Coberturas_vd`, `DescripcionCobertura_vd`, `Prima_vd`, `EstadoPoliza_vd`) VALUES
(138, 1, 5, '1998-08-08', '1998-08-08', '5', '5', '							', '51', 'Activa'),
(140, 1, 632, '1999-09-08', '1999-09-08', '65000', 'Total', '', '150000', 'Activa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `User` varchar(20) NOT NULL,
  `Pass` varchar(20) NOT NULL,
  `Tipo` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`User`, `Pass`, `Tipo`) VALUES
('Gustavo', '123', 'Admin'),
('Edgar', '321', 'User'),
('BD1', 'bdd', 'Admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `correos`
--
ALTER TABLE `correos`
  ADD PRIMARY KEY (`NoRegistro_email`);

--
-- Indices de la tabla `direcciones`
--
ALTER TABLE `direcciones`
  ADD PRIMARY KEY (`NoRegistro_dir`);

--
-- Indices de la tabla `tbl_aseguradora`
--
ALTER TABLE `tbl_aseguradora`
  ADD PRIMARY KEY (`IdAseguradora`);

--
-- Indices de la tabla `tbl_beneficiarios`
--
ALTER TABLE `tbl_beneficiarios`
  ADD PRIMARY KEY (`IdBeneficiario_bfs`),
  ADD KEY `NoPolizaVd_bfs` (`NoPolizaVd_bfs`);

--
-- Indices de la tabla `tbl_clientes`
--
ALTER TABLE `tbl_clientes`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `tbl_cobros_ee`
--
ALTER TABLE `tbl_cobros_ee`
  ADD PRIMARY KEY (`NoRequerimiento_cbree`),
  ADD KEY `NoPoliza_Cbr` (`NoPoliza_cbree`);

--
-- Indices de la tabla `tbl_cobros_gm`
--
ALTER TABLE `tbl_cobros_gm`
  ADD PRIMARY KEY (`NoRequerimiento_cbrgm`),
  ADD KEY `NoPoliza_Cbr` (`NoPoliza_cbrgm`);

--
-- Indices de la tabla `tbl_cobros_vd`
--
ALTER TABLE `tbl_cobros_vd`
  ADD PRIMARY KEY (`NoRequerimiento_cbrvd`),
  ADD KEY `NoPoliza_Cbr` (`NoPoliza_cbrvd`);

--
-- Indices de la tabla `tbl_cobros_vhl`
--
ALTER TABLE `tbl_cobros_vhl`
  ADD PRIMARY KEY (`NoRequerimiento_cbrvhl`),
  ADD KEY `NoPoliza_Cbr` (`IdPolizaVhl_cbrvhl`),
  ADD KEY `NoPoliza_cbr_2` (`NoPoliza_cbr`);

--
-- Indices de la tabla `tbl_contacto_aseguradora`
--
ALTER TABLE `tbl_contacto_aseguradora`
  ADD PRIMARY KEY (`Idcontacto`);

--
-- Indices de la tabla `tbl_ee`
--
ALTER TABLE `tbl_ee`
  ADD PRIMARY KEY (`IdSeguro_ee`),
  ADD KEY `IdAseguradora_ee` (`IdAseguradora_ee`);

--
-- Indices de la tabla `tbl_equipo_electronico`
--
ALTER TABLE `tbl_equipo_electronico`
  ADD PRIMARY KEY (`NoPoliza_ee`),
  ADD KEY `IdCliente_clt` (`IdCliente_ee`),
  ADD KEY `IdAseguradora_EE` (`IdAseguradora_ee`);

--
-- Indices de la tabla `tbl_familiares`
--
ALTER TABLE `tbl_familiares`
  ADD PRIMARY KEY (`IdFamiliar`),
  ADD KEY `NoPoliza_Fm` (`NoPoliza_fm`);

--
-- Indices de la tabla `tbl_gastos_medicos`
--
ALTER TABLE `tbl_gastos_medicos`
  ADD PRIMARY KEY (`NoPoliza_gm`),
  ADD KEY `IdCliente_clt` (`IdCliente_gm`),
  ADD KEY `IdAseguradora_Gm` (`IdAseguradora_gm`);

--
-- Indices de la tabla `tbl_gm`
--
ALTER TABLE `tbl_gm`
  ADD PRIMARY KEY (`IdSeguro_gm`),
  ADD KEY `IdAseguradora_gm` (`IdAseguradora_gm`);

--
-- Indices de la tabla `tbl_reclamos_ee`
--
ALTER TABLE `tbl_reclamos_ee`
  ADD PRIMARY KEY (`IdReclamo_ee`),
  ADD KEY `ee` (`IdPolizaRcl_ee`);

--
-- Indices de la tabla `tbl_reclamos_gm`
--
ALTER TABLE `tbl_reclamos_gm`
  ADD PRIMARY KEY (`IdReclamo_gm`),
  ADD KEY `gm` (`IdPolizaRcl_gm`);

--
-- Indices de la tabla `tbl_reclamos_vd`
--
ALTER TABLE `tbl_reclamos_vd`
  ADD PRIMARY KEY (`IdReclamo_vd`),
  ADD KEY `IdPolizaRcl_vd` (`IdPolizaRcl_vd`);

--
-- Indices de la tabla `tbl_reclamos_vhl`
--
ALTER TABLE `tbl_reclamos_vhl`
  ADD PRIMARY KEY (`IdReclamo_vhl`),
  ADD KEY `IdPolizaRcl_vhl` (`IdPolizaRcl_vhl`);

--
-- Indices de la tabla `tbl_telefonos`
--
ALTER TABLE `tbl_telefonos`
  ADD PRIMARY KEY (`NoRegistro_tel`);

--
-- Indices de la tabla `tbl_vd`
--
ALTER TABLE `tbl_vd`
  ADD PRIMARY KEY (`IdSeguro_vd`),
  ADD KEY `IdAseguradora_vd` (`IdAseguradora_vd`);

--
-- Indices de la tabla `tbl_vehiculos`
--
ALTER TABLE `tbl_vehiculos`
  ADD PRIMARY KEY (`IdPolizaVhl`),
  ADD KEY `Id_clt` (`IdCliente_vhl`),
  ADD KEY `Id_clt_2` (`IdCliente_vhl`),
  ADD KEY `IdAseguradora_Vhl` (`IdAseguradora_vhl`),
  ADD KEY `NoPoliza_vhl` (`NoPoliza_vhl`);

--
-- Indices de la tabla `tbl_vhl`
--
ALTER TABLE `tbl_vhl`
  ADD PRIMARY KEY (`IdSeguro_vhl`),
  ADD KEY `IdAseguradora_vhl` (`IdAseguradora_vhl`);

--
-- Indices de la tabla `tbl_vida`
--
ALTER TABLE `tbl_vida`
  ADD PRIMARY KEY (`NoPoliza_vd`),
  ADD KEY `NoPoliza_vd` (`NoPoliza_vd`),
  ADD KEY `IdAseguradora_vd` (`IdAseguradora_vd`),
  ADD KEY `idCLiente_vd` (`idCLiente_vd`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `correos`
--
ALTER TABLE `correos`
  MODIFY `NoRegistro_email` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `direcciones`
--
ALTER TABLE `direcciones`
  MODIFY `NoRegistro_dir` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_aseguradora`
--
ALTER TABLE `tbl_aseguradora`
  MODIFY `IdAseguradora` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tbl_beneficiarios`
--
ALTER TABLE `tbl_beneficiarios`
  MODIFY `IdBeneficiario_bfs` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_contacto_aseguradora`
--
ALTER TABLE `tbl_contacto_aseguradora`
  MODIFY `Idcontacto` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tbl_ee`
--
ALTER TABLE `tbl_ee`
  MODIFY `IdSeguro_ee` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_familiares`
--
ALTER TABLE `tbl_familiares`
  MODIFY `IdFamiliar` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_gm`
--
ALTER TABLE `tbl_gm`
  MODIFY `IdSeguro_gm` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_ee`
--
ALTER TABLE `tbl_reclamos_ee`
  MODIFY `IdReclamo_ee` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_gm`
--
ALTER TABLE `tbl_reclamos_gm`
  MODIFY `IdReclamo_gm` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_vd`
--
ALTER TABLE `tbl_reclamos_vd`
  MODIFY `IdReclamo_vd` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_vhl`
--
ALTER TABLE `tbl_reclamos_vhl`
  MODIFY `IdReclamo_vhl` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_telefonos`
--
ALTER TABLE `tbl_telefonos`
  MODIFY `NoRegistro_tel` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_vd`
--
ALTER TABLE `tbl_vd`
  MODIFY `IdSeguro_vd` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_vhl`
--
ALTER TABLE `tbl_vhl`
  MODIFY `IdSeguro_vhl` int(4) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_beneficiarios`
--
ALTER TABLE `tbl_beneficiarios`
  ADD CONSTRAINT `tbl_beneficiarios_ibfk_1` FOREIGN KEY (`NoPolizaVd_bfs`) REFERENCES `tbl_vida` (`NoPoliza_vd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_ee`
--
ALTER TABLE `tbl_cobros_ee`
  ADD CONSTRAINT `tbl_cobros_ee_ibfk_1` FOREIGN KEY (`NoPoliza_cbree`) REFERENCES `tbl_equipo_electronico` (`NoPoliza_ee`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_gm`
--
ALTER TABLE `tbl_cobros_gm`
  ADD CONSTRAINT `tbl_cobros_gm_ibfk_1` FOREIGN KEY (`NoPoliza_cbrgm`) REFERENCES `tbl_gastos_medicos` (`NoPoliza_gm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_vd`
--
ALTER TABLE `tbl_cobros_vd`
  ADD CONSTRAINT `tbl_cobros_vd_ibfk_1` FOREIGN KEY (`NoPoliza_cbrvd`) REFERENCES `tbl_vida` (`NoPoliza_vd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_vhl`
--
ALTER TABLE `tbl_cobros_vhl`
  ADD CONSTRAINT `tbl_cobros_vhl_ibfk_1` FOREIGN KEY (`NoPoliza_cbr`) REFERENCES `tbl_vehiculos` (`NoPoliza_vhl`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_ee`
--
ALTER TABLE `tbl_ee`
  ADD CONSTRAINT `tbl_ee_ibfk_1` FOREIGN KEY (`IdAseguradora_ee`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_equipo_electronico`
--
ALTER TABLE `tbl_equipo_electronico`
  ADD CONSTRAINT `tbl_equipo_electronico_ibfk_2` FOREIGN KEY (`IdCliente_ee`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_equipo_electronico_ibfk_3` FOREIGN KEY (`IdAseguradora_ee`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_familiares`
--
ALTER TABLE `tbl_familiares`
  ADD CONSTRAINT `tbl_familiares_ibfk_1` FOREIGN KEY (`NoPoliza_fm`) REFERENCES `tbl_gastos_medicos` (`NoPoliza_gm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_gastos_medicos`
--
ALTER TABLE `tbl_gastos_medicos`
  ADD CONSTRAINT `tbl_gastos_medicos_ibfk_2` FOREIGN KEY (`IdCliente_gm`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_gastos_medicos_ibfk_3` FOREIGN KEY (`IdAseguradora_gm`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_gm`
--
ALTER TABLE `tbl_gm`
  ADD CONSTRAINT `tbl_gm_ibfk_1` FOREIGN KEY (`IdAseguradora_gm`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_ee`
--
ALTER TABLE `tbl_reclamos_ee`
  ADD CONSTRAINT `tbl_reclamos_ee_ibfk_1` FOREIGN KEY (`IdPolizaRcl_ee`) REFERENCES `tbl_equipo_electronico` (`NoPoliza_ee`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_gm`
--
ALTER TABLE `tbl_reclamos_gm`
  ADD CONSTRAINT `tbl_reclamos_gm_ibfk_1` FOREIGN KEY (`IdPolizaRcl_gm`) REFERENCES `tbl_gastos_medicos` (`NoPoliza_gm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_vd`
--
ALTER TABLE `tbl_reclamos_vd`
  ADD CONSTRAINT `tbl_reclamos_vd_ibfk_1` FOREIGN KEY (`IdPolizaRcl_vd`) REFERENCES `tbl_vida` (`NoPoliza_vd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_vhl`
--
ALTER TABLE `tbl_reclamos_vhl`
  ADD CONSTRAINT `tbl_reclamos_vhl_ibfk_1` FOREIGN KEY (`IdPolizaRcl_vhl`) REFERENCES `tbl_vehiculos` (`NoPoliza_vhl`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_vd`
--
ALTER TABLE `tbl_vd`
  ADD CONSTRAINT `tbl_vd_ibfk_1` FOREIGN KEY (`IdAseguradora_vd`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_vehiculos`
--
ALTER TABLE `tbl_vehiculos`
  ADD CONSTRAINT `tbl_vehiculos_ibfk_2` FOREIGN KEY (`IdCliente_vhl`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_vehiculos_ibfk_3` FOREIGN KEY (`IdAseguradora_vhl`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_vhl`
--
ALTER TABLE `tbl_vhl`
  ADD CONSTRAINT `tbl_vhl_ibfk_1` FOREIGN KEY (`IdAseguradora_vhl`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_vida`
--
ALTER TABLE `tbl_vida`
  ADD CONSTRAINT `tbl_vida_ibfk_3` FOREIGN KEY (`IdAseguradora_vd`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_vida_ibfk_4` FOREIGN KEY (`idCLiente_vd`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
