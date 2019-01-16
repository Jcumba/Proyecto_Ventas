
update Productos set est_prod ='A';

use Ventas;

delete from clientes;

insert into Productos(nom_product,costo_product,peso_product,est_prod) values ('Cloruro de Potasio',100.00,'50 kg','A');
insert into Productos(nom_product,costo_product,peso_product,est_prod) values ('Nitrato de Amonio',100.00,'50 kg','A');
insert into Productos(nom_product,costo_product,peso_product,est_prod) values ('Urea Agricola',150.00,'50 kg','A');
insert into Productos(nom_product,costo_product,peso_product,est_prod) values ('Acido Fosforico',120.00,'50 kg','A');
insert into Productos(nom_product,costo_product,peso_product,est_prod) values ('Acido Borico',210.00,'50 kg','A');
insert into Productos(nom_product,costo_product,peso_product,est_prod) values ('Sulfato de Calcio',310.00,'50 kg','A');

insert into clientes(nom_client,ape_client,telf_client,email_client,est_cli) values('Jovana','Lira Ormeño','994110354','jovalan14@outlook.com','A');
insert into clientes(nom_client,ape_client,telf_client,email_client,est_cli) values('Jose','Ortiz Montoya','954630010','jortizm@hotmail.com','A');
insert into clientes(nom_client,ape_client,telf_client,email_client,est_cli) values('Juanito','Perez Sanchez','996533204','juanitops@hotmail.com','A');
insert into clientes(nom_client,ape_client,telf_client,email_client,est_cli) values('Stefano','Lucana Moran','994604512','slmoran@outlook.com','A');
insert into clientes(nom_client,ape_client,telf_client,email_client,est_cli) values('Jorge','Ayaucan Molina','975036418','jorge14_am@hotmail.com','A');




insert into Usuarios (usuario,nombres,pwd_us,nivel) values('admin','José Cumba Gamboa','admin',1);
insert into Usuarios (usuario,nombres,pwd_us,nivel) values('Gvalencia','Giancarlos Valencia','1234',2);
insert into Usuarios (usuario,nombres,pwd_us,nivel) values('Jcanales','Jesús Canales','1234',2);

insert into Almacen (cantida_ini,cod_productos,cantidad_fin) values ('6','2','2');


select * from Usuarios;


create proc ini
@producto integer,
@cantidad integer
as
update Almacen set cantidad_fin = @cantidad where cod_productos= @producto;

exec ini 2,2


create procedure uno
@last varchar(2)
as
update Almacen set total_can = cantida_ini- cantidad_fin where cod_productos=@last;

exec uno 2

create procedure dos
@last varchar(2)
as
update Almacen set cantidad_fin = '0' where cod_productos=@last;

exec dos 2

create proc tres
@last varchar(2)
as
update Almacen set cantida_ini = total_can  where cod_productos=@last;


exec tres 2




select * from Almacen

/*use ventas;
--select * from usuarios where usuario = 'admin' and pwd_us='admin';

select * from Ventas;*/
