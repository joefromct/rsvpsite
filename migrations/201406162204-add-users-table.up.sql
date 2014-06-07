create table party  ( 
    id                serial       not null,  
    party_name        varchar(100) not null default '',  
    email_address     varchar(500) not null default '',  
    estimated_number_in_party integer not null default 2 , 
    country           varchar(50  ) not null default '',  
    city              varchar(100) not null default '',  
    state             varchar(100) not null default '',  
    postal_code       varchar(100) not null default '',  
    mailing_address_1 varchar(100) not null default '',  
    mailing_address_2 varchar(100) not null default '',  
    mailing_address_3 varchar(100) not null default '', /* wtf is norfolk? */  
    flag_sent_mail    timestamp        null,  
    flag_accepted     varchar(10)      null,  
    secret_word       varchar(100) not null default '',  
    primary key (id)
) ;  

insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Bob Baumann','','44 Brainard Road','Enfield','Connecticut','USA','06082','amber queen'         ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Charles Baumann        ','ctbfoo8@yahoo.com                                   ','36 Park Hill                                    ','Broad Brook   ','Connecticut   ','USA                 ','06016             ','tequila sunrise '    ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Charlie Baumann        ','ctbaumann@gmail.com                                 ','39 Llynwood Road                                ','Vernon        ','Connecticut   ','USA                 ','06066             ','blush noisette'      ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Marc Baumann           ','cathyb621@aol.com                                   ','129 Shaker Road                                 ','Enfield       ','Connecticut   ','USA                 ','06082             ','bright smile'        ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Jeff Szymanski         ','nicole.baumann@aol.com                              ','33 Parsons Road, Enfield                        ','Enfield       ','Connecticut   ','USA                 ','06082             ','blanche moreau '     ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Ernie Baumann          ','cathyb621@aol.com                                   ','129 Shaker Road                                 ','Enfield       ','Connecticut   ','USA                 ','06082             ','burgundy ice '       ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Jack Baumann           ','Jakb0108@gmail.com                                  ','7101 Winding Creek Road                         ','Dallas        ','Texas         ','USA                 ','75252              ','champagne cocktail '); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Jim Baumann            ','jimbaumann@me.com                                   ','P.O. Box 600873                                 ','Dallas        ','Texas         ','USA                 ','75360              ','champagne moment'   ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Tom Baumann            ','                                                    ','67 St. James Avenue                             ','Enfield       ','Connecticut   ','USA                 ','06082             ','chandos beauty '     ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Barry Carlson          ','janemcarlson@gmail.com                              ','148 East Grayling Lane                          ','Suffield      ','Connecticut   ','USA                 ','06078             ','cider cup '          ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Annie Carlson          ','Carlson.annem@gmail.com                             ','199 Brainard Road                               ','Enfield       ','Connecticut   ','USA                 ','06082             ','climbing iceberg  '  ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Anthony Campanelli     ','eacarlson@yahoo.com                                 ','11 Standish Street                              ','Enfield       ','Connecticut   ','USA                 ','06082             ','crimson cascade '    ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Jason Counts           ','sjcounts@gmail.com                                  ','245 Alps Road                                   ','Branford      ','Connecticut   ','USA                 ','06405             ','dancing queen '      ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Chris Jannelle         ','ChrisJans5@hotmail.com                              ','225 Broad Brook Road                            ','Enfield       ','Connecticut   ','USA                 ','06082             ','dawn chorus '        ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Bruce Gowdy            ','                                                    ','6 Wilson Court                                  ','Enfield       ','Connecticut   ','USA                 ','06082             ','double delight '     ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Art Reed               ','mariareed1764@cox.net                               ','10 Harris Street                                ','Enfield       ','Connecticut   ','USA                 ','06082             ','drama queen'         ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Fran Rochette          ','fran.rochette@gmail.com                             ','229 Rye Street                                  ','Broad Brook   ','Connecticut   ','USA                 ','06016             ','dublin bay '         ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Tim Rochette           ','timrochette@hotmail.com                             ','236 Rye Street                                  ','Broad Brook   ','Connecticut   ','USA                 ','06016             ','dusky maiden '       ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Mike Rochette          ','coach3925@aol.com                                   ','13 Orchard Hill Road                            ','Enfield       ','Connecticut   ','USA                 ','06082             ','english miss '       ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'David Rothe            ','linda.p.rothe@power.alstom.com                      ','227 Broad Brook Road                            ','Enfield       ','Connecticut   ','USA                 ','06082             ','flower power '       ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Matt Noto              ','mpnoto@gmail.com                                    ','123 Main Street                                 ','Somers        ','Connecticut   ','USA                 ','06071             ','garlands gold '      ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Pete DeForge           ','bmxpete@aol.com                                     ','16 Lancer Drive                                 ','Enfield       ','Connecticut   ','USA                 ','06082             ','high hopes '         ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Mike Howarth           ','Michael.Howarth@woodgroup.com                       ','11 Colton Road                                  ','Somers        ','Connecticut   ','USA                 ','06071             ','iced ginger '        ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Brian Magnuson         ','bdmagnuson@gmail.com                                ','42 6th Street                                   ','Medford       ','Massachussets ','USA                 ','02155             ','indian summer '      ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Kyle Tacy              ','ktacy9@gmail.com                                    ','95 Saint Nicholas Avenue                        ','Brooklyn      ','New York      ','USA                 ','11237              ','irish eyes '        ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Mike Michaud           ','nmichaud79@gmail.com                                ','26 Ohear Avenue                                 ','Enfield       ','Connecticut   ','USA                 ','06082             ','jacques cartier '    ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Joe Lloyd              ','joeylloyd@me.com, scottnavin@me.com                 ','                                                ','              ','Philadelphia  ','USA                 ','                   ','just joey '         ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Eric Schaffeer         ','ericschaefer@me.com                                 ','                                                ','              ','Philadelphia  ','USA                 ','                   ','keep smiling '      ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Alina Kane             ','alinak33@gmail.com                                  ','                                                ','              ','Philadelphia  ','USA                 ','                   ','lady marmalade '    ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Joyce Daniels          ','joyce.daniels1234@gmail.com                         ','40 Albany Road                                  ','Norwich       ','Norfolk       ','UK                  ','NR3 1EE            ','lavender lassie '   ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Rosy Daniels           ','rosyapple30@live.co.uk                              ','11 Waterloo Road                                ','Norwich       ','Norfolk       ','UK                  ','NR3 1EH            ','love knot '         ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Katy Daniels           ','katydaniels17@hotmail.com                           ','36 Salisbury Place, Langton Road                ','Oval          ','London        ','UK                  ','SW9 6UW            ','lovely lady '       ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Meenaa Azmayesh        ','meenaa.azmayesh@dentons.com                         ','Flat 109, Arlington Building, 60 Fairfield Road ','London        ','London        ','UK                  ','E3 2UB             ','mama mia '          ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Nick Oliver            ','nick@free-space.org.uk                              ','17 Lombard Street                               ','Portsmouth    ','Portsmouth    ','UK                  ','PO1 2HT            ','mary rose'          ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Tracey Murrant         ','tracey.murrant@googlemail.com                       ','15 Woodrow Place                                ','Norwich       ','Norfolk       ','UK                  ','NR1 4PF            ','nice day '          ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Tamara Addis           ','tammytimothy@hotmail.com                            ','2 Candie Apartments, Candie Road                ','St Peter Port ','Guernsey      ','Channel Islands, UK ','GY1 1UQ            ','norfolk glory '     ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Laura Sanchez          ','laura.snchz@gmail.com                               ','Flat 8, 20 Garden Walk                          ','London        ','London        ','UK                  ','EC2A 3EU           ','pearl drift '       ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'David Grant            ','emily.tomassi@gmail.com, david.john.grant@gmail.com ','4 Mandrell Road                                 ','London        ','London        ','UK                  ','SW2 5DL            ','penny lane'         ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Oli Weiz               ','Oliver.Weiss@bllaw.co.uk                            ','Flat 14 Cathay House, Cathay Street             ','Bermondsy     ','London        ','UK                  ','SE16 4TS           ','peppermint ice '    ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Christian Weisspfennig ','christian@weisspfennig.com                          ','7a York Mansions, 215 Earl''s Court Road        ','Earls Court   ','London        ','UK                  ','SW5 9AF            ','pretty polly '      ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Som Gosh               ','som.gosh@gmail.com                                  ','Flat 1, 26 Charing Cross Road                   ','London        ','London        ','UK                  ','WC2H 0DG           ','rambling rosie '    ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Tania Bowler           ','taniabowler1@gmail.com                              ','62 Damgate Street                               ','Wymondham     ','Norfolk       ','UK                  ','NR18 0BQ           ','summer wine '       ); 
insert into party (party_name, email_address, mailing_address_1, city, state, country, postal_code, secret_word ) values ( 'Joyce Sheena           ','                                                    ','Orteliusstraat 22 1 hoog. 1057 BA               ','Amsterdam     ','              ','The Netherlands     ','                   ','sunset boulevard  ' ); 


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
    entree_name        varchar(100)  not null default '',    
    entree_description varchar(100) not null default ''    , 
    primary key ( id) 
); 

insert into entree (entree_name, entree_description ) values ('chicken stuff','chicken stir fry') ; 
insert into entree (entree_name, entree_description ) values ('beef stuff','beef stir fry') ; 

ALTER TABLE guest_detail ADD FOREIGN KEY (party_id) REFERENCES party (id) ON UPDATE NO ACTION ON DELETE NO ACTION;  
ALTER TABLE guest_detail ADD FOREIGN KEY (entree_id) REFERENCES entree (id)     ON UPDATE NO ACTION ON DELETE NO ACTION;  


