/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  revze
 * Created: Nov 27, 2015
 */
INSERT INTO catatan (id,judul,isi) VALUES
('1','Lorem Ipsum Dolor Sit Amet','Ini isi'),
('2','Lorem Ipsum Dolor Sit Amett','Ini isii');

INSERT INTO `c_security_role` (`id`,`nama`,`description`) VALUES
('admin','admin','Application Admin'),
('user','user','Application User');

INSERT INTO `c_security_permission` (`id`,`permission_label`,`permission_value`) VALUES
('catatan_update','Edit Catatan','ROLE_CATATAN_UPDATE'),
('catatan_view','View Catatan','ROLE_CATATAN_VIEW'),
('catatan_create','Create Catatan','ROLE_CATATAN_CREATE'),
('catatan_delete','Delete Catatan','ROLE_CATATAN_DELETE'),
('user_view','View User','ROLE_USER_VIEW');

INSERT INTO `c_security_role_permission` (`id_role`,`id_permission`) VALUES
('admin','catatan_update'),
('admin','catatan_view'),
('admin','catatan_create'),
('admin','catatan_delete'),
('user','catatan_view'),
('user','user_view'),
('admin','user_view');

INSERT INTO `c_security_user` (`id`,`username`,`password`,`active`,`id_role`) VALUES
('1','admin','admin',true,'admin'),
('2','user','user',true,'user');