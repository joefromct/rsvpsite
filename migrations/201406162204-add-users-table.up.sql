
create table party  ( 
    id                serial       not null,  
    party_name        varchar(100) not null,  
    email_address     varchar(500) not null,  
    estimated_number_in_party integer not null default 2 , 
    country           varchar(5  ) not null,  
    city              varchar(100) not null,  
    state             varchar(100) not null,  
    postal_code       varchar(100) not null,  
    mailing_address_1 varchar(100) not null,  
    mailing_address_2 varchar(100) not null,  
    mailing_address_3 varchar(100) not null, /* wtf is norfolk? */  
    flag_sent_mail    timestamp        null,  
    flag_accepted     timestamp        null,  
    secret_word       varchar(100) not null,  
    primary key (id)
) ;  


insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Jeff Szymanski'       , 'nicole.baumann@aol.com'      , '33 Parsons Road       ' , ''                   , ''                  , 'Enfield'  , 'CT' , 'USA' , '06082'  ,'hanker conserve pears'   ); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Jim Baumann'          , 'jimbaumann@me.com'           , 'P.O. Box 600873       ' , ''                   , ''                  , 'Dallas'   , 'TX' , 'USA' , '75360'  ,'suberin doghouse setting'); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Elizabeth Campanelli' , 'eacarlson@yahoo.com'         , '11 Standish Street    ' , ''                   , ''                  , 'Enfield'  , 'CT' , 'USA' , '06082'  ,'ammeter indite curriery' ); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Nicole Michaud'       , 'nmichaud79@gmail.com'        , '26 Ohear Avenue       ' , ''                   , ''                  , 'Enfield'  , 'CT' , 'USA' , '06082'  ,'whoop gambado fiasco'    ); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Joyce Daniels'        , 'joyce.daniels1234@gmail.com' , '40 Albany Road        ' , ''                   , ''                  , 'Norwich'  , ''   , 'UK'  , 'NR31EE' ,'bunting treenail teacart'); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Rosy Daniels'         , 'rosyapple30@live.co.uk'      , '11 Waterloo Road      ' , ''                   , ''                  , 'Norwich'  , ''   , 'UK'  , 'NR31EH' ,'cookout emitter trass'   ); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Katy Daniels'         , 'katydaniels17@hotmail.com'   , '36 Salisbury Place    ' , 'Langton road      ' , 'Oval'              , 'London'   , ''   , 'UK'  , 'SW96UW' ,'prickle chicle sinkage'  ); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Meenaa Azmayesh'      , 'meenaa.azmayesh@dentons.com' , 'Flat 109              ' , 'Arlington Building' , '60 Fairfield Road' , 'London'   , ''   , 'UK'  , 'E32UB'  ,'phosgene balboa loci'    ); 
insert into party (party_name, email_address, mailing_address_1, mailing_address_2, mailing_address_3, city, state, country, postal_code, secret_word) values ('Tamara Addis'         , 'tammytimothy@hotmail.com'    , '2 Candie Apartments   ' , ' Candie Road      ' , 'St Peter Port'     , 'Guernsey' , ''   , 'UK'  , 'GY11UQ' ,'accord coke scincoid'    ); 

create table guest_detail ( 
    id              serial  not null, 
    party_id        integer  not null ,
    guest_id serial   not null , 
    table_number    smallint null, 
    entree_id       smallint null,
    dietary_requirements varchar(4000) ,
    primary key ( party_id, id)
) ; 

create table entree ( 
    id                 serial  not null ,  
    entree_name        varchar(100)  not null default '' ,    
    entree_description varchar(100) not null default ''     , 
    primary key ( id) 
); 

insert into entree (entree_name, entree_description ) values ('chicken stuff','chicken stir fry') ; 
insert into entree (entree_name, entree_description ) values ('beef stuff','beef stir fry') ; 



ALTER TABLE guest_detail ADD FOREIGN KEY (party_id) REFERENCES party (id) ON UPDATE NO ACTION ON DELETE NO ACTION;  

ALTER TABLE guest_detail ADD FOREIGN KEY (entree_id) REFERENCES entree (id)     ON UPDATE NO ACTION ON DELETE NO ACTION;  



