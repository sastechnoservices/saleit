CREATE TABLE rtl_shop (
    shop_id varchar(255),
    shop_name varchar(255),
    shop_address varchar(255),
    contact_number varchar(255),
    email_address varchar(255),
    shop_type varchar(255),
    PRIMARY KEY (shop_id)
);
CREATE TABLE cart (
    item_id varchar(255),
    item_quantity varchar(255),
    item_price varchar(255)
    );

CREATE TABLE rtl_item (
    item_id varchar(255),
    item_name varchar(255),
    item_description varchar(255),
    item_price varchar(255),
    availability varchar(255),
    item_image_id varchar(255),
    shop_id varchar(255),
     PRIMARY KEY (item_id),
    FOREIGN KEY (shop_id) REFERENCES rtl_shop(shop_id)
   );

CREATE TABLE rtl_imgage (
    image_id varchar(255),
    item_array varchar(500000),
    PRIMARY KEY (image_id)
   );
CREATE TABLE rtl_user(
    user_id varchar(255),
    user_name varchar(255),
    user_contact_number varchar(255),
    user_email_address varchar(255),
    user_address varchar(255),
    password varchar(5000),
    usertype varchar(255),
     PRIMARY KEY (user_id)
   );
   
   CREATE TABLE rtl_order(
    order_id varchar(255),
    order_elements varchar(255),
    order_total_amount varchar(255),
    order_amount_to_paid varchar(255),
    shop_id varchar(255),
    customer_id varchar(255),
    order_status varchar(255),
    order_date varchar(255),
    PRIMARY KEY (order_id),
    FOREIGN KEY (shop_id) REFERENCES rtl_shop(shop_id),
    FOREIGN KEY (customer_id) REFERENCES rtl_user(user_id)
   );
   