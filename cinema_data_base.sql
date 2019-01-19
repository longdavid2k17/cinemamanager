-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 19 Sty 2019, 22:58
-- Wersja serwera: 10.1.35-MariaDB
-- Wersja PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `cinema`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `harmonogram`
--

CREATE TABLE `harmonogram` (
  `id_filmu` int(11) NOT NULL,
  `nazwa_filmu` varchar(35) NOT NULL,
  `sale_id` int(11) NOT NULL,
  `godzina` time(5) NOT NULL,
  `iloscSprzedanychBiletow` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `harmonogram`
--

INSERT INTO `harmonogram` (`id_filmu`, `nazwa_filmu`, `sale_id`, `godzina`, `iloscSprzedanychBiletow`) VALUES
(1, 'Planeta Singli 2', 2, '20:30:00.00000', 90),
(2, 'Venom 3D', 3, '18:15:00.00000', 135),
(3, 'Kler', 4, '19:45:00.00000', 80),
(4, 'Dywizjon 303', 1, '22:00:00.00000', 44);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sale`
--

CREATE TABLE `sale` (
  `id_sale` int(11) NOT NULL,
  `numer_sali` int(11) NOT NULL,
  `nazwa_sali` varchar(20) NOT NULL,
  `pojemnoscSali` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `sale`
--

INSERT INTO `sale` (`id_sale`, `numer_sali`, `nazwa_sali`, `pojemnoscSali`) VALUES
(1, 1, 'Sala 1', 100),
(2, 2, 'Sala 2', 150),
(3, 3, 'Sala 3', 100),
(4, 4, 'Sala 4', 150),
(8, 8, 'Sala 8', 150);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `harmonogram`
--
ALTER TABLE `harmonogram`
  ADD PRIMARY KEY (`id_filmu`),
  ADD UNIQUE KEY `nazwa_filmu` (`nazwa_filmu`);

--
-- Indeksy dla tabeli `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`id_sale`),
  ADD UNIQUE KEY `numer_sali` (`numer_sali`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
