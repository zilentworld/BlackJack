
CREATE TABLE account_sequence
(
  account_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT
);
CREATE TABLE bet
(
  bet_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bet_amount INT(11)
);
CREATE TABLE chip
(
  chip_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  chip_desc VARCHAR(20),
  chip_amount INT(11)
);
CREATE TABLE dealer
(
  dealer_id BIGINT(20) PRIMARY KEY NOT NULL,
  username VARCHAR(50),
  password VARCHAR(50)
);
CREATE TABLE game
(
  game_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  room_id BIGINT(20)
);
CREATE TABLE player
(
  player_id BIGINT(20) PRIMARY KEY NOT NULL,
  username VARCHAR(50),
  password VARCHAR(50),
  total_chip_amount INT(11)
);
CREATE TABLE room
(
  room_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dealer_id BIGINT(20),
  game_id BIGINT(20)
);
CREATE TABLE round
(
  round_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bet_amount INT(11)
);
CREATE TABLE round_card_list
(
  round_card_list_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  round_id BIGINT(20),
  card_symbol VARCHAR(5)
);