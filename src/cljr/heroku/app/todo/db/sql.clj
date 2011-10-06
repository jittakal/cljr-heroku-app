(ns cljr.heroku.app.todo.db.sql)

;-- Sequence: todoitemseq

;-- DROP SEQUENCE todoitemseq;

;CREATE SEQUENCE todoitemseq
;  INCREMENT 1
;  MINVALUE 1
;  MAXVALUE 9223372036854775807
;  START 1
;  CACHE 1;
;ALTER TABLE todoitemseq OWNER TO postgres;


;-- Sequence: todolistseq

;-- DROP SEQUENCE todolistseq;

;CREATE SEQUENCE todolistseq
;  INCREMENT 1
;  MINVALUE 1
;  MAXVALUE 9223372036854775807
;  START 1
;  CACHE 1;
;ALTER TABLE todolistseq OWNER TO postgres;


;-- Table: todolist

;-- DROP TABLE todolist;

;CREATE TABLE todolist
;(
;  "name" text NOT NULL,
;  id integer NOT NULL DEFAULT nextval('todolistseq'::regclass),
;  CONSTRAINT "primary key" PRIMARY KEY (id),
;  CONSTRAINT "unique-name" UNIQUE (name)
;)
;WITH (
;  OIDS=FALSE
;);
;ALTER TABLE todolist OWNER TO postgres;
;COMMENT ON TABLE todolist IS 'todolist';


;-- Table: todoitem

;-- DROP TABLE todoitem;

;-- Table: todoitem

;-- DROP TABLE todoitem;

;CREATE TABLE todoitem
;(
;  id integer NOT NULL DEFAULT nextval('todoitemseq'::regclass),
;  description text NOT NULL,
;  todolistid integer NOT NULL,
;  createddate date NOT NULL DEFAULT ('now'::text)::date,
;  duedate date DEFAULT ('now'::text)::date,
;  completed boolean NOT NULL DEFAULT false,
;  CONSTRAINT primarykey PRIMARY KEY (id),
;  CONSTRAINT foreignkey FOREIGN KEY (todolistid)
;      REFERENCES todolist (id) MATCH SIMPLE
;      ON UPDATE NO ACTION ON DELETE NO ACTION
;)
;WITH (
;  OIDS=FALSE
;);
;ALTER TABLE todoitem OWNER TO postgres;
;COMMENT ON TABLE todoitem IS 'todoitem';


