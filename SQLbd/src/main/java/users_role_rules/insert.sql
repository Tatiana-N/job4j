insert into new_bd.public.category (name) values ('first_category');
insert into new_bd.public.category (name) values ('second_category');
insert into new_bd.public.category (name) values ('third_category');
insert into new_bd.public.state (name) values ('принят');
insert into new_bd.public.state (name) values ('обработан');
insert into new_bd.public.state (name) values ('выполнен');
insert into new_bd.public.role(name) values ('администратор');
insert into new_bd.public.role(name) values ('пользователь');
insert into new_bd.public.role(name) values ('системный администратор');
insert into new_bd.public.rules(name) values ('какое-то правило 1');
insert into new_bd.public.rules(name) values ('какое-то правило 2');
insert into new_bd.public.rules(name) values ('какое-то правило 3');
insert into new_bd.public.users (name, role_id) values ('Tom',1);
insert into new_bd.public.users (name, role_id) values ('Tim',3);
insert into new_bd.public.item (name, users_id, category_id, state_id) values ('order 2',1,3,3);
insert into new_bd.public.item (name, users_id, category_id, state_id) values ('order 2',2,1,3);
insert into new_bd.public.attaches  ( name, item_id) values ('прикреплять что? ',1);