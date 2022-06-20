INSERT INTO credit_card(id, number_card, security_Code, type_card, expiration_date) VALUES
	(1, '5551779059069436', 123, 'Banco de la nacion','12Nov2022'),
	(2, '6661779059069436', 322, 'BCP', '07Sept2022'),
	(3, '7771779059069436', 783, 'Scotiabank', '14Dic2022'),
	(4, '8888179059069436', 783, 'Interbank', '17Oct2022'),
	(5, '9999177059069436', 783, 'Paypal', '19Ago2022');
	
INSERT INTO reservation_payment(id, name_reservation, payment_amount, credit_card_id) VALUES
	(1, 'Reserva de 1 mesa', 20, 5),
	(2, 'Reserva de 2 mesas', 40, 4),
	(3, 'Reserva de 3 mesas', 60, 3),
	(4, 'Reserva de 4 mesas', 80, 2),
	(5, 'Reserva de 5 mesas', 100, 1);