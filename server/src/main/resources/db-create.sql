CREATE TABLE account
(
    account_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    total_chips INT(11),
    is_player INT(11),
    is_dealer INT(11),
    is_admin INT(11)
);
CREATE TABLE game
(
    game_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    room_id BIGINT(20),
    dealer_id INT(11)
);
CREATE TABLE game_deck
(
    deck_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    game_id BIGINT(20),
    full_deck VARCHAR(10000),
    deck_size INT(11)
);
CREATE TABLE room
(
    room_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dealer_id BIGINT(20),
    round_count INT(11),
    create_time TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    leave_time TIMESTAMP
);
CREATE TABLE room_player_list
(
    room_list_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    room_id BIGINT(20),
    player_id BIGINT(20)
);
CREATE TABLE round
(
    round_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    game_id BIGINT(20),
    dealer_id BIGINT(20)
);
CREATE TABLE round_dealer_cards
(
    round_card_list_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    round_id BIGINT(20),
    card_symbol VARCHAR(5),
    dealer_id BIGINT(20)
);
CREATE TABLE round_player
(
    round_player_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    round_id BIGINT(20),
    player_id BIGINT(20)
);
CREATE TABLE round_player_card_hand
(
    round_card_hand_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    round_player_id BIGINT(20),
    bet_amount INT(11),
    card_hand_status VARCHAR(20),
    card_hand_count INT(11)
);
CREATE TABLE round_player_cards
(
    round_card_list_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    round_card_hand_id BIGINT(20),
    card_symbol VARCHAR(5),
    round_player_id BIGINT(20)
);