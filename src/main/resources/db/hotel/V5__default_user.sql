-- user
INSERT INTO public.adm_user (user_id, email, password, full_name, birthday) VALUES
(5001, 'admin@thegoodrest.dev', '$2a$10$9LyvZdw6cjgjJp7/T4aJfu1lH4wgNAwVlaj3vGFuUo/9XH.U5CScy', 'admin user', '2000-01-01');

-- role
INSERT INTO public.adm_user_role (user_role_id, role_id, user_id) VALUES
(5001, 5001, 5001);
