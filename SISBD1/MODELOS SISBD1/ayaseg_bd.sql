-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-09-2018 a las 04:47:37
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.8

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
-- Estructura de tabla para la tabla `tbl_aseguradora`
--

CREATE TABLE `tbl_aseguradora` (
  `IdAseguradora` int(20) NOT NULL,
  `Nombre_as` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Nit_as` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Direccion_as` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Telefonos_as` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `IdContacto_as` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_beneficiarios`
--

CREATE TABLE `tbl_beneficiarios` (
  `NoPolizaVd_bfs` int(20) NOT NULL,
  `IdBeneficiario_bfs` int(20) NOT NULL,
  `Parentesco_bfs` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `IdPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_familiares`
--

CREATE TABLE `tbl_familiares` (
  `IdCliente_fm` int(50) NOT NULL,
  `IdFamiliar` int(50) NOT NULL,
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_persona`
--

CREATE TABLE `tbl_persona` (
  `IdPersona` int(20) NOT NULL,
  `NombreCompleto_bfo` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `FechaNacimiento_bfo` date NOT NULL,
  `Dpi_bfo` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_ee`
--

CREATE TABLE `tbl_reclamos_ee` (
  `IdReclamo_ee` int(20) NOT NULL,
  `IdPolizaRcl_ee` int(20) NOT NULL,
  `FechaRcl_ee` date NOT NULL,
  `CleinteRcl_ee` varchar(200) NOT NULL,
  `TipoPolizaRcl_ee` varchar(20) NOT NULL,
  `DescripcionRcl_ee` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_gm`
--

CREATE TABLE `tbl_reclamos_gm` (
  `IdReclamo_gm` int(20) NOT NULL,
  `IdPolizaRcl_gm` int(20) NOT NULL,
  `FechaRcl_gm` date NOT NULL,
  `CleinteRcl_gm` varchar(200) NOT NULL,
  `TipoPolizaRcl_gm` varchar(20) NOT NULL,
  `DescripcionRcl_gm` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_vd`
--

CREATE TABLE `tbl_reclamos_vd` (
  `IdReclamo_vd` int(20) NOT NULL,
  `IdPolizaRcl_vd` int(20) NOT NULL,
  `FechaRcl_vd` date NOT NULL,
  `CleinteRcl_vd` varchar(200) NOT NULL,
  `TipoPolizaRcl_vd` varchar(20) NOT NULL,
  `DescripcionRcl_vd` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reclamos_vhl`
--

CREATE TABLE `tbl_reclamos_vhl` (
  `IdReclamo_vhl` int(20) NOT NULL,
  `IdPolizaRcl_vhl` int(20) NOT NULL,
  `FechaRcl_vhl` date NOT NULL,
  `CleinteRcl_vhl` varchar(200) NOT NULL,
  `TipoPolizaRcl_vhl` varchar(20) NOT NULL,
  `DescripcionRcl_vhl` text NOT NULL
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_vida`
--

CREATE TABLE `tbl_vida` (
  `idCLiente_vd` int(20) NOT NULL,
  `IdAseguradora_vd` int(20) NOT NULL,
  `NoPoliza_vd` int(20) NOT NULL,
  `FechaInicio_vd` date NOT NULL,
  `SumaAsegurada_vd` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Coberturas_vd` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `DescripcionCobertura_vd` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `Prima_vd` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `EstadoPoliza_vd` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

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
('Edgar', '321', 'User');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_aseguradora`
--
ALTER TABLE `tbl_aseguradora`
  ADD PRIMARY KEY (`IdAseguradora`),
  ADD KEY `IdContacto_inmediato` (`IdContacto_as`);

--
-- Indices de la tabla `tbl_beneficiarios`
--
ALTER TABLE `tbl_beneficiarios`
  ADD PRIMARY KEY (`NoPolizaVd_bfs`),
  ADD KEY `No_Poliza` (`NoPolizaVd_bfs`),
  ADD KEY `Id_beneficiario` (`IdBeneficiario_bfs`);

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
-- Indices de la tabla `tbl_persona`
--
ALTER TABLE `tbl_persona`
  ADD PRIMARY KEY (`IdPersona`);

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
-- Indices de la tabla `tbl_vehiculos`
--
ALTER TABLE `tbl_vehiculos`
  ADD PRIMARY KEY (`IdPolizaVhl`),
  ADD KEY `Id_clt` (`IdCliente_vhl`),
  ADD KEY `Id_clt_2` (`IdCliente_vhl`),
  ADD KEY `IdAseguradora_Vhl` (`IdAseguradora_vhl`),
  ADD KEY `NoPoliza_vhl` (`NoPoliza_vhl`);

--
-- Indices de la tabla `tbl_vida`
--
ALTER TABLE `tbl_vida`
  ADD PRIMARY KEY (`NoPoliza_vd`),
  ADD KEY `idCLiente` (`idCLiente_vd`),
  ADD KEY `ASEGURADORA_VD` (`IdAseguradora_vd`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_ee`
--
ALTER TABLE `tbl_reclamos_ee`
  MODIFY `IdReclamo_ee` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_gm`
--
ALTER TABLE `tbl_reclamos_gm`
  MODIFY `IdReclamo_gm` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_vd`
--
ALTER TABLE `tbl_reclamos_vd`
  MODIFY `IdReclamo_vd` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tbl_reclamos_vhl`
--
ALTER TABLE `tbl_reclamos_vhl`
  MODIFY `IdReclamo_vhl` int(20) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_aseguradora`
--
ALTER TABLE `tbl_aseguradora`
  ADD CONSTRAINT `tbl_aseguradora_ibfk_1` FOREIGN KEY (`IdContacto_as`) REFERENCES `tbl_contacto_aseguradora` (`Idcontacto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_beneficiarios`
--
ALTER TABLE `tbl_beneficiarios`
  ADD CONSTRAINT `BENEFICIARIO` FOREIGN KEY (`NoPolizaVd_bfs`) REFERENCES `tbl_vida` (`NoPoliza_vd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_ee`
--
ALTER TABLE `tbl_cobros_ee`
  ADD CONSTRAINT `POLIZA_EE` FOREIGN KEY (`NoPoliza_cbree`) REFERENCES `tbl_equipo_electronico` (`NoPoliza_ee`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_gm`
--
ALTER TABLE `tbl_cobros_gm`
  ADD CONSTRAINT `POLIZAGM` FOREIGN KEY (`NoPoliza_cbrgm`) REFERENCES `tbl_gastos_medicos` (`NoPoliza_gm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_vd`
--
ALTER TABLE `tbl_cobros_vd`
  ADD CONSTRAINT `tbl_cobros_vd_ibfk_1` FOREIGN KEY (`NoPoliza_cbrvd`) REFERENCES `tbl_vida` (`NoPoliza_vd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_cobros_vhl`
--
ALTER TABLE `tbl_cobros_vhl`
  ADD CONSTRAINT `VEHICULOS` FOREIGN KEY (`IdPolizaVhl_cbrvhl`) REFERENCES `tbl_vehiculos` (`IdPolizaVhl`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_cobros_vhl_ibfk_1` FOREIGN KEY (`NoPoliza_cbr`) REFERENCES `tbl_vehiculos` (`NoPoliza_vhl`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_equipo_electronico`
--
ALTER TABLE `tbl_equipo_electronico`
  ADD CONSTRAINT `ASEGURADORAEE` FOREIGN KEY (`IdAseguradora_ee`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `CLIENTE_EE` FOREIGN KEY (`IdCliente_ee`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_familiares`
--
ALTER TABLE `tbl_familiares`
  ADD CONSTRAINT `familiares` FOREIGN KEY (`NoPoliza_fm`) REFERENCES `tbl_gastos_medicos` (`NoPoliza_gm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_gastos_medicos`
--
ALTER TABLE `tbl_gastos_medicos`
  ADD CONSTRAINT `ASEGURADORA_GM` FOREIGN KEY (`IdAseguradora_gm`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_gastos_medicos_ibfk_1` FOREIGN KEY (`IdCliente_gm`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_persona`
--
ALTER TABLE `tbl_persona`
  ADD CONSTRAINT `BENEFICIARIO2` FOREIGN KEY (`IdPersona`) REFERENCES `tbl_beneficiarios` (`IdBeneficiario_bfs`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_ee`
--
ALTER TABLE `tbl_reclamos_ee`
  ADD CONSTRAINT `ee` FOREIGN KEY (`IdPolizaRcl_ee`) REFERENCES `tbl_equipo_electronico` (`NoPoliza_ee`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_gm`
--
ALTER TABLE `tbl_reclamos_gm`
  ADD CONSTRAINT `gm` FOREIGN KEY (`IdPolizaRcl_gm`) REFERENCES `tbl_gastos_medicos` (`NoPoliza_gm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_vd`
--
ALTER TABLE `tbl_reclamos_vd`
  ADD CONSTRAINT `tbl_reclamos_vd_ibfk_1` FOREIGN KEY (`IdPolizaRcl_vd`) REFERENCES `tbl_vida` (`NoPoliza_vd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_reclamos_vhl`
--
ALTER TABLE `tbl_reclamos_vhl`
  ADD CONSTRAINT `tbl_reclamos_vhl_ibfk_1` FOREIGN KEY (`IdPolizaRcl_vhl`) REFERENCES `tbl_vehiculos` (`IdPolizaVhl`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_vehiculos`
--
ALTER TABLE `tbl_vehiculos`
  ADD CONSTRAINT `ASEGURADORA_VHL` FOREIGN KEY (`IdAseguradora_vhl`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Cliente` FOREIGN KEY (`IdCliente_vhl`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_vida`
--
ALTER TABLE `tbl_vida`
  ADD CONSTRAINT `ASEGURADORA_VD` FOREIGN KEY (`IdAseguradora_vd`) REFERENCES `tbl_aseguradora` (`IdAseguradora`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_vida_ibfk_1` FOREIGN KEY (`idCLiente_vd`) REFERENCES `tbl_clientes` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
