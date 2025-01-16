
CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          role VARCHAR(255)
);


CREATE TABLE projects (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          deadline DATE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       deadline DATE,
                       status task_status NOT NULL,
                       priority task_priority NOT NULL,
                       project_id INT NOT NULL,
                       CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE
);


CREATE TABLE employee_projects (
                                   employee_id INT NOT NULL,
                                   project_id INT NOT NULL,
                                   PRIMARY KEY (employee_id, project_id),
                                   CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE,
                                   CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE
);

CREATE TABLE employee_tasks
(
    employee_id INT NOT NULL,
    task_id     INT NOT NULL,
    PRIMARY KEY (employee_id, task_id),
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE,
    CONSTRAINT fk_task FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE
);
CREATE TYPE task_status AS ENUM ('TO_DO', 'IN_PROGRESS', 'DONE');


CREATE TYPE task_priority AS ENUM ('LOW', 'MEDIUM', 'HIGH');
