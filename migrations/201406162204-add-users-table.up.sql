CREATE TABLE public.entree  ( 
    id                	serial NOT NULL,
    entree_name       	varchar(100) NOT NULL DEFAULT ''::character varying,
    entree_description	varchar(100) NOT NULL DEFAULT ''::character varying,
    PRIMARY KEY(id)
);

CREATE TABLE public.guest_detail  ( 
    id          	serial NOT NULL,
    guest_id    	serial NOT NULL,
    entree      	varchar(100) NOT NULL DEFAULT ''::character varying,
    entree_notes	varchar(4000) NULL,
    guest       	varchar(100) NULL,
    PRIMARY KEY(id,guest_id)
);


CREATE TABLE public.party  ( 
    id                       	serial NOT NULL,
    party_name               	varchar(100) NOT NULL DEFAULT ''::character varying,
    email_address            	varchar(500) NOT NULL DEFAULT ''::character varying,
    estimated_number_in_party	int4 NOT NULL DEFAULT 2,
    country                  	varchar(50) NOT NULL DEFAULT ''::character varying,
    city                     	varchar(100) NOT NULL DEFAULT ''::character varying,
    state                    	varchar(100) NOT NULL DEFAULT ''::character varying,
    postal_code              	varchar(100) NOT NULL DEFAULT ''::character varying,
    mailing_address_1        	varchar(100) NOT NULL DEFAULT ''::character varying,
    mailing_address_2        	varchar(100) NOT NULL DEFAULT ''::character varying,
    mailing_address_3        	varchar(100) NOT NULL DEFAULT ''::character varying,
    flag_sent_mail           	varchar(25) NULL,
    flag_accepted            	varchar(10) NULL,
    secret_word              	varchar(100) NOT NULL DEFAULT ''::character varying,
    PRIMARY KEY(id)
);

ALTER TABLE guest_detail ADD FOREIGN KEY (party_id) REFERENCES party (id) ON UPDATE NO ACTION ON DELETE NO ACTION;  
-- ALTER TABLE guest_detail ADD FOREIGN KEY (entree_id) REFERENCES entree (id)     ON UPDATE NO ACTION ON DELETE NO ACTION;  
