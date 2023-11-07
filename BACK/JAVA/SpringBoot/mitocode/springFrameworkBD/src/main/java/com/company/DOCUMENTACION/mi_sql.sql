-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.28 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para springframework_mitocode_bd
CREATE DATABASE IF NOT EXISTS `springframework_mitocode_bd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `springframework_mitocode_bd`;

-- Volcando estructura para tabla springframework_mitocode_bd.camiseta
CREATE TABLE IF NOT EXISTS `camiseta` (
  `id` smallint NOT NULL,
  `numero` tinyint NOT NULL,
  `idMarca` smallint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idMarca` (`idMarca`),
  CONSTRAINT `FK_Camiseta_Marca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla springframework_mitocode_bd.camiseta: ~0 rows (aproximadamente)
REPLACE INTO `camiseta` (`id`, `numero`, `idMarca`) VALUES
	(1, 10, 1);

-- Volcando estructura para tabla springframework_mitocode_bd.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `id` int NOT NULL DEFAULT (0),
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla springframework_mitocode_bd.equipo: ~2 rows (aproximadamente)
REPLACE INTO `equipo` (`id`, `nombre`) VALUES
	(1, 'Brasil'),
	(2, 'Barcelona FC'),
	(3, 'Juventus');

-- Volcando estructura para tabla springframework_mitocode_bd.jugador
CREATE TABLE IF NOT EXISTS `jugador` (
  `id` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `idEquipo` int NOT NULL DEFAULT (0),
  `idCamiseta` smallint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEquipo` (`idEquipo`),
  KEY `idCamiseta` (`idCamiseta`),
  CONSTRAINT `FK_Jugador_Camiseta` FOREIGN KEY (`idCamiseta`) REFERENCES `camiseta` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Jugador_Equipo` FOREIGN KEY (`idEquipo`) REFERENCES `equipo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla springframework_mitocode_bd.jugador: ~0 rows (aproximadamente)
REPLACE INTO `jugador` (`id`, `nombre`, `idEquipo`, `idCamiseta`) VALUES
	(1, 'Ronaldinho Gaúcho', 1, 1);

-- Volcando estructura para tabla springframework_mitocode_bd.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` smallint NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla springframework_mitocode_bd.marca: ~0 rows (aproximadamente)
REPLACE INTO `marca` (`id`, `nombre`) VALUES
	(1, 'Adiddas');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
