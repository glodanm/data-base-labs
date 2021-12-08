use lab7;

SET GLOBAL log_bin_trust_function_creators = 1;
-- Task №1 для discipline шукати MIN стовпця semester_number

DROP FUNCTION IF EXISTS get_min_semester_number;
DELIMITER // 
CREATE FUNCTION get_min_semester_number()
RETURNS DECIMAL(10, 1) 
BEGIN
return(
SELECT MIN(semester_number)
FROM discipline
);
END //  
DELIMITER ;

SELECT get_min_semester_number();
-- 2. Написати функцію, яка витягує за ключем між таблицями Посада та Співробітники значення поля Назва вченого звання.
-- Потім зробити вибірку усіх даних (SELECT) з таблиці Співробітники, використовуючи дану функцію.
DROP FUNCTION IF EXISTS get_academic_status;
DELIMITER //
CREATE FUNCTION get_academic_status(
	key_id int
)
RETURNS VARCHAR(45)
DETERMINISTIC
BEGIN
	return(SELECT name from position where id = (SELECT degree_id FROM coworker where id = key_id));
END//
DELIMITER ;
select surname, name, get_academic_status(id) from coworker;