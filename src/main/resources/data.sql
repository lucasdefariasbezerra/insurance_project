CREATE TABLE DRIVER (
    id integer not null primary key,
    document varchar(11) not null,
    birthdate varchar(10) not null
);

CREATE TABLE CAR (
   id integer not null primary key,
   model varchar(20),
   manufacturer varchar(15),
   "year" varchar(4),
   fipe_value decimal(10,2)
);

CREATE TABLE CUSTOMER (
  id integer not null primary key,
  name varchar(70),
  driver_id integer not null,
  CONSTRAINT ct_driver_idfk FOREIGN KEY (driver_id) REFERENCES DRIVER (id)
);

CREATE TABLE CAR_DRIVER (
    id integer not null primary key,
    driver_id integer not null,
    car_id integer not null,
    is_main_driver boolean not null,
    CONSTRAINT cd_driver_idfk FOREIGN KEY (driver_id) REFERENCES DRIVER (id),
    CONSTRAINT cd_car_idfk FOREIGN KEY (car_id) REFERENCES CAR (id)
);

CREATE TABLE CLAIM (
  id integer not null primary key,
  driver_id integer not null,
  car_id integer not null,
  event_date date not null,
  CONSTRAINT cl_driver_idfk FOREIGN KEY (driver_id) REFERENCES DRIVER (id),
  CONSTRAINT cl_car_idfk FOREIGN KEY (car_id) REFERENCES CAR (id)
);


CREATE TABLE INSURANCE (
  id integer not null primary key,
  customer_id integer not null,
  creation_dt timestamp not null,
  updated_dt timestamp,
  car_id integer not null,
  is_active boolean not null,
  CONSTRAINT in_customer_idfk FOREIGN KEY (customer_id) REFERENCES CUSTOMER (id),
  CONSTRAINT in_car_idfk FOREIGN KEY (car_id) REFERENCES CAR (id)
);

