CREATE DATABASE IF NOT EXISTS user_db;
CREATE DATABASE IF NOT EXISTS etudiant_db;
CREATE DATABASE IF NOT EXISTS formateur_db;
CREATE DATABASE IF NOT EXISTS formation_data_db;

CREATE USER IF NOT EXISTS 'newUsers'@'%' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON user_db.* TO 'newUsers'@'%';
GRANT ALL PRIVILEGES ON etudiant_db.* TO 'newUsers'@'%';
GRANT ALL PRIVILEGES ON formateur_db.* TO 'newUsers'@'%';
GRANT ALL PRIVILEGES ON formation_data_db.* TO 'newUsers'@'%';

FLUSH PRIVILEGES;
