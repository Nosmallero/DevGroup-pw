INSERT INTO credit_card(id, number_card, security_Code, type_card, expiration_date) VALUES
	(1, '9875a7', 123, 'Visa', '12Nov'),
	(2, '879e2a', 322, 'Master', '07Sept'),
	(3, '98743a', 783, 'Scotiabank', '14oct');
	
INSERT INTO reservation_payment(id, name_reservation, payment_amount, credit_card_id) VALUES
	(1, 'Pago de 2 mesa', 58, 3),
	(2, 'Pago de 3 mesas', 20, 1),
	(3, 'Pago de 4 mesas', 21, 2);