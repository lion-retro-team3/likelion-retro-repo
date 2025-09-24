use OrderProject;

create table Restaurant(
	Restaurant_ID INT PRIMARY KEY AUTO_INCREMENT,
    Restaurnat_name VARCHAR(50) NOT NULL

);

create table Menu(
	Menu_ID        INT PRIMARY KEY AUTO_INCREMENT,
    Restaurant_ID  INT NOT NULL,
	Menu_name      VARCHAR(50) NOT NULL,
    Price          INT NOT NULL,
    FOREIGN KEY (Restaurant_ID) REFERENCES Restaurant(Restaurant_ID)
);

create table Orders(
	Order_ID 		INT PRIMARY KEY AUTO_INCREMENT,
	Restaurant_ID  	INT NOT NULL,
    Menu_ID 		INT NOT NULL,
    Order_time 		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Order_status	Enum('receive','cooking','delivering','complete') default 'receive',
    FOREIGN KEY (Restaurant_ID) REFERENCES Restaurant(Restaurant_ID),
    FOREIGN KEY (Menu_ID) REFERENCES Menu(Menu_ID)
    
);