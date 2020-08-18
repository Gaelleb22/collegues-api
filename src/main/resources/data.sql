--collègues
insert into collegue(matricule, nom, prenoms, email, date_naissance, photo_url) values ('770656e506974ab9b3f561243ad6ab31', 'Yuki', 'Shiro', 'shiro.yuki@mail.jp', '2014-12-31', './assets/renard.JPG');
insert into collegue(matricule, nom, prenoms, email, date_naissance, photo_url) values ('0695440a6cf745488d87ef755318c518', 'Au-Bois-Dormant', 'Aurore', 'belle@mail.pl', '1975-06-15', './assets/aurore.JPG');
insert into collegue(matricule, nom, prenoms, email, date_naissance, photo_url) values ('5ed7555ae74d46af9a221f6f4e5a5681', 'Antoine', 'Marc', 'marco@mail.ro', '1962-09-30', './assets/marc.JPG');
insert into collegue(matricule, nom, prenoms, email, date_naissance, photo_url) values ('eca4db5496fd428a8ae4749d720f65d9', 'Napo', 'Léon', 'waterloo@mail.ef', '1988-06-18', './assets/léon.JPG');
insert into collegue(matricule, nom, prenoms, email, date_naissance, photo_url) values ('88495ff48612456faadc4c79eaf26cfd', 'Lao', 'Tseu', 'taoisme@mail.ch', '1979-04-03', './assets/lao.JPG');
insert into collegue(matricule, nom, prenoms, email, date_naissance, photo_url) values ('a4ecd58e13fd42188010918315772095', 'Premier', 'Soliman', 'le.magnifique@mail.tu', '1994-11-06', './assets/soliman.JPG');

--Notes
insert into note(uuid, collegue_uuid, date_saisie, note) values ('b70b0f7807fc4023becc0499784ada7c', '770656e506974ab9b3f561243ad6ab31', '2020-08-18', 'Aime la neige');
insert into note(uuid, collegue_uuid, date_saisie, note) values ('0ec3264dc4334bf1b54cc5041a871215', '0695440a6cf745488d87ef755318c518', '2020-08-18', 'Difficile à réveiller');
insert into note(uuid, collegue_uuid, date_saisie, note) values ('3e2d27054b5e4a4e8c4eb5fdf4a0e757 ', '5ed7555ae74d46af9a221f6f4e5a5681', '2020-08-18', 'Ambitieux');
insert into note(uuid, collegue_uuid, date_saisie, note) values ('3fe484419b4847d38c251892794124b5', 'eca4db5496fd428a8ae4749d720f65d9', '2020-08-18', 'Est mort à Sainte-Hélène');
insert into note(uuid, collegue_uuid, date_saisie, note) values ('6e5468b9d22845448c9296b2c14a6230 ', '88495ff48612456faadc4c79eaf26cfd', '2020-08-18', 'Fais preuve de philosophie');
insert into note(uuid, collegue_uuid, date_saisie, note) values ('63e015d42d854041905eee0261687001', 'a4ecd58e13fd42188010918315772095', '2020-08-18', 'Veut toujours diriger');