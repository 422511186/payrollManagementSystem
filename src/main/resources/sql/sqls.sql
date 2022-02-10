create table if not exists employee_information
(
	id int auto_increment
		primary key,
	name char(15) not null,
	entry_time datetime not null
)
comment '员工信息表';

create index employee_information_id_index
	on employee_information (id);

create table if not exists salary_setting
(
	Position char(20) not null,
	salary double not null,
	constraint salary_setting_Position_uindex
		unique (Position)
);

create index salary_setting_Position_index
	on salary_setting (Position);

alter table salary_setting
	add primary key (Position);

create table if not exists payroll
(
	payroll_id int auto_increment,
	employee_id int not null
		primary key,
	Position char(20) not null,
	constraint payroll_pk
		unique (payroll_id),
	constraint payroll_employee_information__fk
		foreign key (employee_id) references employee_information (id),
	constraint payroll_salary_setting_Position_fk
		foreign key (Position) references salary_setting (Position)
)
comment '工资表';

create table if not exists user
(
	id int auto_increment,
	account char(11) not null,
	password char(16) not null,
	constraint user_acount_uindex
		unique (account),
	constraint user_id_uindex
		unique (id)
);

# alter table user
# 	add primary key (id);

