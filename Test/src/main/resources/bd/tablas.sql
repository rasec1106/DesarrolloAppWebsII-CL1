if not exists (select * from sysobjects where name='distrito' and xtype='U')
create table distrito (
    distrito_id int primary key,
    distrito_nombre varchar(255)
);