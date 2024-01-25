ALTER TABLE activity
    ADD title VARCHAR(255) NULL;

ALTER TABLE activity
    DROP COLUMN type;

ALTER TABLE activity
    ADD type VARCHAR(255) NULL;