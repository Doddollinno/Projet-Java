SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `boulderdash`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllExamples` ()  NO SQL
SELECT id, name
FROM example$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findExampleByName` (IN `name` VARCHAR(255))  NO SQL
SELECT id, name
FROM example
WHERE example.name = name$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getMapByID` (IN `id` INT)  NO SQL
SELECT * FROM map WHERE `Id` = `id`$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

CREATE TABLE `map` (
  `Id` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `map` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `map`
--

INSERT INTO `map` (`Id`, `width`, `height`, `map`) VALUES
(1, 8, 8, '########\n#......#\n#.   V.#\n#. M  .#\n#.    .#\n#.   M.#\n#..V...#\n########\n'),
(2, 10, 8, '##########\n#........#\n#........#\n#........#\n#........#\n#........#\n#..V.....#\n##########\n'),
(3, 26, 24, '##########################\n#......#.....V...........#\n#......#.................#\n#......#.................#\n#......#.................#\n#......#.................#\n#......#.................#\n#......#.......###########\n#........................#\n#........................#\n#........................#\n#........................#\n#........................#\n#........................#\n#........................#\n##########.......#.......#\n#................#.......#\n#................#.......#\n#................#.......#\n#................#.......#\n#................#.......#\n#.........V......#.......#\n#......V.........#.......#\n##########################\n'),
(4, 4, 24, '####\n#..#\n#.M#\n#..#\n#..#\n#.V#\n#..#\n#..#\n#..#\n#..#\n#V.#\n#..#\n#..#\n#..#\n#..#\n#..#\n#.V#\n#..#\n#..#\n#..#\n#.V#\n#..#\n#..#\n####\n'),
(5, 26, 24, '##########################\n#........................#\n#........................#\n#...#.#.###.#...#...###..#\n#...#.#.#...#...#...#.#..#\n#...###.###.#...#...#.#..#\n#...#.#.#...#...#...#.#..#\n#...#.#.###.###.###.###..#\n#........................#\n#..#..#.###.###.#...##...#\n#..#..#.#.#.#.#.#...#.#..#\n#..#..#.#.#.##..#...#.#..#\n#..####.#.#.#.#.#...#.#..#\n#..#..#.###.#.#.###.##...#\n#...........M............#\n#........................#\n#........................#\n#........................#\n#...........V............#\n#........................#\n#........................#\n#........................#\n#...........V............#\n##########################\n');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
