-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2020 a las 04:59:24
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `opc3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('user1', 'ROLE_ADMIN'),
('user2', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `empresa` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `password`, `email`, `empresa`, `enabled`) VALUES
('user1', '1234', 'Luis63@nearbpo.com', 'xd', 1),
('user2', '1234', 'Lourdes_Chapa@corpfo', 'f', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `authorities`
--
ALTER TABLE `authorities`
  ADD KEY `fk_authorities_users` (`username`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `usuario` (`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
