CREATE TABLE RETAIL_CUSTOMER (CUSTOMER_ID VARCHAR2(20), CUSTOMER_NAME VARCHAR2(30) );
CREATE TABLE RETAIL_TRANSACTION (TRANSACTION_ID VARCHAR2(50),CUSTOMER_ID VARCHAR2(50) ,TRANSACTION_DATE TIMESTAMP,AMOUNT_SPENT DOUBLE);
INSERT INTO RETAIL_CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values ('P2800','Aziz');
INSERT INTO RETAIL_CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values ('P2802','Mohd');
INSERT INTO RETAIL_CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values ('P2804','Abdul');
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('0d95256c-0d52-43c2-b457-48216dc3fa4d','P2800','2023-07-22 09:01:15',120);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('b811f4ac-8ec4-44d3-b0df-47ec0c576684','P2800','2023-07-01 08:01:15',90);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('44dc87c0-bc78-4e5b-9204-cce0181ce174','P2800','2023-08-07 12:01:15',160);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('c42989d7-3c6d-4458-97d6-c620bcd0c5c7','P2800','2023-08-01 08:01:15',90);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('7f5be4c3-f073-4091-82a5-3e2ecd84fa9e','P2800','2023-09-04 09:01:15',120);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('20edc786-cef8-494f-9b91-956936d9da5a','P2800','2023-09-12 12:01:15',165);  
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('c15b8798-916e-4da7-b6c6-89e07bba7622','P2802','2023-07-05 09:01:15',113);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('a00651aa-a11a-4c72-8f9e-69a58081a86a','P2802','2023-07-08 08:01:15',80);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('9650cca8-f795-4d58-8a8a-377b94e323ca','P2802','2023-08-04 09:01:15',102);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('d544bb98-e192-4182-854f-2562696bd18e','P2802','2023-08-01 12:01:15',210);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('a2cd58ca-9956-4a96-b683-844907723b5f','P2802','2023-09-27 09:01:15',130);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('cbaacd1b-3a9b-4db4-8171-3d79677050b3','P2802','2023-09-15 08:01:15',88);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('24635d40-f374-4364-bc8f-2dc1c3155515','P2804','2023-07-05 09:01:15',102);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('8bb6bd68-c1de-4091-9a32-7e2f638cd654','P2804','2023-07-27 12:01:15',84);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('717d5851-c9cc-4488-b1a6-41ccaa8bfe81','P2804','2023-08-04 09:01:15',200);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('eb6931a1-60b1-45c8-9eba-5f7b015dcab0','P2804','2023-08-01 08:01:15',103);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('577466d3-65ac-4a4c-88a1-9b24bf6c2393','P2804','2023-09-27 09:01:15',500);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('69a2416e-f300-4071-89f1-f4a16fb4d15c','P2804','2023-09-20 08:01:15',585);
INSERT INTO RETAIL_TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT_SPENT) VALUES ('8770e8af-5f1f-4f31-a56b-472f6bd74123','P2804','2023-08-14 12:01:15',102);
COMMIT;