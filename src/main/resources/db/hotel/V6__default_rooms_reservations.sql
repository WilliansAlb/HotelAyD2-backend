INSERT INTO adm_user (user_id,email, password, full_name, birthday) VALUES (1, 'yelbetto@gmail.com', '$2a$12$pqo20A.PHmMkOhvtOQOYNOOHFQnqIOhB40gp/Ri9vNhQ0k1N/Ay/2', 'Willians Alberto', '1998-07-21');

INSERT INTO htl_client (client_id, identification_no, first_name, middle_name, last_name, email, phone_number) VALUES (1,'2832048181007', 'Willians', 'Alberto', 'Orozco', 'yelbetto@gmail.com', '34980838');

INSERT INTO htl_room_type (room_type_id, room_type_name, number_of_beds, price) VALUES (1, 'Junior', 1, 100.000000);
INSERT INTO htl_room_type (room_type_id, room_type_name, number_of_beds, price) VALUES (2, 'Master', 3, 200.000000);
INSERT INTO htl_room_type (room_type_id, room_type_name, number_of_beds, price) VALUES (3, 'Lujo', 4, 500.000000);

INSERT INTO htl_room (room_id, room_type_id, room_code, htl_level) VALUES (1, 1, 'A1', 1);
INSERT INTO htl_room (room_id, room_type_id, room_code, htl_level) VALUES (2, 1, 'B1', 1);
INSERT INTO htl_room (room_id, room_type_id, room_code, htl_level) VALUES (3, 2, 'C1', 1);
INSERT INTO htl_room (room_id, room_type_id, room_code, htl_level) VALUES (4, 3, 'D1', 1);

INSERT INTO htl_reservation (reservation_id, client_id, room_id, entry_date, reservation_from, reservation_until, check_in_date, check_out_date, creator_user_id) VALUES (1, 1, 1, '2024-03-18', '2024-03-19', '2024-03-21', null, null, 1);
INSERT INTO htl_reservation (reservation_id, client_id, room_id, entry_date, reservation_from, reservation_until, check_in_date, check_out_date, creator_user_id) VALUES (2, 1, 1, '2024-03-22', '2024-03-22', '2024-03-30', null, null, 1);
