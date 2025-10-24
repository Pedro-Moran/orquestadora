CREATE SCHEMA KUSU;

create table KUSU.T_KUSU_CUST_USER_PROFILE (
   G_USER_ACCOUNT_ID    VARCHAR(36)          not null,
   G_USER_ID            VARCHAR(36)          not null,
   G_ROLE_PERSON_ID     VARCHAR(50)          not null,
   constraint C_KUSU_CUST_USER_PROFILE primary key (G_USER_ACCOUNT_ID)
);

create table KUSU.T_KUSU_USER (
   G_USER_ID            VARCHAR(36)          not null,
   GF_PERSONAL_ID       VARCHAR(25)          not null,
   constraint C_KUSU_USER primary key (G_USER_ID)
);