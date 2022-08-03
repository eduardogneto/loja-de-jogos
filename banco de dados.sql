-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.24-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para db_lojadejogos
CREATE DATABASE IF NOT EXISTS `db_lojadejogos` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_lojadejogos`;

-- Copiando estrutura para tabela db_lojadejogos.dados_jogos
CREATE TABLE IF NOT EXISTS `dados_jogos` (
  `jogo_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome_jogo` varchar(200) NOT NULL,
  `data_lancamento` int(4) NOT NULL DEFAULT 0,
  `corredor` char(1) NOT NULL,
  `jogo_preco` float NOT NULL DEFAULT 0,
  `categoria_jogo` varchar(500) NOT NULL,
  `desenvolvedora_jogo` char(200) NOT NULL,
  `estoque` int(200) NOT NULL DEFAULT 0,
  PRIMARY KEY (`jogo_codigo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela db_lojadejogos.dados_jogos: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `dados_jogos` DISABLE KEYS */;
REPLACE INTO `dados_jogos` (`jogo_codigo`, `nome_jogo`, `data_lancamento`, `corredor`, `jogo_preco`, `categoria_jogo`, `desenvolvedora_jogo`, `estoque`) VALUES
	(1, 'Haunted House', 2022, 'B', 299.99, 'Terror', 'Uude Company', 220),
	(2, 'bbbbbbbbbbb', 2, 'C', 2, 'bbbbbbbbbbb', 'bbbbbbbbbb', 22),
	(3, 'God Of War', 2020, 'D', 250, 'Acao', 'Null', 22);
/*!40000 ALTER TABLE `dados_jogos` ENABLE KEYS */;

-- Copiando estrutura para tabela db_lojadejogos.dados_senhas
CREATE TABLE IF NOT EXISTS `dados_senhas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela db_lojadejogos.dados_senhas: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `dados_senhas` DISABLE KEYS */;
REPLACE INTO `dados_senhas` (`id`, `usuario`, `senha`) VALUES
	(1, 'uude', '123'),
	(2, 'admin', '1234'),
	(3, 'Diogo', 'rato'),
	(4, 'root', '123'),
	(5, 'uude', '123'),
	(6, 'luis', 'teste2');
/*!40000 ALTER TABLE `dados_senhas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
