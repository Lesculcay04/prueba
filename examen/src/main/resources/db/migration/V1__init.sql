CREATE TABLE IF NOT EXISTS conference(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    city VARCHAR(255)NOT NULL,
    total_assistains  INT NOT NULL
    );
CREATE TABLE IF NOT EXISTS assistant(
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    age INT,
    conference_id INT NOT NULL,
    FOREIGN KEY (conference_id) REFERENCES conference(id)
    );
