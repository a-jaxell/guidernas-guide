CREATE TABLE activity
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    status               VARCHAR(255)          NOT NULL,
    `description`        VARCHAR(255)          NULL,
    start_time           datetime              NOT NULL,
    end_time             datetime              NOT NULL,
    host_organization_id BIGINT                NULL,
    type                 SMALLINT              NULL,
    is_ended             BIT(1)                NOT NULL,
    is_started           BIT(1)                NOT NULL,
    CONSTRAINT pk_activity PRIMARY KEY (id)
);

CREATE TABLE activity_attendee
(
    activity_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT pk_activity_attendee PRIMARY KEY (activity_id, customer_id)
);

CREATE TABLE activity_guide
(
    activity_id BIGINT NOT NULL,
    guide_id    BIGINT NOT NULL,
    CONSTRAINT pk_activity_guide PRIMARY KEY (activity_id, guide_id)
);

CREATE TABLE customer
(
    id         BIGINT       NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE guide
(
    id         BIGINT       NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    CONSTRAINT pk_guide PRIMARY KEY (id)
);

CREATE TABLE `organization`
(
    id                BIGINT       NOT NULL,
    organization_name VARCHAR(255) NOT NULL,
    `description`     VARCHAR(255) NULL,
    CONSTRAINT pk_organization PRIMARY KEY (id)
);

CREATE TABLE organization_associated_guides
(
    guide_id        BIGINT NOT NULL,
    organization_id BIGINT NOT NULL,
    CONSTRAINT pk_organization_associated_guides PRIMARY KEY (guide_id, organization_id)
);

CREATE TABLE qualification
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    issue_date    datetime              NULL,
    expiry_date   datetime              NULL,
    user_id       BIGINT                NULL,
    CONSTRAINT pk_qualification PRIMARY KEY (id)
);

CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NULL,
    updated_at datetime              NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE activity
    ADD CONSTRAINT FK_ACTIVITY_ON_HOST_ORGANIZATION FOREIGN KEY (host_organization_id) REFERENCES `organization` (id);

ALTER TABLE customer
    ADD CONSTRAINT FK_CUSTOMER_ON_ID FOREIGN KEY (id) REFERENCES user (id);

ALTER TABLE guide
    ADD CONSTRAINT FK_GUIDE_ON_ID FOREIGN KEY (id) REFERENCES user (id);

ALTER TABLE `organization`
    ADD CONSTRAINT FK_ORGANIZATION_ON_ID FOREIGN KEY (id) REFERENCES user (id);

ALTER TABLE qualification
    ADD CONSTRAINT FK_QUALIFICATION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE activity_attendee
    ADD CONSTRAINT fk_actatt_on_activity FOREIGN KEY (activity_id) REFERENCES activity (id);

ALTER TABLE activity_attendee
    ADD CONSTRAINT fk_actatt_on_customer FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE activity_guide
    ADD CONSTRAINT fk_actgui_on_activity FOREIGN KEY (activity_id) REFERENCES activity (id);

ALTER TABLE activity_guide
    ADD CONSTRAINT fk_actgui_on_guide FOREIGN KEY (guide_id) REFERENCES guide (id);

ALTER TABLE organization_associated_guides
    ADD CONSTRAINT fk_orgassgui_on_guide FOREIGN KEY (guide_id) REFERENCES guide (id);

ALTER TABLE organization_associated_guides
    ADD CONSTRAINT fk_orgassgui_on_organization FOREIGN KEY (organization_id) REFERENCES `organization` (id);