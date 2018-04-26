DROP DATABASE IF EXISTS SmartOffice;
CREATE DATABASE IF NOT EXISTS SmartOffice;
USE SmartOffice;

DROP TABLE IF EXISTS dept_emp,
                     dept_manager,
                     titles,
                     salaries, 
                     employees, 
					 departments,
                     meeting_rooms,
                     reservations;

CREATE TABLE employees(
	emp_no		INT				NOT NULL,
	first_name	VARCHAR(30) 	NOT NULL,
    last_name	VARCHAR(30) 	NOT NULL,
    gsm 		CHAR(13)		NOT NULL,
    gender 		ENUM ('M','F') 	NOT NULL,
	birth_date 	DATE 			NOT NULL,
    hire_date	DATE 			NOT NULL,
    address		VARCHAR(100),
    
    PRIMARY KEY(emp_no)
);

CREATE TABLE departments (
    dept_no     INT         	NOT NULL,
    dept_name   VARCHAR(40)     NOT NULL,
    PRIMARY KEY (dept_no),
    UNIQUE  KEY (dept_name)
);

CREATE TABLE dept_manager (
   emp_no       INT             NOT NULL,
    dept_no     INT         	NOT NULL,
   from_date    DATE            NOT NULL,
   to_date      DATE            NOT NULL,
   FOREIGN KEY (emp_no)  REFERENCES employees (emp_no)    ON DELETE CASCADE,
   FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
   PRIMARY KEY (emp_no,dept_no)
); 

CREATE TABLE dept_emp (
    emp_no      INT             NOT NULL,
    dept_no     INT         	NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE            NOT NULL,
    FOREIGN KEY (emp_no)  REFERENCES employees   (emp_no)  ON DELETE CASCADE,
    FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no,dept_no)
);

CREATE TABLE titles (
    emp_no      INT             NOT NULL,
    title       VARCHAR(50)     NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE,
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no, title, from_date)
); 

CREATE TABLE salaries (
    emp_no      INT             NOT NULL,
    salary      INT             NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE            NOT NULL,
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no, from_date)
);

CREATE TABLE meeting_rooms(
	room_no				INT					NOT NULL,
    dept_no     		INT         		NOT NULL,
    temperature			DECIMAL,
	curtain_status		TINYINT		UNSIGNED,
    light_status		TINYINT(1),
    projection_status 	TINYINT(1),
    availability		TINYINT(1),
    
    FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
	PRIMARY KEY(room_no, dept_no)
);

CREATE TABLE reservations(
	room_no				INT					NOT NULL,
    dept_no     		INT         		NOT NULL,
    emp_no      		INT             	NOT NULL,
	booked_at			TIMESTAMP			NOT NULL,
	FOREIGN KEY (room_no) REFERENCES meeting_rooms (room_no) ON DELETE CASCADE,
    FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    PRIMARY KEY(room_no, dept_no, booked_at)
);
