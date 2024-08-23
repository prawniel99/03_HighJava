







-----------------------------------------------------------------------------
-- private 자료형이름 변수명;
select 'private ' || 
    decode(lower(data_type), 'number ', 'int ', 'String ') ||
    lower(column_name) || ';'
from cols
where table_name='JDBC_BOARD';



select * from jdbc_board
where board_title like '%첫번째%';



select 'private ' || 
    decode(lower(data_type), 'number ', 'int ', 'String ') ||
    lower(column_name) || ';'
from cols
where table_name='LPROD';


SELECT 
    ' private '||
   DECODE( DATA_TYPE , 'NUMBER', 'int ', 'String ' )||
    LOWER(COLUMN_NAME)||';'
FROM COLS
WHERE TABLE_NAME = 'LPROD'
ORDER BY COLUMN_ID;


























