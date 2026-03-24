-- =========================
-- SEED DATA
-- =========================
USE crs_system;

-- Roles
INSERT IGNORE INTO roles (role_name)
VALUES ('ADMIN'), ('ACADEMIC_OFFICER');

-- Users (passwords are jBCrypt hashes of 'Admin@123' and 'Officer@123')
INSERT IGNORE INTO users (user_id, username, password, full_name, email, status)
VALUES
(1, 'admin',   '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
               'Course Administrator', 'admin@crs.local',   'ACTIVE'),
(2, 'officer', '$2a$10$8K1p/a0dR1xqM4K3e5v2AeqkBvY8.nMj5g1t2OeP3s7u0yHmKlXQi',
               'Academic Officer',    'officer@crs.local',  'ACTIVE');

-- User roles
INSERT IGNORE INTO user_roles (user_id, role_id)
VALUES (1, 1), (2, 2);

-- Students
INSERT IGNORE INTO students (student_id, student_code, name, programme, year_of_study, current_semester, cgpa)
VALUES
(101, '2025A1234', 'Alex Tan',    'Bachelor of Computer Science',        1, 1, 1.95),
(102, '2025A1235', 'Brenda Lim',  'Bachelor of Computer Science',        1, 2, 2.80),
(103, '2025A1236', 'Chris Wong',  'Bachelor of Information Technology',  2, 1, 1.70);

-- Courses
INSERT IGNORE INTO courses (course_id, course_code, course_name, credit_hours)
VALUES
(201, 'CS201', 'Data Structures',      3),
(202, 'CS205', 'Database Systems',     3),
(203, 'CS210', 'Software Engineering', 3);

-- Student course results
INSERT IGNORE INTO student_course_results
    (student_id, course_id, semester, grade, grade_point, marks, attempt_number, status)
VALUES
(101, 201, '2025/1', 'F',  0.00, 38.00, 1, 'FAILED'),
(101, 202, '2025/1', 'B+', 3.33, 74.00, 1, 'PASSED'),
(102, 201, '2025/1', 'A',  4.00, 88.00, 1, 'PASSED'),
(103, 203, '2025/1', 'F',  0.00, 42.00, 1, 'FAILED'),
(103, 202, '2025/1', 'F',  0.00, 35.00, 1, 'FAILED');

-- Recovery plans
INSERT IGNORE INTO recovery_plans
    (plan_id, student_id, course_id, attempt_number, status, recommendation, start_date, end_date)
VALUES
(301, 101, 201, 1, 'ACTIVE',
     'Attend weekly revision sessions and resit the final exam.',
     '2026-03-01', '2026-04-15'),
(302, 103, 203, 1, 'ACTIVE',
     'Complete all missing assessment components.',
     '2026-02-15', '2026-04-30');

-- Milestones
INSERT IGNORE INTO recovery_milestones
    (milestone_id, plan_id, title, description, due_date, status)
VALUES
(401, 301, 'Week 1 Review',       'Review lecture topics 1 to 4.',         '2026-03-10', 'COMPLETED'),
(402, 301, 'Lecturer Meeting',    'Meet lecturer for progress feedback.',   '2026-03-18', 'PENDING'),
(403, 302, 'Assessment Reattempt','Sit for full assessment reattempt.',     '2026-03-05', 'OVERDUE');

-- Eligibility records
INSERT IGNORE INTO eligibility_records
    (student_id, semester, year_of_study, cgpa, failed_count, is_eligible, reason, checked_by)
VALUES
(101, 1, 1, 1.95, 1, FALSE, 'CGPA below minimum threshold of 2.0', 1),
(102, 2, 1, 2.80, 0, TRUE,  'Meets all eligibility criteria', 1),
(103, 1, 2, 1.70, 2, FALSE, 'CGPA below minimum threshold of 2.0', 1);
