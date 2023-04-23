--Languages
create table if not exists LANGUAGE (
    LANGUAGE_ID bigserial, --LANGUAGE_ID int8
    LANGUAGE_CODE varchar(8) not null,
    LANGUAGE_NAME varchar(32) not null,
    constraint LANGUAGES_PK primary key (LANGUAGE_ID)
);

--Word
create table if not exists WORD (
    WORD_ID bigserial,
    WORD_LANGUAGE_CODE varchar(8) not null,
    WORD_VALUE varchar(50) not null,
    constraint WORD_PK primary key (WORD_ID),
    constraint WORD_LANGUAGE_CODE_FK foreign key (WORD_LANGUAGE_CODE)
        references LANGUAGE (LANGUAGE_CODE));

--Translation
create table if not exists TRANSLATION (
    TRANSLATION_ID bigserial,
    TRANSLATION_WORD_1_ID int8 not null,
    TRANSLATION_WORD_2_ID int8 not null ,
    WORD_ID int8 not null,
    constraint TRANSLATION_ID_PK primary key (TRANSLATION_ID),
    constraint WORD_ID_FK foreign key (WORD_ID)
        references WORD (WORD_ID));
/*create table if not exists TRANSLATION (
    TRANSLATION_ID bigserial,
    TRANSLATION_WORD_1_ID int8 not null,
    TRANSLATION_WORD_2_ID int8 not null ,
    constraint TRANSLATION_ID_PK primary key (TRANSLATION_ID),
    constraint TRANSLATION_WORD_1_ID_FK foreign key (TRANSLATION_WORD_1_ID)
        references WORD (WORD_ID),
        constraint TRANSLATION_WORD_2_ID_FK foreign key (TRANSLATION_WORD_2_ID)
        references WORD(WORD_ID));*/