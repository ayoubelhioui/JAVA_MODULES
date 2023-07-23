INSERT INTO "User" (login, password)
VALUES ('ael-hiou', '123456');
INSERT INTO "User" (login, password)
VALUES ('klaarous', '1234569834');
INSERT INTO "User" (login, password)
VALUES ('hnaciri', 'ksdjf33');
INSERT INTO "User" (login, password)
VALUES ('mel-amma', '12io12d');
INSERT INTO Room (name, owner)
VALUES ('Room 1', 1);
INSERT INTO Room (name, owner)
VALUES ('Room 10', 2);
INSERT INTO Room (name, owner)
VALUES ('Room 111', 3);
INSERT INTO Room (name, owner)
VALUES ('Room 12', 4);
INSERT INTO Message (text, datetime, author, room)
VALUES ('helloWorld', '2022-12-01 15:30:45', 1, 1);
INSERT INTO Message (text, datetime, author, room)
VALUES ('fuck you mlakhar', '2022-07-01 11:10:45', 1, 3);
INSERT INTO Message (text, datetime, author, room)
VALUES ('helloWorld', '2023-12-01 10:00:00', 2, 2);
INSERT INTO Message (text, datetime, author, room)
VALUES ('shnifiha asi mohamed', '2013-01-09 09:10:22', 1, 2);












-- delete from public."game";
-- delete from public."user";
--
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '1'::integer, 'aben-ham'::character varying, 'avatar'::character varying, '8'::integer, '6'::integer, '14'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '2'::integer, 'ael-hiou'::character varying, 'avatar'::character varying, '0'::integer, '0'::integer, '11'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '3'::integer, 'klaarous'::character varying, 'avatar'::character varying, '1'::integer, '5'::integer, '2'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '4'::integer, 'hnaciri'::character varying, 'avatar'::character varying, '0'::integer, '6'::integer, '4'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '5'::integer, 'mel-amma'::character varying, 'avatar'::character varying, '7'::integer, '4'::integer, '9'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '5'::integer, 'mmounib'::character varying, 'avatar'::character varying, '11'::integer, '85'::integer, '21'::integer, false::boolean)
--     returning id;

--  -- game null time (lives)
--  INSERT INTO public.game (
-- player1_score, player2_score, type, "player1Id", "player2Id") VALUES (
-- '10'::integer, '12'::integer, true::boolean, '17'::integer, '19'::integer)
--  returning token;

--   INSERT INTO public.game (
--  player1_score, player2_score, type, "player1Id", "player2Id") VALUES (
-- '10'::integer, '7'::integer, true::boolean, '18'::integer, '20'::integer)
--  returning token;

--  INSERT INTO public.game (
-- player1_score, player2_score, "match-end-time,type", "player1Id", "player2Id") VALUES (
-- '10'::integer, '12'::integer, '2022-12-1 15:30:45',true::boolean, '2'::integer, '3'::integer)
--  returning token;


-- cd ~/goinfre/js/ft_transcendence/backend/postgresql
-- docker exec -it my-postgresql bash
-- psql -h localhost -p 5432 -U postgres
-- \c mydb2
-- delete from public."game";
-- delete from public."user";
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '1'::integer, 'aben-ham'::character varying, 'avatar'::character varying, '8'::integer, '6'::integer, '14'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '2'::integer, 'ael-hiou'::character varying, 'avatar'::character varying, '0'::integer, '0'::integer, '11'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '3'::integer, 'klaarous'::character varying, 'avatar'::character varying, '1'::integer, '5'::integer, '2'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '4'::integer, 'hnaciri'::character varying, 'avatar'::character varying, '0'::integer, '6'::integer, '4'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '5'::integer, 'mel-amma'::character varying, 'avatar'::character varying, '7'::integer, '4'::integer, '9'::integer, false::boolean)
--     returning id;
--
-- INSERT INTO public."user" ("IntraId", username, avatar, wins, loss, winrate, two_factors_enabled) VALUES (
--                                                                                                              '5'::integer, 'mmounib'::character varying, 'avatar'::character varying, '11'::integer, '85'::integer, '21'::integer, false::boolean)
--     returning id;
--
-- --  -- game null time (lives)
-- INSERT INTO public.game (
--     player1_score, player2_score, type, "player1Id", "player2Id") VALUES (
--                                                                              '10'::integer, '12'::integer, true::boolean, '17'::integer, '19'::integer)
--     returning token;
--
-- INSERT INTO public.game (
--     player1_score, player2_score, type, "player1Id", "player2Id") VALUES (
--                                                                              '10'::integer, '7'::integer, true::boolean, '18'::integer, '20'::integer)
--     returning token;
--
-- INSERT INTO public.game (
--     player1_score, player2_score, "match-end-time,type", "player1Id", "player2Id") VALUES (
--                                                                                               '10'::integer, '12'::integer, '2022-12-1 15:30:45',true::boolean, '2'::integer, '3'::integer)
--     returning token;